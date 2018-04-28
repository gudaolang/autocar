package com.leren.entity.auth;

import javax.persistence.*;

/**
 * @author lee
 * @Date:13/03/2018
 */

@Entity
public class ShopRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String enterpriseUuid;

    @Column(nullable = false, length = 50)
    private String shopUuid;

    @Column(nullable = false, length = 50)
    private String roleName;

    @Column(nullable = false, columnDefinition = "Integer(2) comment '正常:0,停用:1,删除:-1'")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseUuid() {
        return enterpriseUuid;
    }

    public void setEnterpriseUuid(String enterpriseUuid) {
        this.enterpriseUuid = enterpriseUuid;
    }

    public String getShopUuid() {
        return shopUuid;
    }

    public void setShopUuid(String shopUuid) {
        this.shopUuid = shopUuid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
