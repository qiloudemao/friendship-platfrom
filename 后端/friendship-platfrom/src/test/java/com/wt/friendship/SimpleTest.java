package com.wt.friendship;

import com.wt.friendship.model.domain.User;
import com.wt.friendship.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class SimpleTest {
    @Autowired
    private UserMapper userMapper;
//    @Test
//    public void test(){
//        List<User> users = userMapper.selectList(null);
//        System.out.println(users);
//    }
}
