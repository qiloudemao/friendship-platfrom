package com.wt.friendship.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.friendship.model.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 86178
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2024-07-04 07:46:22
*/
public interface UserService extends IService<User> {

    List<User> seachUserByTags(List<String> tagNameList);

    User getSafetyUser(User originUser);

    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    long userRegister(String userAccount, String userPassword, String checkPassword, String planetCode);

    User getByLogin(HttpServletRequest request);

    int updateByUser(User user, User userLogin);

    boolean isAdmin(HttpServletRequest request);

    boolean isAdmin(User userLogin);

    List<User> matchUsers(long num, User user);
}
