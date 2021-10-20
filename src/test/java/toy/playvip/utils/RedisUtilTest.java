package toy.playvip.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import toy.playvip.PlayVipApplication;
import toy.playvip.config.SwaggerConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {SwaggerConfig.class, PlayVipApplication.class})
class RedisUtilTest {

    @Autowired
    private PointRedisRepository pointRedisRepository;

    @AfterEach
    public void tearDown() throws Exception{
        pointRedisRepository.deleteAll();
    }

    @Test
    public void 기본_등록_조회기능() {
        // given
        String token = "h3yon_token";
        Point point = Point.builder()
                .token(token)
                .role(1)
                .build();
        // when
        pointRedisRepository.save(point);

        // then
        Point savedPoint = pointRedisRepository.findById(token).get();
        assertThat(savedPoint.getRole()).isEqualTo(1);
    }

}