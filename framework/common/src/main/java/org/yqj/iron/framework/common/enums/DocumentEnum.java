package org.yqj.iron.framework.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文档地址
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum DocumentEnum {

    REDIS_INSTALL("https://gitee.com/Redis安装文档", "Redis 安装文档"),
    TENANT("https://SaaS多租户文档", "SaaS 多租户文档");
    
    private final String url;
    private final String memo;

}
