package com.example.springboot2demo.common.exception;

import com.example.springboot2demo.common.enums.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.DecodeException;

/**
 * @author xnd
 * @since 2023/2/27 8:40
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public Result<String> nullException(NullPointerException e, HttpServletRequest request,
                                        HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        log.error("空指针异常,msg:{}", e);
        return Result.failed("空指针异常");
    }

    @ExceptionHandler(DataException.class)
    public Result<String> dateException(DataException e) {
        log.info(e.getMessage());
        return Result.failed(e.getMessage(), e.getCode());
    }

    @ExceptionHandler(DecodeException.class)
    public Result<String> dateException(DecodeException e) {
        log.info(e.getMessage());
        return Result.failed(e.getMessage(), 406);
    }

    @ExceptionHandler(Exception.class)
    public Result<String> exception(Exception e, HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        log.error(e.getMessage());
        e.printStackTrace();
        return Result.failed(e.getMessage(), HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

}
