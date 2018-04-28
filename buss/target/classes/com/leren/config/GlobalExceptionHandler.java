package com.leren.config;

import com.util.RequestUtil;
import com.util.result.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lee
 * @Date:23/02/2018
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private ErrorInfo<String> getException(HttpServletRequest req, Exception e) {
        return RequestUtil.getExceptionJSON(req, e);
    }

}
