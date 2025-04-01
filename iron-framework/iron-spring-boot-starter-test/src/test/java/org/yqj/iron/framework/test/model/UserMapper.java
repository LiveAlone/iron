package org.yqj.iron.framework.test.model;

import org.apache.ibatis.annotations.Mapper;
import org.yqj.iron.framework.mybatis.core.mapper.BaseMapperX;

/**
 * @author 10126730
 * Date: 2025/4/1 16:31
 * Description:
 */
@Mapper
public interface UserMapper extends BaseMapperX<User> {
}
