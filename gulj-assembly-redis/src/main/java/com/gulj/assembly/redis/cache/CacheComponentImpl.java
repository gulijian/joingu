package com.gulj.assembly.redis.cache;

import com.gulj.entity.common.bo.RedisKeyBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 缓存基础服务redis实现
 *
 * @author gulj
 * @create 2017-05-24 下午2:48
 **/
@Service
public class CacheComponentImpl extends Cache implements CacheComponent {
    private final static Logger logger = LoggerFactory.getLogger(CacheComponentImpl.class);

    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Override
    public <T> void vset(RedisKeyBo.CacheModule module, String subKey, T t, long timeout) {
        try {
            vset(module, subKey, t);
            String raw = module.getName() + subKey;
            redisTemplate.expire(raw, timeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate vset 操作异常1", e);
        }
    }

    @Override
    public <T> void vset(RedisKeyBo.CacheModule module, String subKey, T t) {
        try {
            String raw = processKey(module, subKey);
            ValueOperations<String, T> vOps = redisTemplate.opsForValue();
            vOps.set(raw, t);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate vset 操作异常2", e);
        }
    }

    @Override
    public <T> void hset(RedisKeyBo.CacheModule module, String subKey, String hashKey, T t, long timeout) {
        try {
            hset(module, subKey, hashKey, t);
            String raw = module.getName() + subKey;
            redisTemplate.expire(raw, timeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate hset 操作异常1", e);
        }
    }

    @Override
    public <T> void hset(RedisKeyBo.CacheModule module, String subKey, String hashKey, T t) {
        try {
            String raw = processKey(module, subKey);
            HashOperations<String, String, T> hOps = redisTemplate.opsForHash();
            hOps.put(raw, hashKey, t);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate hset 操作异常2", e);
        }
    }

    @Override
    public <T> void hsetIfAbsent(RedisKeyBo.CacheModule module, String subKey, String hashKey, T t, long timeout) {
        try {
            hsetIfAbsent(module, subKey, hashKey, t);
            String raw = module.getName() + subKey;
            redisTemplate.expire(raw, timeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate hsetIfAbsent 操作异常1", e);
        }
    }

    @Override
    public <T> void hsetIfAbsent(RedisKeyBo.CacheModule module, String subKey, String hashKey, T t) {
        try {
            String raw = processKey(module, subKey);
            HashOperations<String, String, T> hOps = redisTemplate.opsForHash();
            hOps.putIfAbsent(raw, hashKey, t);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate hsetIfAbsent 操作异常2", e);
        }
    }

    @Override
    public <T> T vget(RedisKeyBo.CacheModule module, String subKey) {
        try {
            String raw = processKey(module, subKey);
            ValueOperations<String, T> vOps = redisTemplate.opsForValue();
            return vOps.get(raw);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate vget 操作异常", e);
            return null;
        }
    }

    @Override
    public <T> T vget(String key) {
        try {
            ValueOperations<String, T> vOps = redisTemplate.opsForValue();
            return vOps.get(key);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate vget 操作异常", e);
            return null;
        }
    }

    @Override
    public <T> T hget(RedisKeyBo.CacheModule module, String subKey, String hashKey) {
        try {
            String raw = processKey(module, subKey);
            HashOperations<String, String, T> hOps = redisTemplate.opsForHash();
            logger.info("++++module={}, subkey={}, hashkey={}", module.getName(), subKey, hashKey);
            return hOps.get(raw, hashKey);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate hget 操作异常", e);
            return null;
        }
    }

    @Override
    public <T> Map<String, T> entries(String key) {
        try {
            if (StringUtils.isEmpty(key)) {
                logger.error("@@@@传入的key不合法；key={}", key);
//                throw new BusinessException(ComponentConstants.EXP_CODE_PREFIX + "cache-entries", "entries方法异常");
            }
            HashOperations<String, String, T> hOps = redisTemplate.opsForHash();
            return hOps.entries(key);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate entries 操作异常", e);
            return null;
        }
    }

    @Override
    public <T> Long pushHead(RedisKeyBo.CacheModule module, String subKey, T t) {
        try {
            String raw = processKey(module, subKey);
            ListOperations<String, T> lOps = redisTemplate.opsForList();
            return lOps.leftPush(raw, t);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate pushHead 操作异常1", e);
            return 0l;
        }
    }

    @Override
    public <T> Long pushHead(RedisKeyBo.CacheModule module, String subKey, List<T> list) {
        try {
            String raw = processKey(module, subKey);
            ListOperations<String, T> lOps = redisTemplate.opsForList();
            return lOps.leftPushAll(raw, list);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate pushHead 操作异常2", e);
            return 0l;
        }
    }

    @Override
    public <T> Long pushTail(RedisKeyBo.CacheModule module, String subKey, T t) {
        try {
            String raw = processKey(module, subKey);
            ListOperations<String, T> lOps = redisTemplate.opsForList();
            return lOps.rightPush(raw, t);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate pushTail 操作异常1", e);
            return 0l;
        }
    }

    @Override
    public <T> Long pushTail(RedisKeyBo.CacheModule module, String subKey, List<T> list) {
        try {
            String raw = processKey(module, subKey);
            ListOperations<String, T> lOps = redisTemplate.opsForList();
            return lOps.rightPushAll(raw, list);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate pushTail 操作异常2", e);
            return 0l;
        }
    }

    public <T> T popHead(RedisKeyBo.CacheModule module, String subKey) {
        try {
            String raw = processKey(module, subKey);
            ListOperations<String, T> lOps = redisTemplate.opsForList();
            return lOps.leftPop(raw);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate popHead 操作异常", e);
            return null;
        }
    }

    public <T> T popTail(RedisKeyBo.CacheModule module, String subKey) {
        try {
            String raw = processKey(module, subKey);
            ListOperations<String, T> lOps = redisTemplate.opsForList();
            return lOps.rightPop(raw);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate popTail 操作异常", e);
            return null;
        }
    }

    @Override
    public <T> List<T> range(RedisKeyBo.CacheModule module, String subKey) {
        try {
            String raw = processKey(module, subKey);
            ListOperations<String, T> lOps = redisTemplate.opsForList();
            return lOps.range(raw, 0, Integer.MAX_VALUE);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate range 操作异常", e);
            return null;
        }
    }

    @Override
    public <T> List<T> range(RedisKeyBo.CacheModule module, String subKey, long start, long end) {
        try {
            String raw = processKey(module, subKey);
            ListOperations<String, T> lOps = redisTemplate.opsForList();
            return lOps.range(raw, start, end);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate range 操作异常2", e);
            return null;
        }
    }

    @Override
    public <T> long size(RedisKeyBo.CacheModule module, String subKey) {
        try {
            String raw = processKey(module, subKey);
            ListOperations<String, T> lOps = redisTemplate.opsForList();
            return lOps.size(raw);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate size 操作异常", e);
            return 0;
        }
    }

    @Override
    public void del(RedisKeyBo.CacheModule module, String subKey) {
        try {
            redisTemplate.delete(processKey(module, subKey));
        } catch (Exception e) {
            logger.error("@@@@redisTemplate del 操作异常", e);
        }
    }

    @Override
    public <T> void del(Collection<T> keys) {
        try {
            if (keys == null || keys.isEmpty()) {
                logger.error("@@@@缓存的子键不合法；keys={}", keys);
//                throw new BusinessException(ComponentConstants.EXP_CODE_PREFIX + "cache-del", "del方法异常");
            }
            redisTemplate.delete(keys);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate del 操作异常2", e);
        }
    }

    @Override
    public <T, K> Set<T> hkeys(String key) {
        try {
            HashOperations<String, T, K> hOps = redisTemplate.opsForHash();
            return hOps.keys(RedisKeyBo.MODULE_MARKET_EVENT_KEY);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate hkeys 操作异常2", e);
            return null;
        }
    }

    @Override
    public <T, K> List<K> hvalues(String key) {
        try {
            HashOperations<String, T, K> hOps = redisTemplate.opsForHash();
            return hOps.values(key);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate hvalues 操作异常2", e);
            return null;
        }
    }

    @Override
    public boolean hasKey(RedisKeyBo.CacheModule module, String subKey) {
        return redisTemplate.hasKey(processKey(module, subKey));
    }

    @Override
    public void expire(RedisKeyBo.CacheModule module, String subKey, long timeout, TimeUnit unit) {
        try {
            redisTemplate.expire(processKey(module, subKey), timeout, unit);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate expire 操作异常", e);
        }
    }

    @Override
    public void clear(RedisKeyBo.CacheModule module, int userId) {
        try {
            String pattern = module.getName() + "**" + userId;
            Set<String> ks = redisTemplate.keys(pattern);
            logger.info("++++redis keys pattern={}， 匹配的key set={}", pattern, ks);
            redisTemplate.delete(ks);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate clear 操作异常", e);
        }
    }

    @Override
    public void clear(RedisKeyBo.CacheModule module, String pattern) {
        try {
            String p = module.getName() + "**" + pattern;
            Set<String> ks = redisTemplate.keys(p);
            logger.info("++++redis keys pattern={}， 匹配的key set={}", p, ks);
            redisTemplate.delete(ks);
        } catch (Exception e) {
            logger.error("@@@@redisTemplate clear 操作异常2", e);
        }
    }

    @Override
    public void countSet(RedisKeyBo.CacheModule module, String subKey, Long count) {
        redisTemplate.setValueSerializer(STRING_SERIALIZER);
        redisTemplate.boundValueOps(processKey(module, subKey)).set(count);
    }

    @Override
    public long countDecr(RedisKeyBo.CacheModule module, String subKey, int i) {
        redisTemplate.setValueSerializer(STRING_SERIALIZER);
        return redisTemplate.boundValueOps(processKey(module, subKey)).increment(-i);
    }

    @Override
    public Set<String> like(RedisKeyBo.CacheModule module, String pattern) {
        try {
            return redisTemplate.keys(processKey(module, pattern));
        } catch (Exception e) {
            logger.error("@@@@redisTemplate like 操作异常", e);
            return null;
        }
    }
}
