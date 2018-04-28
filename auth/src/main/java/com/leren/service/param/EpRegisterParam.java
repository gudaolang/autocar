package com.leren.service.param;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author lee
 * @Date:14/03/2018
 */

public class EpRegisterParam {

    @NotNull(message = "企业名称不能为空")
    private String enterpriseName;

    private String provinceCode;

    private String cityCode;

    private String regionCode;

    private String contactPhone;

    private String contactName;

    private String legalPerson;

    private String homePage;

    @NotEmpty(message = "门店信息不能为空")
    private List<ShopRegisterParam> shops;

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
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

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public List<ShopRegisterParam> getShops() {
        return shops;
    }

    public void setShops(List<ShopRegisterParam> shops) {
        this.shops = shops;
    }

}
