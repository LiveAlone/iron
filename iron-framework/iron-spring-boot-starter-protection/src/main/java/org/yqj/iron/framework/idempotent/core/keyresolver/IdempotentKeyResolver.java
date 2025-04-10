package org.yqj.iron.framework.idempotent.core.keyresolver;

import org.aspectj.lang.JoinPoint;
import org.yqj.iron.framework.idempotent.core.annotation.Idempotent;

/**
 * 幂等 Key 解析器接口
 *
 * @author 芋道源码
 */
public interface IdempotentKeyResolver {

    /**
     * 解析一个 Key
     *
     * @param idempotent 幂等注解
     * @param joinPoint  AOP 切面
     * @return Key
     */
    String resolver(JoinPoint joinPoint, Idempotent idempotent);

}
