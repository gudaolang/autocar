package com.leren.service.param;

import javax.validation.constraints.NotNull;

/**
 * @author lee 2018/8/16 10:03
 */
public class ShopAuditInfoParam {

    @NotNull(message = "门店标识不能为空")
    private String shopUuid;

    @NotNull(message = "审核状态不能为空")
    private Integer status;

    private String memo;

    public String getShopUuid() {
        return shopUuid;
    }

    public void setShopUuid(String shopUuid) {
        this.shopUuid = shopUuid;
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
