package org.yqj.iron.framework.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.yqj.iron.framework.common.core.ArrayValuable;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({
        ElementType.METHOD,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.PARAMETER,
        ElementType.TYPE_USE
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {InEnumValidator.class, InEnumCollectionValidator.class}
)
public @interface InEnum {

    /**
     * @return 实现 ArrayValuable 接口的类
     */
    Class<? extends ArrayValuable<?>> value();

    String message() default "必须在指定范围 {value}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
