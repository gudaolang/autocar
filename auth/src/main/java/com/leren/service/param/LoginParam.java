package com.leren.service.param;

import javax.validation.constraints.NotNull;

/**
 * @author lee
 * @Date:28/02/2018
 */

public class LoginParam {

    @NotNull(message = "密码不能为空")
    private String password;

    @NotNull(message = "账号不能为空")
    private String username;


    @NotNull(message = "请求资源不能为空")
    private String backUrl;

    @NotNull(message = "登录系统不能为空")
    private String system;

    /**
     * 请求token为空的话 到登录页
     */
    private String reqToken;

    private Integer rememberMe = 0;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Integer rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getReqToken() {
        return reqToken;
    }

    public void setReqToken(String reqToken) {
        this.reqToken = reqToken;
    }
}
