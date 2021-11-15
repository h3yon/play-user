package toy.playvip.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import toy.playvip.common.BaseException;
import toy.playvip.dto.request.SignupRequestDto;
import toy.playvip.entity.User;
import toy.playvip.repository.UserRepository;
import toy.playvip.utils.JwtUtil;
import toy.playvip.utils.RedisUtil;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;
    @Mock
    PasswordEncoder passwordEncoder;
    @Mock
    UserRepository userRepository;
    @Mock
    JwtUtil jwtUtil;
    @Mock
    RedisUtil redisUtil;

    final String TEST_EMAIL = "email@naver.com";
    final String TEST_PASSWORD = "Password1!";
    final String TEST_USERNAME = "이름";

    @BeforeEach
    void 테스트유저(){
        User testUser = User.builder()
                .email(TEST_EMAIL)
                .password(TEST_PASSWORD)
                .username("개구리")
                .role(1)
                .build();
        userRepository.save(testUser);
    }

    @Test
    @Order(1)
    void 회원가입() throws BaseException {
        //given
        SignupRequestDto signupRequestDto = new SignupRequestDto();
        signupRequestDto.setEmail(TEST_EMAIL);
        signupRequestDto.setPassword(TEST_PASSWORD);
        signupRequestDto.setUsername(TEST_USERNAME);

        //when
        User result = userService.createUser(signupRequestDto);

        //then
        Assertions.assertThat(result.getEmail()).isEqualTo(TEST_EMAIL);

    }

    @Test
    @Order(2)
    void 이름으로_유저_찾기(){
        //when
        User result = userRepository.findByUsername("개구리").get();
        //then
        Assertions.assertThat(result.getEmail()).isEqualTo("개구리");
    }

    // FIRST



}