package com.wt.friendship;

import com.wt.friendship.model.domain.User;
import com.wt.friendship.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
 class UserCenterMasterApplicationTests {

    @Resource
    private UserMapper userMapper;
//    @Test
//    public void test(){
//        List<User> users = userMapper.selectList(null);
//        System.out.println(users);
//    }

}
