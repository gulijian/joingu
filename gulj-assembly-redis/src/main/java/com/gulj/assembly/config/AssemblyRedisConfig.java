package com.gulj.assembly.config;

import com.gulj.assembly.email.prop.RedisProp;
import com.gulj.entity.common.bo.JoinAnnotationBeanNameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author gulj
 * @create 2017-05-24 下午2:42
 **/
@Configuration
@PropertySources({@PropertySource("classpath:config/gulj-assembly-redis.properties")})
@EnableConfigurationProperties({RedisProp.class})
@ComponentScan(basePackages = {"com.gulj.assembly.email"}, nameGenerator = JoinAnnotationBeanNameGenerator.class)
public class AssemblyRedisConfig {


    private final static Logger logger = LoggerFactory.getLogger(AssemblyRedisConfig.class);

    @Autowired
    private RedisProp redisProp;

    @Bean
    public RedisConnectionFactory jedisConnectionFactory() {
        logger.info("++++加载的redis信息 {}", redisProp.getHost());
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(redisProp.getMaxTotal());
        poolConfig.setMaxIdle(redisProp.getMaxIdle());
        poolConfig.setMinIdle(redisProp.getMinIdle());
        poolConfig.setMaxWaitMillis(redisProp.getMaxWaitMills());
        poolConfig.setTestOnBorrow(redisProp.isTestOnBorrow());
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(poolConfig);
        jedisConnectionFactory.setHostName(redisProp.getHost());
        jedisConnectionFactory.setPassword(redisProp.getPasswd());
        jedisConnectionFactory.setPort(redisProp.getPort());
        jedisConnectionFactory.setDatabase(redisProp.getDatabase());
        jedisConnectionFactory.setUsePool(true);
        return jedisConnectionFactory;
    }

    @SuppressWarnings("unchecked")
    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        redisTemplate.setEnableTransactionSupport(false);
        return redisTemplate;
    }


}
