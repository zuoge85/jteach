package org.forkjoin.jteach.open;

import org.forkjoin.jteach.core.cache.KeyUtils;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public KeyGenerator keyGenerator() {
        return KeyUtils::getSpringCacheKey;
    }
//
//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
//        //设置缓存过期时间
//        //rcm.setDefaultExpiration(60);//秒
//        return rcm;
//    }

//    @Bean(name ="redisTemplate")
//    public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate<String, String> template = new RedisTemplate<String, Object>();
//        template.setConnectionFactory(connectionFactory);
//        setMySerializer(template);
//        template.afterPropertiesSet();
//        return template;
//    }

//    /**
//     * 设置序列化方法
//     */
//    private void setMySerializer(RedisTemplate template) {
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
//                Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setKeySerializer(template.getStringSerializer());
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//    }
}
