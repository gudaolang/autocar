package com.leren.service.impl;

import com.leren.CacheConstants;
import com.leren.GlobalComponentConfig;
import com.leren.service.AuthService;
import com.leren.service.param.LoginParam;
import com.util.RedisUtil;
import com.util.result.DataResult;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author lee
 * @Date:28/02/2018
 */
@Service
public class AuthServiceImpl implements AuthService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public DataResult login(LoginParam loginParam) {

        String token = (String) redisUtil.getCacheObject("username_" + loginParam.getUsername() + "_token");

        if (StringUtils.isBlank(token)) {

            // 使用shiro认证
            String username = loginParam.getUsername();
            String password = loginParam.getPassword();

            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            try {
                usernamePasswordToken.setRememberMe(BooleanUtils.toBoolean(loginParam.getRememberMe()));
                Subject subject = SecurityUtils.getSubject();
                subject.login(usernamePasswordToken);
            } catch (UnknownAccountException e) {
                LOGGER.info("异常账号" + username + "登录:账号不存在!");
                return new DataResult(500, "帐号不存在!");
            } catch (IncorrectCredentialsException e) {
                LOGGER.info("账号" + username + "登录失败:密码错误!");
                return new DataResult(500, "密码错误!");
            } catch (LockedAccountException e) {
                LOGGER.info("账号" + username + "账号被锁定!");
                return new DataResult(500, "帐号已锁定!");
            } catch (ExcessiveAttemptsException e) {
                LOGGER.info("账号" + username + "账号被锁定:登录失败次数过多!");
                return new DataResult(500, "登录失败次数过多,账号锁定10分钟!");
            }
            //返回客户所拥有的权限信息

            // 全局会话的code
            redisUtil.setCacheObject(CacheConstants.globalToken(username), UUID.randomUUID().toString(), 3, TimeUnit.HOURS);
        }

        String backUrl = loginParam.getBackUrl();
        if (loginParam.getReqToken() != null && !loginParam.getReqToken().equals(token)) {
            backUrl = "login.html";
        }
        // 回跳登录前地址
        if (StringUtils.isBlank(backUrl)) {
            backUrl = null == GlobalComponentConfig.APP ? "/" : GlobalComponentConfig.APP;
        }
        return new DataResult(200, backUrl);
    }


}
