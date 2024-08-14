package com.wt.friendship.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.friendship.common.BaseRsponse;
import com.wt.friendship.common.ErrorCode;
import com.wt.friendship.common.ResultUtils;
import com.wt.friendship.exception.BusinessException;
import com.wt.friendship.model.domain.User;
import com.wt.friendship.model.request.UserLoginRequest;
import com.wt.friendship.model.request.UserRegisterRequest;
import com.wt.friendship.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.wt.friendship.constant.UserConstant.USER_LOGIN_STATE;
import static com.wt.friendship.constant.UserConstant.USER_RECOMMEND;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @Resource
    RedisTemplate redisTemplate;

    @GetMapping("/search/tags")
    public BaseRsponse<List<User>> searchUsers(@RequestParam(required = false) List<String>tagNameList){
    if (CollectionUtils.isEmpty(tagNameList)){
        throw new BusinessException(ErrorCode.PARAMS_ERROR);
    }
    List<User> userList=userService.seachUserByTags(tagNameList);
    return ResultUtils.success(userList);
    }

    @PostMapping("/register")
    public BaseRsponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest){
        if (userRegisterRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        String planetCode = userRegisterRequest.getPlanetCode();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword, planetCode)) {
            return null;
        }
        long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        return ResultUtils.success(result);
    }

    @PostMapping("/login")
    public BaseRsponse<User>userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request){
            if(userLoginRequest==null)
                return ResultUtils.error(ErrorCode.PARAMS_ERROR);
            String userAccount=userLoginRequest.getUserAccount();
            String userPassword=userLoginRequest.getUserPassword();
            if(StringUtils.isAnyBlank(userAccount,userPassword))
                return ResultUtils.error(ErrorCode.PARAMS_ERROR);
            User user=userService.userLogin(userAccount,userPassword,request);
            if(user==null)
            return ResultUtils.error(ErrorCode.ACCOUNT_OR_PASSWORD_ERROR);
            return ResultUtils.success(user);
    }

    @GetMapping("/current")
    public BaseRsponse<User> getCurrentUser(HttpServletRequest request){
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser=(User) userObj;
        if(currentUser==null)
            return ResultUtils.error(ErrorCode.NOT_LOGIN);
        long userId=currentUser.getId();
        User user = userService.getById(userId);
        User safetyUser = userService.getSafetyUser(user);
        return ResultUtils.success(safetyUser);
    }


    @PostMapping("/update")
    public BaseRsponse<Integer> updateUser(@RequestBody User user,HttpServletRequest request){
        //1.检验参数是否为空
        if (user==null)
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        //2.触发更新
        User userLogin = userService.getByLogin(request);
        int result=userService.updateByUser(user,userLogin);
        return ResultUtils.success(result);
    }

    @GetMapping("/recommend")
    public BaseRsponse<Page<User>>recommendUsers(long pageSize,long pageNum,HttpServletRequest request){
        User loginUser = userService.getByLogin(request);
        String redisKey=String.format(USER_RECOMMEND,loginUser.getId());
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //如果有缓存则直接读取
        Page<User> userPage=(Page<User>) valueOperations.get(redisKey);
        if(userPage!= null){
            return  ResultUtils.success(userPage);
        }
        //查数据库
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
//        List<User> userList=userService.list(queryWrapper);
        Page<User> userList=userService.page(new Page<>(pageNum,pageSize),queryWrapper);
//        List<User> list =userList.stream().map(user -> userService.getSafetyUser(user)).collect(Collectors.toList());
        //写入缓存
        //15分钟过期
        valueOperations.set(redisKey,userList,60*15, TimeUnit.SECONDS);
        return ResultUtils.success(userList);
    }

    @GetMapping("/match")
    public BaseRsponse<List<User>>matchUsers(long num,HttpServletRequest request){
        if (num<=0||num>20)
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        User user = userService.getByLogin(request);
        return ResultUtils.success(userService.matchUsers(num,user));

    }

}
