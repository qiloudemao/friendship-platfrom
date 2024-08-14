package com.wt.friendship.exception;

import com.wt.friendship.common.BaseRsponse;
import com.wt.friendship.common.ErrorCode;
import com.wt.friendship.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(BusinessException.class)
    public BaseRsponse businessException(BusinessException e){
        log.error("businessException: "+e.getMessage(),e);
        return ResultUtils.error(e.getCode(),e.getMessage(), e.getDescipetion());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseRsponse runtimeException(RuntimeException e){
        log.error("runtimeException",e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR,e.getMessage(),null);
    }
}
