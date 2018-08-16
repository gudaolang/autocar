package com.leren.entity.auth;

public class ShopEmp {
    private String uuid;

    private String avatar;

    private String empCode;

    private String empUuid;

    private String enterpriseId;

    private Long hireDate;

    private Long leaveDate;

    private String shopId;

    private Integer status;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpUuid() {
        return empUuid;
    }

    public void setEmpUuid(String empUuid) {
        this.empUuid = empUuid;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
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
}