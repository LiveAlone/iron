package org.yqj.iron.framework.ratelimiter.config;

import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.yqj.iron.framework.ratelimiter.core.aop.RateLimiterAspect;
import org.yqj.iron.framework.ratelimiter.core.keyresolver.RateLimiterKeyResolver;
import org.yqj.iron.framework.ratelimiter.core.keyresolver.impl.ClientIpRateLimiterKeyResolver;
import org.yqj.iron.framework.ratelimiter.core.keyresolver.impl.DefaultRateLimiterKeyResolver;
import org.yqj.iron.framework.ratelimiter.core.keyresolver.impl.ExpressionRateLimiterKeyResolver;
import org.yqj.iron.framework.ratelimiter.core.keyresolver.impl.ServerNodeRateLimiterKeyResolver;
import org.yqj.iron.framework.ratelimiter.core.keyresolver.impl.UserRateLimiterKeyResolver;
import org.yqj.iron.framework.ratelimiter.core.redis.RateLimiterRedisDAO;
import org.yqj.iron.framework.redis.config.YudaoRedisAutoConfiguration;

import java.util.List;

@AutoConfiguration(after = YudaoRedisAutoConfiguration.class)
public class YudaoRateLimiterConfiguration {

    @Bean
    public RateLimiterAspect rateLimiterAspect(List<RateLimiterKeyResolver> keyResolvers, RateLimiterRedisDAO rateLimiterRedisDAO) {
        return new RateLimiterAspect(keyResolvers, rateLimiterRedisDAO);
    }

    @Bean
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public RateLimiterRedisDAO rateLimiterRedisDAO(RedissonClient redissonClient) {
        return new RateLimiterRedisDAO(redissonClient);
    }

    // ========== 各种 RateLimiterRedisDAO Bean ==========

    @Bean
    public DefaultRateLimiterKeyResolver defaultRateLimiterKeyResolver() {
        return new DefaultRateLimiterKeyResolver();
    }

    @Bean
    public UserRateLimiterKeyResolver userRateLimiterKeyResolver() {
        return new UserRateLimiterKeyResolver();
    }

    @Bean
    public ClientIpRateLimiterKeyResolver clientIpRateLimiterKeyResolver() {
        return new ClientIpRateLimiterKeyResolver();
    }

    @Bean
    public ServerNodeRateLimiterKeyResolver serverNodeRateLimiterKeyResolver() {
        return new ServerNodeRateLimiterKeyResolver();
    }

    @Bean
    public ExpressionRateLimiterKeyResolver expressionRateLimiterKeyResolver() {
        return new ExpressionRateLimiterKeyResolver();
    }

}
