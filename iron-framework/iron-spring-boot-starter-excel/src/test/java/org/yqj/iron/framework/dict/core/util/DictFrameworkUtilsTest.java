package org.yqj.iron.framework.dict.core.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.yqj.iron.framework.common.enums.CommonStatusEnum;
import org.yqj.iron.framework.dict.core.DictFrameworkUtils;
import org.yqj.iron.framework.test.core.ut.BaseMockitoUnitTest;
import org.yqj.iron.module.system.api.dict.DictDataApi;
import org.yqj.iron.module.system.api.dict.dto.DictDataRespDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.yqj.iron.framework.test.core.util.RandomUtils.randomPojo;

/**
 * {@link DictFrameworkUtils} 的单元测试
 */
@Disabled
public class DictFrameworkUtilsTest extends BaseMockitoUnitTest {

    @Mock
    private DictDataApi dictDataApi;

    @BeforeEach
    public void setUp() {
        DictFrameworkUtils.init(dictDataApi);
    }

    @Test
    public void testGetDictDataLabel() {
        // mock 数据
        DictDataRespDTO dataRespDTO = randomPojo(DictDataRespDTO.class, o -> o.setStatus(CommonStatusEnum.ENABLE.getStatus()));
        // mock 方法
        when(dictDataApi.getDictData(dataRespDTO.getDictType(), dataRespDTO.getValue())).thenReturn(dataRespDTO);

        // 断言返回值
        assertEquals(dataRespDTO.getLabel(), DictFrameworkUtils.getDictDataLabel(dataRespDTO.getDictType(), dataRespDTO.getValue()));
    }

    @Test
    public void testParseDictDataValue() {
        // mock 数据
        DictDataRespDTO resp = randomPojo(DictDataRespDTO.class, o -> o.setStatus(CommonStatusEnum.ENABLE.getStatus()));
        // mock 方法
        when(dictDataApi.parseDictData(resp.getDictType(), resp.getLabel())).thenReturn(resp);

        // 断言返回值
        assertEquals(resp.getValue(), DictFrameworkUtils.parseDictDataValue(resp.getDictType(), resp.getLabel()));
    }

}
