package toy.playvip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.playvip.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);
}
