package jpa.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author lee
 * @Date:01/03/2018
 */
@Entity
public class ShopEmpAccount implements Serializable {

    @Id
    @Column(nullable = false, length = 50)
    private String uuid;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) comment '门店员工标识'")
    private String shopEmpUuid;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) comment '账号'")
    private String account;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) comment '密码'")
    private String password;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) comment '密码盐'")
    private String pwdSalt;

    @Column(nullable = false, columnDefinition = "INTEGER(2) default 0 comment '账号是否在线:0 离线,1 在线'")
    private Integer online;

    @Column(nullable = false, columnDefinition = "INTEGER(2) default 0 comment '账号是否被锁定:0 未锁定,1 已锁定'")
    private Integer locked;

    @Column(nullable = false, columnDefinition = "BIGINT default 0 comment '最后登录时间'")
    private Long lastLoginTime;

    @Column(nullable = false, columnDefinition = "INTEGER(2) default 0 comment '账号状态:0 正常 1 异常'")
    private Integer status;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) default '127.0.0.1' comment '最后登录IP'")
    private String loginIp;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getShopEmpUuid() {
        return shopEmpUuid;
    }

    public void setShopEmpUuid(String shopEmpUuid) {
        this.shopEmpUuid = shopEmpUuid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPwdSalt() {
        return pwdSalt;
    }

    public void setPwdSalt(String pwdSalt) {
        this.pwdSalt = pwdSalt;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
