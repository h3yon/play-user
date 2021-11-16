package toy.playvip.user.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toy.playvip.user.domain.User;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @Mock
    private toy.playvip.user.repository.UserRepository userRepository;

    final String EMAIL = "test@email.com";
    final String USERNAME = "testUser";
    final String PASSWORD = "testPassword";

//    @Test
//    void 이름으로_찾기(){
//        // given
//
//        // when
//
//        // then
//
//
//        User testUser = new User(null, EMAIL, PASSWORD, USERNAME, 1);
//        given(userRepository.save(any(User.class))).willReturn(testUser);
//
//        User savedUser = userRepository.save(testUser);
//
//        Optional<User> userFindByEmail = userRepository.findByEmail(testUser.getEmail());
//        userFindByEmail.ifPresent(value -> Assertions.assertEquals(testUser.getEmail(), value.getEmail()));
//    }


}

