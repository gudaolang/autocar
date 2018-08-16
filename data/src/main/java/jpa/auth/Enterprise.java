package jpa.auth;

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
    @Column(nullable = false, columnDefinition = "varchar(100) comment '企业资质编码'")
    private String enterpriseName;

    //企业类型
    @Column(columnDefinition = "Integer(2) comment '企业类型'")
    private Integer enterpriseType;

    //企业资质编码
    @Column(columnDefinition = "varchar(100) comment '企业资质编码'")
    private String qualificationCode;

    //企业资质图片
    @Column(columnDefinition = "varchar(200) comment '企业资质图片'")
    private String qualificationPic;

    //省份编码
    @Column(columnDefinition = "varchar(20) comment '省份编码'")
    private String provinceCode;

    //城市编码
    @Column(columnDefinition = "varchar(20) comment '城市编码'")
    private String cityCode;

    //区域编码
    @Column(columnDefinition = "varchar(20) comment '区域编码'")
    private String regionCode;

    //经度
    @Column(columnDefinition = "double comment '经度'")
    private Double longitude;
    //维度
    @Column(columnDefinition = "double comment '维度'")
    private Double latitude;

    //企业地址
    @Column(columnDefinition = "varchar(200) comment '企业地址'")
    private String address;

    //企业法人
    @Column(columnDefinition = "varchar(50) comment '企业法人'")
    private String legalPerson;

    //企业联系电话
    @Column(columnDefinition = "varchar(20) comment '企业联系电话'")
    private String contactPhone;

    //企业主页
    @Column(columnDefinition = "varchar(200) comment '企业主页地址'")
    private String homePage;


    @Column(columnDefinition = "bigint(20) comment '注册时间'")
    private Long registerMills;

    @Column(columnDefinition = "bigint(20) comment '审核成功时间'")
    private Long auditMills;

    @Column(columnDefinition = "bigint(20) comment '过期时间'")
    private Long expireMills;

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

    public Long getRegisterMills() {
        return registerMills;
    }

    public void setRegisterMills(Long registerMills) {
        this.registerMills = registerMills;
    }

    public Long getAuditMills() {
        return auditMills;
    }

    public void setAuditMills(Long auditMills) {
        this.auditMills = auditMills;
    }

    public Long getExpireMills() {
        return expireMills;
    }

    public void setExpireMills(Long expireMills) {
        this.expireMills = expireMills;
    }
}
