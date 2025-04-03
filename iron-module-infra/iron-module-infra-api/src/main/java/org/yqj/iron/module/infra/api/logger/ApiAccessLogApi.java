package org.yqj.iron.module.infra.api.logger;

import jakarta.validation.Valid;
import org.springframework.scheduling.annotation.Async;
import org.yqj.iron.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;

/**
 * API 访问日志的 API 接口
 *
 * @author 芋道源码
 */
public interface ApiAccessLogApi {

    /**
     * 创建 API 访问日志
     *
     * @param createDTO 创建信息
     */
    void createApiAccessLog(@Valid ApiAccessLogCreateReqDTO createDTO);

    /**
     * 【异步】创建 API 访问日志
     *
     * @param createDTO 访问日志 DTO
     */
    @Async
    default void createApiAccessLogAsync(ApiAccessLogCreateReqDTO createDTO) {
        createApiAccessLog(createDTO);
    }

}
