package org.yqj.iron.framework.env.core.fegin;

import cn.hutool.core.util.StrUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.yqj.iron.framework.env.core.context.EnvContextHolder;
import org.yqj.iron.framework.env.core.util.EnvUtils;

/**
 * 多环境的 {@link RequestInterceptor} 实现类：Feign 请求时，将 tag 设置到 header 中，继续透传给被调用的服务
 *
 * @author 芋道源码
 */
public class EnvRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String tag = EnvContextHolder.getTag();
        if (StrUtil.isNotEmpty(tag)) {
            EnvUtils.setTag(requestTemplate, tag);
        }
    }

}
