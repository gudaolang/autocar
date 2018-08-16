package com.leren.contorller;

import com.leren.CacheConstants;
import com.leren.service.AuthService;
import com.leren.service.param.LoginParam;
import com.util.RedisUtil;
import com.util.result.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author lee
 * @Date:28/02/2018
 */
@Controller
@RequestMapping("sso")
@Api(value = "单点登录管理", description = "单点登录")
public class SSOController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SSOController.class);

    @Autowired
    private AuthService authService;

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public DataResult login(@Valid @RequestBody LoginParam loginParam, BindingResult result) {

        Assert.isTrue(!result.hasErrors(), get403Error(result));

        return authService.login(loginParam);
    }


    @ApiOperation(value = "校验code")
    @RequestMapping(value = "/code", method = RequestMethod.POST)
    @ResponseBody
    public DataResult checkCode(HttpServletRequest request, @Valid @RequestBody LoginParam loginParam, BindingResult result) {
        Assert.isTrue(!result.hasErrors(), get403Error(result));
        String reqToken = request.getParameter("reqToken");
        String token = (String) redisUtil.getCacheObject(CacheConstants.globalToken(loginParam.getUsername()));
        if (StringUtils.isBlank(reqToken) || !reqToken.equals(token)) {
            return new DataResult(400, "无效code");
        }
        return new DataResult();
    }
}
