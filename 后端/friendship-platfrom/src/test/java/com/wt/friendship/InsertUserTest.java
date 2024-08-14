package com.wt.friendship;
import java.util.Date;

import com.wt.friendship.model.domain.User;
import com.wt.friendship.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

//@SpringBootTest
//public class InsertUserTest {
//    @Resource
//    private UserService userService;
//    @Test
//    public void doInsertUser(){
//    final int INSERT_NUM=1000;
//    List<User> userList=new ArrayList<User>();
//        for (int i = 0; i < INSERT_NUM; i++) {
//            User user = new User();
//            user.setId(0L);
//            user.setUsername("");
//            user.setUserAccount("");
//            user.setAvatarUrl("");
//            user.setGender(0);
//            user.setUserPassword("");
//            user.setPhone("");
//            user.setEmail("");
//            user.setUserStatus(0);
//            user.setCreateTime(new Date());
//            user.setUpdateTime(new Date());
//            user.setIsDelete(0);
//            user.setUserRole(0);
//            user.setPlanetCode("");
//            user.setTags("");
//            user.setProfile("");
//            userList.add(user);
//        }
//        userService.saveBatch(userList,100);
//    }
//
//}
