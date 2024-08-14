package com.wt.friendship.model.request;

import lombok.Data;

@Data
public class TeamJoinRequest {
    /**
     2.编写接口方法
     在service层中编写joinTeam方法
     实现该接口
     * id
     */
    private Long teamId;
    /**
     * 密码
     */
    private String password;
}
