package com.leren.entity.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author lee
 * @Date:28/02/2018
 */
//企业基本信息
@Entity
public class Enterprise {
    @Id
    private String uuid;

    //企业名称
    @Column(nullable = false)
    private String enterpriseName;

    //企业类型
    @Column(nullable = false)
    private Integer enterpriseType;

    //企业资质编码
    @Column
    private String qualificationCode;

    //企业资质图片
    @Column
    private String qualificationPic;

    //省份编码
    @Column
    private String provinceCode;

    //城市编码
    @Column
    private String cityCode;

    //区域编码
    @Column
    private String regionCode;

    //经度
    @Column
    private Double longitude;
    //维度
    @Column
    private Double latitude;

    //企业地址
    @Column
    private String address;

    //企业法人
    @Column
    private String legalPerson;

    //企业联系电话
    @Column
    private String contactPhone;

    //企业主页
    @Column
    private String homePage;


    @Column(columnDefinition = "bigint(20) comment '注册时间'")
    private Long registerDate;

    @Column(columnDefinition = "bigint(20) comment '审核成功时间'")
    private Long auditDate;

    @Column(columnDefinition = "bigint(20) comment '过期时间'")
    private Long expireDate;

    //未审核:0 正常:1 禁用:2
    @Column(nullable = false, columnDefinition = "Integer default 0")
    private Integer status;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public Integer getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(Integer enterpriseType) {
        this.enterpriseType = enterpriseType;
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

    public String getQualificationCode() {
        return qualificationCode;
    }

    public void setQualificationCode(String qualificationCode) {
        this.qualificationCode = qualificationCode;
    }

    public String getQualificationPic() {
        return qualificationPic;
    }

    public void setQualificationPic(String qualificationPic) {
        this.qualificationPic = qualificationPic;
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

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Long registerDate) {
        this.registerDate = registerDate;
    }

    public Long getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Long auditDate) {
        this.auditDate = auditDate;
    }

    public Long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Long expireDate) {
        this.expireDate = expireDate;
    }
}
