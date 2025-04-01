package org.yqj.iron.framework.test;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.yqj.iron.framework.test.core.ut.BaseRedisUnitTest;

import java.util.List;
import java.util.Map;

/**
 * @author 10126730
 * Date: 2025/4/1 15:19
 * Description:
 */
@Slf4j
@Disabled
public class RedisEmbeddingTest extends BaseRedisUnitTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RedissonClient redissonClient;

    @Test
    public void springRedisTemplateTest(){
        stringRedisTemplate.opsForValue().set("hello", "world");
        log.info("find key hello: {}", stringRedisTemplate.opsForValue().get("hello"));

        redisTemplate.opsForHash().putAll("hash", Map.of("key1", "value1", "key2", "value2"));
        List<Object> los = redisTemplate.opsForHash().multiGet("hash", List.of("key1", "key2"));
        log.info("find key1: {}, key2: {}", los.get(0), los.get(1));
    }

    @Test
    public void redissonTest(){
        RList<Object> rList = redissonClient.getList("demoList");
        rList.add("hello");
        rList.add("world");
        log.info("find list: {}", rList.readAll());
    }
}
