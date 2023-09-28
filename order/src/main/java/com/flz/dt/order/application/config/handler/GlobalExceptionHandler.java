package com.flz.dt.order.application.config.handler;

import com.flz.dt.common.dto.ErrorResult;
import com.flz.dt.common.exception.BusinessException;
import com.flz.dt.common.exception.UnAuthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handleBusinessException(BusinessException e) {
        log.error("BusinessException:", e);
        return ErrorResult.of(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResult handleUnAuthorizedException(UnAuthorizedException e) {
        log.error("UnAuthorizedException:", e);
        return ErrorResult.of(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResult handleThrowable(Throwable throwable) {
        log.error("Unknown error:", throwable);
        return ErrorResult.of(throwable.getMessage());
    }
}
