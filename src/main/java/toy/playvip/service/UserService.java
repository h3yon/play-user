package toy.playvip.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import toy.playvip.common.BaseException;
import toy.playvip.common.Status;
import toy.playvip.dto.request.SigninRequestDto;
import toy.playvip.dto.request.SignupRequestDto;
import toy.playvip.dto.response.TokenResponseDto;
import toy.playvip.entity.User;
import toy.playvip.repository.UserRepository;
import toy.playvip.utils.JwtUtil;
import toy.playvip.utils.RedisUtil;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final RedisUtil redisUtil;

    public User createUser(SignupRequestDto signupRequestDto) {

        // password 수정해야됨
        String encodedPassword = passwordEncoder.encode(signupRequestDto.getPassword());

        User user = User.builder()
                .email(signupRequestDto.getEmail())
                .password(encodedPassword)
                .username(signupRequestDto.getUsername())
                .role(1)
                .build();

        userRepository.save(user);
        return user;
    }

    public TokenResponseDto loginUser(SigninRequestDto signinRequestDto) {

        String email = signinRequestDto.getEmail();
        String password = signinRequestDto.getPassword();

        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new BaseException(Status.NO_EXISTS_INFO)
        );

        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new BaseException(Status.USERNAME_PASSWORD_ERROR);

        String accessToken = jwtUtil.createToken(user.getId(), user.getEmail(), user.getUsername(), user.getRole(), "ACCESS_TOKEN", 30);
        String refreshToken = jwtUtil.createToken(user.getId(), user.getEmail(), user.getUsername(), user.getRole(), "REFRESH_TOKEN", 60 * 24 * 14);

        redisUtil.set(refreshToken, user.getRole(), 60 * 24 * 14); // 14일

        return TokenResponseDto.builder()
                .id(user.getId())
                .email(email)
                .username(user.getUsername())
                .role(user.getRole())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public User getMemberInfo(String email) {
        return userRepository.findByEmail(email)
                //                .map(UserResponseDto::of)
                .orElseThrow(() -> new BaseException(Status.NO_EXISTS_INFO));
    }

    //SecurityContext에서 조회
    //    public User getMyInfo(){
    //        return userRepository.findByEmail(SecurityUtil.getCurrentUserId)
    //                .map(UserResponseDto::of)
    //                .orElseThrow(() -> new BaseException(Status.NO_EXISTS_INFO));
    //    }
}