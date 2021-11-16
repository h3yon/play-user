package toy.playvip.user.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class UserServiceTest1 {
//
//    @InjectMocks
//    UserService userService;
//    @Mock
//    PasswordEncoder passwordEncoder;
//    @Mock
//    UserRepository userRepository;
//    @Mock
//    JwtUtil jwtUtil;
////    @Mock
////    RedisUtil redisUtil;
//
//    final String TEST_EMAIL = "email@naver.com";
//    final String TEST_PASSWORD = "Password1!";
//    final String TEST_USERNAME = "이름";
//
//    @BeforeEach
//    void 테스트유저(){
//        User testUser = User.builder()
//                .email(TEST_EMAIL)
//                .password(TEST_PASSWORD)
//                .username("개구리")
//                .role(1)
//                .build();
//        userRepository.save(testUser);
//    }
//
//    @Test
//    @Order(1)
//    void 회원가입() throws BaseException {
//        //given
//        SignupRequestDto signupRequestDto = new SignupRequestDto();
//        signupRequestDto.setEmail(TEST_EMAIL);
//        signupRequestDto.setPassword(TEST_PASSWORD);
//        signupRequestDto.setUsername(TEST_USERNAME);
//
//        //when
//        User result = userService.createUser(signupRequestDto);
//
//        //then
//        Assertions.assertThat(result.getEmail()).isEqualTo(TEST_EMAIL);
//
//    }
//
//    @Test
//    @Order(2)
//    void 이름으로_유저_찾기(){
//        //when
//        User result = userRepository.findByUsername("개구리").get();
//        //then
//        Assertions.assertThat(result.getEmail()).isEqualTo("개구리");
//    }
//
//    // FIRST
//


}