package toy.playvip.user.service

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Import
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.Specification
import toy.playvip.user.domain.User
import toy.playvip.user.service.UserService
import toy.playvip.user.dto.request.SignupRequestDto
import toy.playvip.user.repository.UserRepository
import toy.playvip.utils.JwtUtil

import static org.mockito.BDDMockito.given

@Slf4j
@Import(JwtUtil.class)
@SpringBootTest(classes = [ UserService.class ])
class UserServiceTest extends Specification {

    @Autowired
    UserService userService;
    @MockBean
    UserRepository userRepository;
    @MockBean
    PasswordEncoder passwordEncoder;
    @MockBean
    JwtUtil jwtUtil;

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
        User result = userService.createUser(signupRequestDto);

        then:
        result != null
    }

    /**
     * Constans
     */
    private static final String testEmail = "aaa@naver.com"
    private static final String testPassword = "dpdldlqslek1!"
    private static final String testUsername = "aaa"

}
