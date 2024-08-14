package com.wt.friendship.common;

public class ResultUtils {
    public static <T> BaseRsponse<T> success(T data){
        return new BaseRsponse<>(200,data,"success");
    }
    public static BaseRsponse error(ErrorCode errorCode){
        return new BaseRsponse<>(errorCode);
    }
    public static BaseRsponse error(ErrorCode errorCode,String message,String description){
        return new BaseRsponse<>(errorCode.getCode(),message,description);
    }
    public static BaseRsponse error(ErrorCode errorCode,String description){
        return new BaseRsponse<>(errorCode.getCode(),errorCode.getMessage(),description);
    }
    public static BaseRsponse error(int code,String message,String description){
        return new BaseRsponse<>(code,message,description);
    }
}
