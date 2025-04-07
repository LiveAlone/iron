package org.yqj.iron.framework.datapermission.core.util;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.yqj.iron.framework.datapermission.core.aop.DataPermissionContextHolder;
import org.yqj.iron.framework.datapermission.core.util.DataPermissionUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;

@Disabled
public class DataPermissionUtilsTest {

    @Test
    public void testExecuteIgnore() {
        DataPermissionUtils.executeIgnore(() -> assertFalse(DataPermissionContextHolder.get().enable()));
    }

}
