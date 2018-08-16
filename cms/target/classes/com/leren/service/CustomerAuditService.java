package com.leren.service;

import com.leren.service.param.EnterpriseApplyParam;
import com.leren.service.param.EnterpriseAuditInfoParam;
import com.leren.service.param.ShopApplyParam;
import com.leren.service.param.ShopAuditParam;
import com.leren.service.results.EnterpriseApplyResult;
import com.leren.service.results.ShopApplyResult;

import java.util.List;

/**
 * @author lee
 * @Date 2018/08/14
 */

public interface CustomerAuditService {

    /**
     * 查询申请门店列表
     *
     * @param applyParam 查询参数
     * @return 申请门店列表
     */
    List<ShopApplyResult> getApplyShopListByParam(ShopApplyParam applyParam);

    /**
     * 查询申请企业列表
     *
     * @param applyParam 查询参数
     * @return 申请企业列表
     */
    List<EnterpriseApplyResult> getApplyEnterpriseListByParam(EnterpriseApplyParam applyParam);

    /**
     * 门店审核
     *
     * @param shopAuditParam 门店审核参数
     */
    int auditShops(ShopAuditParam shopAuditParam);

    /**
     * 企业审核
     *
     * @param enterpriseAuditInfoParam 企业审核信息
     * @return 审核信息
     */
    int auditEnterprise(EnterpriseAuditInfoParam enterpriseAuditInfoParam);
}
