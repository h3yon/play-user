package toy.playvip.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import toy.playvip.utils.JwtUtil;

import static org.junit.jupiter.api.Assertions.*;

class SecurityConfigTest {

    PasswordEncoder passwordEncoder;
    JwtUtil jwtUtil;

    String TEST_PASSWORD = "Password1!";

    @BeforeEach
    void beforeEach() {
        SecurityConfig securityConfig = new SecurityConfig(jwtUtil);
        passwordEncoder = securityConfig.passwordEncoder();
    }

    @Test
    void 비밀번호_암호화() {
        //given
        String ENCODED_PASSWORD = passwordEncoder.encode("Password1!");
        //when
        boolean matches = passwordEncoder.matches(TEST_PASSWORD, ENCODED_PASSWORD);
        //then
        Assertions.assertThat(matches).isTrue();
    }
}