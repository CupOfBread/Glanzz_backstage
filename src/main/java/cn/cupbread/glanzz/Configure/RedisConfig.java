package cn.cupbread.glanzz.Configure;

import cn.cupbread.glanzz.Entity.Article;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * @Author ：Cup_Of_Bread
 * @Date ：Created in 2020/5/13 11:04
 * @Description ： redis配置,改变默认序列化规则
 * @Version: :
 */

@Configuration
@EnableCaching
public class RedisConfig {

}
