package com.leren.service.param;

import javax.validation.constraints.NotNull;

/**
 * @author lee 13/03/2018
 */

public class EnterpriseAuditInfoParam extends SessionCommonParam {

    @NotNull(message = "标识不能为空")
    private String enterpriseUuid;

    @NotNull(message = "状态不能为空")
    private Integer status;

    private String memo;

    public String getEnterpriseUuid() {
        return enterpriseUuid;
    }

    public void setEnterpriseUuid(String enterpriseUuid) {
        this.enterpriseUuid = enterpriseUuid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
