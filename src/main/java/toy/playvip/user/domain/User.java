package toy.playvip.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import toy.playvip.common.Timestamped;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@ToString
@Entity
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String username;
    private Integer role;

    @Builder
    public User(Long id, String email, String password, String username, Integer role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
    }
}
