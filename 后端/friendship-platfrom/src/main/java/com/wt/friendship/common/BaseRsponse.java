package com.wt.friendship.common;

import lombok.Data;

/**
 * 通用返回类
 * @author wt
 * @param <T> 数据类型
 */
@Data
public class BaseRsponse<T> {
    private int code;
    private T data;
    private String message;
    private String description;

    public BaseRsponse(int code, T data, String message,String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description=description;
    }

    public BaseRsponse(int code, T data,String message) {
        this.code = code;
        this.data = data;
        this.message=message;
        this.description=null;
    }

    public BaseRsponse(int code, String message, String description) {
        this.code = code;
        this.data=null;
        this.message = message;
        this.description = description;
    }

    public BaseRsponse(int code, T data) {
        this.code = code;
        this.data = data;
        this.message=null;
        this.description=null;
    }

    public BaseRsponse(ErrorCode errorCode){
        this(errorCode.getCode(),null,errorCode.getMessage(),errorCode.getDescription());
    }
}
