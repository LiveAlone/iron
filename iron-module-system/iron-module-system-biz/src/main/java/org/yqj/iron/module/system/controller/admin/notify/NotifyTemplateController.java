package org.yqj.iron.module.system.controller.admin.notify;

import org.yqj.iron.framework.common.enums.UserTypeEnum;
import org.yqj.iron.framework.common.pojo.CommonResult;
import org.yqj.iron.framework.common.pojo.PageResult;
import org.yqj.iron.framework.common.util.object.BeanUtils;
import org.yqj.iron.module.system.controller.admin.notify.vo.template.*;
import org.yqj.iron.module.system.dal.dataobject.notify.NotifyTemplateDO;
import org.yqj.iron.module.system.service.notify.NotifySendService;
import org.yqj.iron.module.system.service.notify.NotifyTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.yqj.iron.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 站内信模版")
@RestController
@RequestMapping("/system/notify-template")
@Validated
public class NotifyTemplateController {

    @Resource
    private NotifyTemplateService notifyTemplateService;

    @Resource
    private NotifySendService notifySendService;

    @PostMapping("/create")
    @Operation(summary = "创建站内信模版")
    @PreAuthorize("@ss.hasPermission('system:notify-template:create')")
    public CommonResult<Long> createNotifyTemplate(@Valid @RequestBody NotifyTemplateSaveReqVO createReqVO) {
        return success(notifyTemplateService.createNotifyTemplate(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新站内信模版")
    @PreAuthorize("@ss.hasPermission('system:notify-template:update')")
    public CommonResult<Boolean> updateNotifyTemplate(@Valid @RequestBody NotifyTemplateSaveReqVO updateReqVO) {
        notifyTemplateService.updateNotifyTemplate(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除站内信模版")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:notify-template:delete')")
    public CommonResult<Boolean> deleteNotifyTemplate(@RequestParam("id") Long id) {
        notifyTemplateService.deleteNotifyTemplate(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得站内信模版")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:notify-template:query')")
    public CommonResult<NotifyTemplateRespVO> getNotifyTemplate(@RequestParam("id") Long id) {
        NotifyTemplateDO template = notifyTemplateService.getNotifyTemplate(id);
        return success(BeanUtils.toBean(template, NotifyTemplateRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得站内信模版分页")
    @PreAuthorize("@ss.hasPermission('system:notify-template:query')")
    public CommonResult<PageResult<NotifyTemplateRespVO>> getNotifyTemplatePage(@Valid NotifyTemplatePageReqVO pageVO) {
        PageResult<NotifyTemplateDO> pageResult = notifyTemplateService.getNotifyTemplatePage(pageVO);
        return success(BeanUtils.toBean(pageResult, NotifyTemplateRespVO.class));
    }

    @PostMapping("/send-notify")
    @Operation(summary = "发送站内信")
    @PreAuthorize("@ss.hasPermission('system:notify-template:send-notify')")
    public CommonResult<Long> sendNotify(@Valid @RequestBody NotifyTemplateSendReqVO sendReqVO) {
        if (UserTypeEnum.MEMBER.getValue().equals(sendReqVO.getUserType())) {
            return success(notifySendService.sendSingleNotifyToMember(sendReqVO.getUserId(),
                    sendReqVO.getTemplateCode(), sendReqVO.getTemplateParams()));
        } else {
            return success(notifySendService.sendSingleNotifyToAdmin(sendReqVO.getUserId(),
                    sendReqVO.getTemplateCode(), sendReqVO.getTemplateParams()));
        }
    }
}
