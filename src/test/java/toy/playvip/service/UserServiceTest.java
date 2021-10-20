package toy.playvip.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import toy.playvip.dto.request.SignupRequestDto;
import toy.playvip.entity.User;
import toy.playvip.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    UserService userService;
    UserRepository userRepository;

    @Test
    void 회원가입_후_로그인() {
        //given
        SignupRequestDto signupRequestDto = new SignupRequestDto();
        signupRequestDto.setEmail("string");
        signupRequestDto.setPassword("string");
        signupRequestDto.setUsername("string");

        //when
//        User user = User.builder()
//                .email(signupRequestDto.getEmail())
//                .password(encodedPassword)
//                .username(signupRequestDto.getUsername())
//                .role(1)
//                .build();
//        User findUser = userRepository.findByEmail("string");
//
//        //then
//        Assertions.assertThat(user).isEqualTo(findUser);
    }
}