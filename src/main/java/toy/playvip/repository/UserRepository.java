package toy.playvip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.playvip.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
