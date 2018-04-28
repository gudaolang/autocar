package com.leren.contorller.advice;

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

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> getException(HttpServletRequest req, Exception e) throws Exception {
        return RequestUtil.getExceptionJSON(req, e);
    }

}
