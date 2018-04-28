package com.leren.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lee
 * @Date:28/02/2018
 */

public class BaseController {

    public static String get403Error(BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            return errors.stream().map(err -> err.getDefaultMessage()).collect(Collectors.joining(","));
        }
        return null;
    }

}
