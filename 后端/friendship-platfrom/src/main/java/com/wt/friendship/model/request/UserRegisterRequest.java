package com.wt.friendship.model.request;

import lombok.Data;

@Data
public class UserRegisterRequest {
    private String userAccount;
    private String userPassword;
    private String checkPassword;
    private String planetCode;
}
