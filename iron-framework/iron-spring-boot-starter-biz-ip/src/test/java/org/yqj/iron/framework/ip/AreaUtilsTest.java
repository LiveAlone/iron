package org.yqj.iron.framework.ip;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.yqj.iron.framework.ip.core.Area;
import org.yqj.iron.framework.ip.core.enums.AreaTypeEnum;
import org.yqj.iron.framework.ip.core.utils.AreaUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * {@link AreaUtils} 的单元测试
 *
 * @author 芋道源码
 */
@Disabled
@Slf4j
public class AreaUtilsTest {

    @Test
    public void testGetArea() {
        // 调用：北京
        Area area = AreaUtils.getArea(110100);
        // 断言
        assertEquals(area.getId(), 110100);
        assertEquals(area.getName(), "北京市");
        assertEquals(area.getType(), AreaTypeEnum.CITY.getType());
        assertEquals(area.getParent().getId(), 110000);
        assertEquals(area.getChildren().size(), 16);
        log.info("gain area {}", area);
    }

    @Test
    public void testFormat() {
        assertEquals(AreaUtils.format(110105), "北京市 北京市 朝阳区");
        assertEquals(AreaUtils.format(1), "中国");
        assertEquals(AreaUtils.format(2), "蒙古");
    }

}
