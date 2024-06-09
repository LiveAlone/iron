package org.yqj.iron.framework.ip;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2023/6/6
 * Email: yaoqijunmail@foxmail.com
 */
@Slf4j
public class NoneTest {
    public void testNone(){
        log.trace("trace log");
        log.debug("debug log");
        log.info("info log");
        log.warn("warn log");
        log.error("error log");
    }
}
