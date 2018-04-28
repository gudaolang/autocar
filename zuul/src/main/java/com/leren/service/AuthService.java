package com.leren.service;

import com.leren.service.param.LoginParam;
import com.util.result.DataResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lee
 * @Date:16/03/2018
 */
@FeignClient(name = "auth")
public interface AuthService {


    @RequestMapping(value = "sso/login", method = RequestMethod.GET)
    String redirectLogin();

    @RequestMapping(value = "sso/login", method = RequestMethod.POST)
    DataResult login(@RequestBody LoginParam loginParam);


    @RequestMapping(value = "sso/code", method = RequestMethod.POST)
    DataResult checkCode(String code);
}
