package org.yqj.iron.framework.test.core.ut;

import cn.hutool.extra.spring.SpringUtil;
import org.redisson.spring.starter.RedissonAutoConfigurationV2;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.yqj.iron.framework.redis.config.YudaoRedisAutoConfiguration;
import org.yqj.iron.framework.test.config.RedisTestConfiguration;

/**
 * 依赖内存 Redis 的单元测试
 *
 * 相比 {@link BaseDbUnitTest} 来说，从内存 DB 改成了内存 Redis
 *
 * @author 芋道源码
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = BaseRedisUnitTest.Application.class)
@ActiveProfiles("unit-test") // 设置使用 application-unit-test 配置文件
public class BaseRedisUnitTest {

    @Import({
            // Redis 配置类
            RedisTestConfiguration.class, // Redis 测试配置类，用于启动 RedisServer
            YudaoRedisAutoConfiguration.class, // 自己的 Redis 配置类
            RedisAutoConfiguration.class, // Spring Redis 自动配置类，注意顺序
            RedissonAutoConfigurationV2.class, // Redisson 自动配置类

            // 其它配置类
            SpringUtil.class
    })
    public static class Application {
    }

}
