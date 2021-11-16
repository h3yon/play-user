package toy.playvip.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.RedisTemplate;
import toy.playvip.config.RedisConfig;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class RedisUtilTest {

//    @Mock
//    RedisUtil redisUtil;
//    @Mock
//    RedisConfig redisConfig;
//    @MockBean
//    RedisTemplate<String, Object> redisTemplate;
//
//    @Test
//    public void 저장(){
//        //given
//        //when
//        redisUtil.set("myKey", "myVal", 10);
//        //then
//        assertTrue(redisUtil.hasKey("myKey"));
//    }
}