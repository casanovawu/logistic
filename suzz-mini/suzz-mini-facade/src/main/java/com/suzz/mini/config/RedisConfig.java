package com.suzz.mini.config;

import com.suzz.platform.config.RedissonClientDecorator;
import com.suzz.platform.config.RedissonClientFactory;
import lombok.Getter;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;


@Configuration
public class RedisConfig {

    public final static String MINI_REDIS = "mini_redis";

    @Getter
    @Value("${spring.redis.host}")
    private String redisHost;

    @Getter
    @Value("${spring.redis.port}")
    private String redisPort;

    @Getter
    @Value("${spring.redis.password:}")
    private String redisPassword;

    @Getter
    @Value("${spring.redis.database:}")
    private Integer redisDataBase;


    @Bean(name = MINI_REDIS)
    public RedissonClientDecorator miniRedissonClientDecorator(RedisConfig redisConfig) throws Exception {
        return new RedissonClientDecorator(getRedissonClient(redisConfig));
    }

    @Bean
    public RedissonClient getRedissonClient(RedisConfig redisConfig) throws Exception {
        RedissonClientFactory redissonClientFactory = new RedissonClientFactory(redisConfig.getRedisHost() + ":" + redisConfig.getRedisPort(), RedissonClientFactory.SINGLE, redisConfig.getRedisDataBase());
        redissonClientFactory.setPassword(redisConfig.getRedisPassword());
        redissonClientFactory.initClientConfig(new JsonJacksonCodec());
        return redissonClientFactory.getObject();
    }

    @Bean
    public CacheManager redisCacheManager(RedisTemplate redisTemplate) {
        return new RedisCacheManager(RedisCacheWriter
                .nonLockingRedisCacheWriter(Objects.requireNonNull(redisTemplate.getConnectionFactory())),
                RedisCacheConfiguration.defaultCacheConfig()
                        .serializeValuesWith(RedisSerializationContext.fromSerializer(new Jackson2JsonRedisSerializer<>(Object.class))
                                .getValueSerializationPair()));
    }
}
