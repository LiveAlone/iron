package org.yqj.iron.framework.test.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.yqj.iron.framework.mybatis.core.dataobject.BaseDO;

/**
 * @author 10126730
 * Date: 2025/4/1 16:30
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("tbl_user")
@ToString(callSuper = true)
public class User extends BaseDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private String email;
}
