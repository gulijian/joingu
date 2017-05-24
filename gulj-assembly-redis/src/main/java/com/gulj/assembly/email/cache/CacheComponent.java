package com.gulj.assembly.email.cache;

import com.gulj.entity.common.bo.RedisKeyBo;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author gulj
 * @create 2017-05-24 下午2:48
 **/
public interface CacheComponent {

    <T> void vset(RedisKeyBo.CacheModule module, String subKey, T t, long timeout);

    <T> void vset(RedisKeyBo.CacheModule module, String subKey, T t);

    <T> void hset(RedisKeyBo.CacheModule module, String subKey, String hashKey, T t, long timeout);

    <T> void hset(RedisKeyBo.CacheModule module, String subKey, String hashKey, T t);

    <T> void hsetIfAbsent(RedisKeyBo.CacheModule module, String subKey, String hashKey, T t, long timeout);

    <T> void hsetIfAbsent(RedisKeyBo.CacheModule module, String subKey, String hashKey, T t);

    <T> T vget(RedisKeyBo.CacheModule module, String subKey);

    <T> T vget(String key);

    <T> T hget(RedisKeyBo.CacheModule module, String subKey, String hashKey);

    <T> Map<String, T> entries(String key);

    <T> Long pushHead(RedisKeyBo.CacheModule module, String subKey, T t);

    <T> Long pushHead(RedisKeyBo.CacheModule module, String subKey, List<T> list);

    <T> Long pushTail(RedisKeyBo.CacheModule module, String subKey, T t);

    <T> Long pushTail(RedisKeyBo.CacheModule module, String subKey, List<T> list);

    <T> T popHead(RedisKeyBo.CacheModule module, String subKey);

    <T> T popTail(RedisKeyBo.CacheModule module, String subKey);

    <T> List<T> range(RedisKeyBo.CacheModule module, String subKey);

    <T> List<T> range(RedisKeyBo.CacheModule module, String subKey, long start, long end);

    <T> long size(RedisKeyBo.CacheModule module, String subKey);

    void del(RedisKeyBo.CacheModule module, String subKey);

    <T> void del(Collection<T> keys);

    <T, K> Set<T> hkeys(String key);

    <T, K> List<K> hvalues(String key);

    boolean hasKey(RedisKeyBo.CacheModule module, String subKey);

    void expire(RedisKeyBo.CacheModule module, String subKey, long timeout, TimeUnit unit);

    Set<String> like(RedisKeyBo.CacheModule module, String pattern);

    void clear(RedisKeyBo.CacheModule module, int userId);

    void clear(RedisKeyBo.CacheModule module, String pattern);

    void countSet(RedisKeyBo.CacheModule module, String subKey, Long count);

    long countDecr(RedisKeyBo.CacheModule module, String subKey, int i);


}
