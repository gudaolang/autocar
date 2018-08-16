package com.leren.service.param;

import com.util.page.Page;

/**
 * @author lee
 * @Date 2018/8/14
 */

public class EnterpriseApplyParam extends Page {

    private String enterpriseName;

    private String mobile;


    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
