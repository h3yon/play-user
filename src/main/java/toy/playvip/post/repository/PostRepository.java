package toy.playvip.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.playvip.board.domain.Board;
import toy.playvip.post.domain.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByBoard(Board board);
}
