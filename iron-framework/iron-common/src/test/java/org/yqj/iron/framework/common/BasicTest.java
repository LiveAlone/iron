package org.yqj.iron.framework.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.yqj.iron.framework.common.enums.DateIntervalEnum;
import org.yqj.iron.framework.common.exception.enums.GlobalErrorCodeConstants;
import org.yqj.iron.framework.common.exception.util.ServiceExceptionUtil;

/**
 * @author 10126730
 * Date: 2025/3/31 19:45
 * Description:
 */
@Slf4j
@Disabled
public class BasicTest {

    @Test
    public void enumDemo() {
        Integer[] arr = DateIntervalEnum.DAY.array();
        for (Integer integer : arr) {
            log.info("date interval {}", integer);
        }
    }

    @Test
    public void exceptionTest() {
        log.info("success :{}", GlobalErrorCodeConstants.SUCCESS);
        log.info("error :{} ", ServiceExceptionUtil.exception0(111, "异常项目 {} {}", "projectE", "common"));
    }
}
