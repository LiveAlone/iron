package org.yqj.iron.framework.desensitize.core.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.yqj.iron.framework.desensitize.core.DesensitizeTest;
import org.yqj.iron.framework.desensitize.core.base.annotation.DesensitizeBy;
import org.yqj.iron.framework.desensitize.core.handler.AddressHandler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 地址
 *
 * 用于 {@link DesensitizeTest} 测试使用
 *
 * @author gaibu
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = AddressHandler.class)
public @interface Address {

    String replacer() default "*";

}
