package toy.playvip.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toy.playvip.dto.request.SigninRequestDto;
import toy.playvip.dto.request.SignupRequestDto;
import toy.playvip.dto.response.TokenResponseDto;
import toy.playvip.entity.User;
import toy.playvip.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    private final String testEmail = "email";
    private final String testPassword = "password";
    private final String testUsername = "usename";

    @Test
    void 회원가입_후_로그인() {
        //given
        SignupRequestDto signupRequestDto = new SignupRequestDto();
        signupRequestDto.setEmail(testEmail);
        signupRequestDto.setPassword(testPassword);
        signupRequestDto.setUsername(testUsername);
        User user = userService.createUser(signupRequestDto);

        //when
        SigninRequestDto signinRequestDto = new SigninRequestDto();
        signinRequestDto.setEmail(testEmail);
        signinRequestDto.setPassword(testPassword);
        TokenResponseDto response = userService.loginUser(signinRequestDto);

        //then
        Assertions.assertThat(response.getEmail()).isEqualTo("email");
    }
}