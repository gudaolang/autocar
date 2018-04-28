package com.leren.entity.auth;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author lee
 * @Date:22/02/2018
 */
@Entity
public class Emp {

    @Id
    @Column(nullable = false, length = 50)
    private String uuid;

    @Column(nullable = false)
    private String empName;

    @Column(nullable = true)
    private String idNo;

    //性别:0 男  1 女
    @Column(nullable = true)
    private Integer gender;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = true)
    private Long birthday;

    @Column(nullable = true)
    private String avatar;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String provinceCode;

    @Column(nullable = true)
    private String cityCode;

    @Column(nullable = true)
    private String regionCode;

    @Column(nullable = true)
    private String address;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

}
