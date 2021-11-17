package toy.playvip.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import toy.playvip.common.exception.BaseException;
import toy.playvip.common.exception.SignException;
import toy.playvip.common.response.Status;
import toy.playvip.config.JwtTokenProvider;
import toy.playvip.user.domain.User;
import toy.playvip.user.dto.request.SigninRequestDto;
import toy.playvip.user.dto.request.SignupRequestDto;
import toy.playvip.user.dto.response.TokenResponseDto;
import toy.playvip.user.dto.response.UserInfoResponseDto;
import toy.playvip.user.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static toy.playvip.common.exception.SignExceptionCode.FAIL_SIGNUP_OVERLAPPED_EMAIL;
import static toy.playvip.common.exception.SignExceptionCode.NO_EXISTS_EMAIL;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
//    private final RedisUtil redisUtil;

    public UserInfoResponseDto createUser(SignupRequestDto signupRequestDto) {

        if(validateEmail(signupRequestDto.getEmail())){
            throw new SignException(FAIL_SIGNUP_OVERLAPPED_EMAIL);
        }

        String encodedPassword = passwordEncoder.encode(signupRequestDto.getPassword());

        User user = User.builder()
                .email(signupRequestDto.getEmail())
                .password(encodedPassword)
                .username(signupRequestDto.getUsername())
                .roles(Collections.singletonList("ROLE_USER"))
                .build();

        userRepository.save(user);
        return new UserInfoResponseDto(user);
    }

    public String loginUser(SigninRequestDto signinRequestDto) {

        String email = signinRequestDto.getEmail();
        String password = signinRequestDto.getPassword();

        User user = userRepository.findByEmail(email).get();
        Assert.notNull(user, "profiles must not be null");

        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new BaseException(Status.USERNAME_PASSWORD_ERROR);

        return jwtTokenProvider.createToken(String.valueOf(user.getEmail()), user.getRoles());

    }

    public User getMemberInfo(String email) {
        return userRepository.findByEmail(email)
                //                .map(UserResponseDto::of)
                .orElseThrow(() -> new SignException(NO_EXISTS_EMAIL));
    }

    public List<UserInfoResponseDto> findAllUsers(){
        return userRepository.findAll().stream().map(UserInfoResponseDto::new).collect(Collectors.toList());
    }

    private boolean validateEmail(String email){
        return userRepository.existsByEmail(email);
    }
}
