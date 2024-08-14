package com.wt.friendship.exception;

import com.wt.friendship.common.ErrorCode;

public class BusinessException extends RuntimeException{
    private final int code;
    private final String descipetion;

    public    BusinessException(String message, int code, String descipetion) {
        super(message);
        this.code = code;
        this.descipetion = descipetion;
    }
    public BusinessException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.code=errorCode.getCode();
        this.descipetion=errorCode.getDescription();
    }
    public BusinessException(ErrorCode errorCode,String descipetion){
        super(errorCode.getMessage());
        this.code=errorCode.getCode();
        this.descipetion=descipetion;
    }

    public int getCode() {
        return code;
    }

    public String getDescipetion() {
        return descipetion;
    }
}
