package org.yqj.iron.module.system.dal.mysql.social;

import org.yqj.iron.framework.common.pojo.PageResult;
import org.yqj.iron.framework.mybatis.core.mapper.BaseMapperX;
import org.yqj.iron.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.yqj.iron.module.system.controller.admin.socail.vo.user.SocialUserPageReqVO;
import org.yqj.iron.module.system.dal.dataobject.social.SocialUserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SocialUserMapper extends BaseMapperX<SocialUserDO> {

    default SocialUserDO selectByTypeAndCodeAnState(Integer type, String code, String state) {
        return selectOne(SocialUserDO::getType, type,
                SocialUserDO::getCode, code,
                SocialUserDO::getState, state);
    }

    default SocialUserDO selectByTypeAndOpenid(Integer type, String openid) {
        return selectFirstOne(SocialUserDO::getType, type,
                SocialUserDO::getOpenid, openid);
    }

    default PageResult<SocialUserDO> selectPage(SocialUserPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SocialUserDO>()
                .eqIfPresent(SocialUserDO::getType, reqVO.getType())
                .likeIfPresent(SocialUserDO::getNickname, reqVO.getNickname())
                .likeIfPresent(SocialUserDO::getOpenid, reqVO.getOpenid())
                .betweenIfPresent(SocialUserDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SocialUserDO::getId));
    }

}
