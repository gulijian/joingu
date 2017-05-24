package com.gulj.assembly.email.cache;

import com.gulj.entity.common.bo.RedisKeyBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.util.StringUtils;

/**
 * @author gulj
 * @create 2017-05-24 下午2:46
 **/
public abstract  class Cache {

    private final static Logger logger = LoggerFactory.getLogger(Cache.class);
    /**
     * 默认过期时间 2小时
     */
    public long defaultTimeout = 60 * 60 * 2;

    /**
     * 缓存键分隔符
     */
    public String KEY_SEPARATOR = "/";

    public static final GenericToStringSerializer STRING_SERIALIZER = new GenericToStringSerializer<>(Long.class);

    public static final JdkSerializationRedisSerializer JDK_SERIALIZATION_REDIS_SERIALIZER = new JdkSerializationRedisSerializer();

    public static final GenericJackson2JsonRedisSerializer GENERIC_JACKSON_2_JSON_REDIS_SERIALIZER = new GenericJackson2JsonRedisSerializer();

    /**
     * @param module
     * @param key
     * @return
     * @Title 生成redis的key
     * @author jiuzhou.hu
     * @date 2016年9月13日 上午9:48:27
     */
    protected String processKey(RedisKeyBo.CacheModule module, String key) {

        if (StringUtils.isEmpty(key)) {
            logger.error("@@@@缓存的子键不合法；subkey={}", key);
//            throw new BusinessException(EXP_CODE_PREFIX + "cache-processK", "处理redis-key出现异常");
        }
        String raw = module.getName() + key;
//		logger.debug("redis查询key为{}",raw);
        return raw;

    }
}
