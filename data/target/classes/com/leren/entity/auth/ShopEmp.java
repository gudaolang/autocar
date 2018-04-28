package com.leren.entity.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author lee
 * @Date:22/02/2018
 */
@Entity
public class ShopEmp {

    @Id
    @Column(nullable = false, length = 50)
    private String uuid;

    @Column(nullable = false)
    private String empUuid;

    @Column(nullable = false)
    private String enterpriseId;

    @Column(nullable = false)
    private String shopId;

    @Column
    private String empCode;

    @Column
    private String avatar;

    //在职:0  离职:1
    @Column(nullable = false, columnDefinition = "Integer default 0")
    private Integer status;

    //入职时间
    @Column
    private Long hireDate;

    //离职时间
    @Column
    private Long leaveDate;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmpUuid() {
        return empUuid;
    }

    public void setEmpUuid(String empUuid) {
        this.empUuid = empUuid;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getHireDate() {
        return hireDate;
    }

    public void setHireDate(Long hireDate) {
        this.hireDate = hireDate;
    }

    public Long getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Long leaveDate) {
        this.leaveDate = leaveDate;
    }
}
