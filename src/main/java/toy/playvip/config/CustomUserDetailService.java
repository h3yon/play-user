package toy.playvip.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import toy.playvip.common.exception.BaseException;
import toy.playvip.common.exception.EmailSigninFailedException;
import toy.playvip.user.repository.UserRepository;

import static toy.playvip.common.response.Status.NO_EXISTS_INFO;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userPk) throws UsernameNotFoundException {
        return userRepository.findById(Long.valueOf(userPk)).orElseThrow(() -> {
            throw new EmailSigninFailedException(NO_EXISTS_INFO);
        });
    }
}
