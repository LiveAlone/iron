package org.yqj.iron.framework.common;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.yqj.iron.framework.common.util.cache.CacheUtils;
import org.yqj.iron.framework.common.util.json.JsonUtils;
import org.yqj.iron.framework.common.util.spring.SpringExpressionUtils;

import java.time.Duration;
import java.util.Date;
import java.util.Map;

/**
 * @author 10126730
 * Date: 2025/3/31 19:44
 * Description:
 */
@Slf4j
@Disabled
public class UtilTest {

    @Test
    public void cacheTest() throws InterruptedException {
        log.info("cache test");
        LoadingCache<String, String> loadingCache = CacheUtils.buildAsyncReloadingCache(Duration.ofSeconds(1), new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                log.info("load key:{}", key);
                return String.format("result of key %s", key);
            }
        });
        for (int i = 0; i < 100; i++) {
            String result = loadingCache.getUnchecked("demoKeyTest");
            log.info("缓存中获取数据 :{}", result);
            Thread.sleep(500);
        }
    }

    @Test
    public void jsonTest() {
        Map<String, Object> map = Maps.newHashMap(Map.of("name", "yqj", "age", "18"));
        // 日期自动转换long 格式
        map.put("d1", new Date());
        log.info("json test : {}", JsonUtils.toJsonString(map));
    }

    @Test
    public void spExpressTest() {
        Map<String, Object> ctx = Maps.newHashMap();
        ctx.put("a", 1);
        ctx.put("b", 2);
        ctx.put("c", 3);
        ctx.put("d", 4);
        Object result = SpringExpressionUtils.parseExpression("a + b * c + d * 10", ctx);
        log.info("sp express result : {}", result);
    }

}
