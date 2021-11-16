package toy.playvip.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.playvip.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
