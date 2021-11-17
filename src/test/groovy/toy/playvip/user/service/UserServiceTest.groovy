package toy.playvip.user.service

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.Specification
import toy.playvip.config.JwtTokenProvider
import toy.playvip.user.domain.User
import toy.playvip.user.dto.request.SignupRequestDto
import toy.playvip.user.dto.response.UserInfoResponseDto
import toy.playvip.user.repository.UserRepository
import toy.playvip.user.service.UserService

@Slf4j
@SpringBootTest(classes = [ UserService.class ])
class UserServiceTest extends Specification {

    @Autowired
    UserService userService;
    @MockBean
    UserRepository userRepository;
    @MockBean
    JwtTokenProvider jwtTokenProvider;
    @MockBean
    PasswordEncoder passwordEncoder;

    def "최대값 테스트"(){
        when:
        def x = Math.max(1,2)
        then:
        x == 2
    }

    def "회원가입 테스트"(){
        given:
        def signupRequestDto = new SignupRequestDto();
        signupRequestDto.setEmail(testEmail)
        signupRequestDto.setPassword(testPassword)
        signupRequestDto.setUsername(testUsername)

        when:
        UserInfoResponseDto result = userService.createUser(signupRequestDto);

        then:
        result == new UserInfoResponseDto(null, testEmail, testUsername, ["ROLE_USER"])
    }

    /**
     * Constans
     */
    private static final String testEmail = "aaa@naver.com"
    private static final String testPassword = "dpdldlqslek1!"
    private static final String testUsername = "aaa"

}
