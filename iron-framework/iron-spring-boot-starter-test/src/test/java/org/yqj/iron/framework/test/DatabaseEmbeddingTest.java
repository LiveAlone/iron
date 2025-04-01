package org.yqj.iron.framework.test;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.yqj.iron.framework.test.core.ut.BaseDbUnitTest;
import org.yqj.iron.framework.test.model.User;
import org.yqj.iron.framework.test.model.UserMapper;

/**
 * @author 10126730
 * Date: 2025/4/1 16:29
 * Description:
 */
@Slf4j
@Disabled
public class DatabaseEmbeddingTest extends BaseDbUnitTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsertRead() {
        User user = new User();
        user.setName("yqj");
        user.setAge(18);
        user.setEmail("yqj@qq.com");
        user.setCreator("yqj");
        user.setUpdater("yqj");
        userMapper.insert(user);
        log.info("insert user id : {}", user.getId());

        User user1 = userMapper.selectById(user.getId());
        log.info("find user: {}", user1);
    }

}
