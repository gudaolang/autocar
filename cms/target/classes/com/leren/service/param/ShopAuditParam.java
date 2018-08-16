package com.leren.service.param;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * @author lee 13/03/2018
 */

public class ShopAuditParam extends SessionCommonParam {

    @NotEmpty(message = "审核信息不能为空")
    private List<ShopAuditInfoParam> auditInfoParams;

    public List<ShopAuditInfoParam> getAuditInfoParams() {
        return auditInfoParams;
    }

    public void setAuditInfoParams(List<ShopAuditInfoParam> auditInfoParams) {
        this.auditInfoParams = auditInfoParams;
    }
}
