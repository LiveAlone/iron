package org.yqj.iron.module.system.api.logger.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.yqj.iron.framework.common.pojo.PageParam;

/**
 * 操作日志分页 Request DTO
 *
 * @author HUIHUI
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OperateLogPageReqDTO extends PageParam {

    /**
     * 模块类型
     */
    private String type;
    /**
     * 模块数据编号
     */
    private Long bizId;

    /**
     * 用户编号
     */
    private Long userId;

}
