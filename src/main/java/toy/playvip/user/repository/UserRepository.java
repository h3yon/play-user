package toy.playvip.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.playvip.user.domain.User;
import toy.playvip.user.dto.response.UserInfoResponseDto;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    boolean existsByEmail(String email);
}
