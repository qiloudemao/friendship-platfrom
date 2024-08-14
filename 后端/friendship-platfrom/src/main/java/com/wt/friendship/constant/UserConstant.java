package com.wt.friendship.constant;

public interface UserConstant {
    /**
     * 用户登录态键
     */
    String USER_LOGIN_STATE="userLoginState";
    /**
     * 默认权限
     */
    int DEFAULT_ROLE=0;

    int ADMIN_ROLE=1;

    /**
     * redis用户推荐
     */
    String USER_RECOMMEND="wt:user:recommend:%s";
    /**
     * redisson用户缓存
     */
    String USER_CACHE_LOCK="wt:precachejob:docache:lock";

}
