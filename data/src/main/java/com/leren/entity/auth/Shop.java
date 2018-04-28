package com.leren.entity.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author lee
 * @Date:28/02/2018
 */

@Entity
public class Shop {
    @Id
    private String uuid;

    @Column(nullable = false, columnDefinition = "varchar(50) default 0")
    private String enterpriseUuid;

    @Column(nullable = false)
    private String shopName;

    @Column
    private String shopNo;

    @Column
    private String bussScope;

    @Column
    private String shopType;

    @Column
    private String provinceCode;

    @Column
    private String cityCode;

    @Column
    private String regionCode;

    @Column
    private String address;

    @Column
    private Double longitude;

    @Column
    private Double latitude;


    @Column(nullable = false)
    private String shopChargerMobile;

    @Column
    private String shopChargerName;

    @Column(nullable = false)
    private String shopChargerEmpUuid;

    //0 营业中 1,未营业
    @Column(columnDefinition = "Integer default 0")
    private Integer operationState;

    @Column(nullable = false)
    private Integer accountNums;

    //正常:0 禁用:1
    @Column(nullable = false, columnDefinition = "Integer default 0")
    private Integer status;

    //非总店:0  总店:1
    @Column(nullable = false, columnDefinition = "Integer default 1")
    private Integer blMaster;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public String getEnterpriseUuid() {
        return enterpriseUuid;
    }

    public void setEnterpriseUuid(String enterpriseUuid) {
        this.enterpriseUuid = enterpriseUuid;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getBussScope() {
        return bussScope;
    }

    public void setBussScope(String bussScope) {
        this.bussScope = bussScope;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getShopChargerMobile() {
        return shopChargerMobile;
    }

    public void setShopChargerMobile(String shopChargerMobile) {
        this.shopChargerMobile = shopChargerMobile;
    }

    public String getShopChargerName() {
        return shopChargerName;
    }

    public void setShopChargerName(String shopChargerName) {
        this.shopChargerName = shopChargerName;
    }

    public String getShopChargerEmpUuid() {
        return shopChargerEmpUuid;
    }

    public void setShopChargerEmpUuid(String shopChargerEmpUuid) {
        this.shopChargerEmpUuid = shopChargerEmpUuid;
    }

    public Integer getOperationState() {
        return operationState;
    }

    public void setOperationState(Integer operationState) {
        this.operationState = operationState;
    }

    public Integer getAccountNums() {
        return accountNums;
    }

    public void setAccountNums(Integer accountNums) {
        this.accountNums = accountNums;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
