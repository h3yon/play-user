package toy.playvip.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import toy.playvip.common.exception.BaseException;
import toy.playvip.common.response.Status;
import toy.playvip.user.dto.request.SigninRequestDto;
import toy.playvip.user.dto.request.SignupRequestDto;
import toy.playvip.user.dto.response.TokenResponseDto;
import toy.playvip.user.domain.User;
import toy.playvip.user.repository.UserRepository;
import toy.playvip.utils.JwtUtil;
import toy.playvip.utils.RedisUtil;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
//    private final RedisUtil redisUtil;

    public User createUser(SignupRequestDto signupRequestDto) {

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

        User user = userRepository.findByEmail(email).get();
        Assert.notNull(user, "profiles must not be null");

        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new BaseException(Status.USERNAME_PASSWORD_ERROR);

        String accessToken = jwtUtil.createToken(user.getId(), user.getEmail(), user.getUsername(), user.getRole(), "ACCESS_TOKEN", 30);
        String refreshToken = jwtUtil.createToken(user.getId(), user.getEmail(), user.getUsername(), user.getRole(), "REFRESH_TOKEN", 60 * 24 * 14);
//        redisUtil.set(refreshToken, user.getRole(), 60 * 24 * 14); // 14일

        return TokenResponseOf(user.getId(), email, user.getUsername(), user.getRole(), accessToken, refreshToken);

    }

    public User getMemberInfo(String email) {
        return userRepository.findByEmail(email)
                //                .map(UserResponseDto::of)
                .orElseThrow(() -> new BaseException(Status.NO_EXISTS_INFO));
    }

    private TokenResponseDto TokenResponseOf(Long id, String email, String username, Integer role, String accessToken, String refreshToken) {
        return TokenResponseDto.builder()
                .id(id)
                .email(email)
                .username(username)
                .role(role)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
