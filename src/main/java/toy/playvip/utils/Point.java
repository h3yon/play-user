package toy.playvip.utils;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;

@Getter
@RedisHash("point")
public class Point implements Serializable {

    @Id
    private String token;
    private Integer role;

    @Builder
    public Point(String token, Integer role) {
        this.token = token;
        this.role = role;
    }
}