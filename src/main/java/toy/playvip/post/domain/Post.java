package toy.playvip.post.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import toy.playvip.common.Timestamped;
import toy.playvip.user.domain.User;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="userId")
    private User user;

    @Builder
    public Post(String name, String content, User user) {
        this.name = name;
        this.content = content;
        this.user = user;
    }
}
