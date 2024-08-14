package com.wt.friendship.service;

import com.wt.friendship.model.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Slf4j
public class UserServiceTest {
    @Resource
    private UserService userService;
//    @Test
//    public void testSeachUsersByTags(){
//        List<String> tagNameList= Arrays.asList("java");
//        List<User>userList=userService.seachUserByTags(tagNameList);
//        log.info(userList.toString());
//    }
}
