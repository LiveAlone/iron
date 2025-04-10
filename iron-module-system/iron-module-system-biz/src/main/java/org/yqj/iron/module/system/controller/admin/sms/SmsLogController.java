package org.yqj.iron.module.system.controller.admin.sms;

import org.yqj.iron.framework.apilog.core.annotation.ApiAccessLog;
import org.yqj.iron.framework.common.pojo.CommonResult;
import org.yqj.iron.framework.common.pojo.PageParam;
import org.yqj.iron.framework.common.pojo.PageResult;
import org.yqj.iron.framework.common.util.object.BeanUtils;
import org.yqj.iron.framework.excel.core.util.ExcelUtils;
import org.yqj.iron.module.system.controller.admin.sms.vo.log.SmsLogPageReqVO;
import org.yqj.iron.module.system.controller.admin.sms.vo.log.SmsLogRespVO;
import org.yqj.iron.module.system.dal.dataobject.sms.SmsLogDO;
import org.yqj.iron.module.system.service.sms.SmsLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static org.yqj.iron.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static org.yqj.iron.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 短信日志")
@RestController
@RequestMapping("/system/sms-log")
@Validated
public class SmsLogController {

    @Resource
    private SmsLogService smsLogService;

    @GetMapping("/page")
    @Operation(summary = "获得短信日志分页")
    @PreAuthorize("@ss.hasPermission('system:sms-log:query')")
    public CommonResult<PageResult<SmsLogRespVO>> getSmsLogPage(@Valid SmsLogPageReqVO pageReqVO) {
        PageResult<SmsLogDO> pageResult = smsLogService.getSmsLogPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, SmsLogRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出短信日志 Excel")
    @PreAuthorize("@ss.hasPermission('system:sms-log:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportSmsLogExcel(@Valid SmsLogPageReqVO exportReqVO,
                                  HttpServletResponse response) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<SmsLogDO> list = smsLogService.getSmsLogPage(exportReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "短信日志.xls", "数据", SmsLogRespVO.class,
                BeanUtils.toBean(list, SmsLogRespVO.class));
    }

}
