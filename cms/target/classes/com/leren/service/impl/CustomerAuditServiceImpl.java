package com.leren.service.impl;

import com.leren.entity.auth.Enterprise;
import com.leren.entity.auth.Shop;
import com.leren.service.CustomerAuditService;
import com.leren.service.EnterpriseService;
import com.leren.service.ShopService;
import com.leren.service.param.*;
import com.leren.service.results.EnterpriseApplyResult;
import com.leren.service.results.ShopApplyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lee 2018/08/14
 */
@Service
public class CustomerAuditServiceImpl implements CustomerAuditService {

    //Autowired + Qualifier 注入依赖
    @Autowired
    @Qualifier("shopServiceImpl")
    private ShopService shopService;

    //Resource 设置name 注入依赖
    @Resource(name = "enterpriseServiceImpl")
    private EnterpriseService enterpriseService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ShopApplyResult> getApplyShopListByParam(ShopApplyParam applyParam) {
        return shopService.getApplyShopListByParam(applyParam);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int auditShops(ShopAuditParam shopAuditParam) {
        List<ShopAuditInfoParam> shopAuditInfos = shopAuditParam.getAuditInfoParams();
        Shop shop;
        int nResult = 0;
        for (ShopAuditInfoParam auditInfo : shopAuditInfos) {
            shop = new Shop();
            shop.setUuid(auditInfo.getShopUuid());
            shop.setStatus(auditInfo.getStatus());
            shop.setMemo(auditInfo.getMemo());
            nResult += shopService.updateByPrimaryKey(shop);
        }
        return nResult;
    }

    /**
     * 企业审核
     *
     * @param enterpriseAuditInfoParam 企业审核信息
     * @return 审核信息
     */
    @Override
    public int auditEnterprise(EnterpriseAuditInfoParam enterpriseAuditInfoParam) {
        Enterprise enterprise = new Enterprise();
        enterprise.setUuid(enterpriseAuditInfoParam.getEnterpriseUuid());
        enterprise.setStatus(enterpriseAuditInfoParam.getStatus());
        enterprise.setMemo(enterpriseAuditInfoParam.getMemo());
        return enterpriseService.updateByPrimaryKey(enterprise);
    }


    /**
     * 查询申请企业列表
     *
     * @param applyParam 查询参数
     * @return 申请企业列表
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<EnterpriseApplyResult> getApplyEnterpriseListByParam(EnterpriseApplyParam applyParam) {
        return enterpriseService.getApplyEnterpriseListByParam(applyParam);
    }


}
