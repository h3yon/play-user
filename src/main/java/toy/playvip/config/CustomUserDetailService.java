package toy.playvip.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import toy.playvip.common.exception.SignException;
import toy.playvip.common.exception.SignExceptionCode;
import toy.playvip.user.repository.UserRepository;

import static toy.playvip.common.response.Status.NO_EXISTS_INFO;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userPk) {
        return userRepository.findByEmail(userPk).orElseThrow(() -> {
            throw new SignException(SignExceptionCode.NO_EXISTS_EMAIL);
        });
    }
}
