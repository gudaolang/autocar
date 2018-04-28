package com.leren.service;

import com.leren.service.param.EnterpriseApplyParam;
import com.leren.service.param.ShopApplyParam;
import org.omg.CORBA.Object;

import java.util.List;

/**
 * @author lee
 * @Date:13/03/2018
 */

public interface CustomerAuditService {

    List<Object> getApplyShopListByParam(ShopApplyParam applyParam);

    void auditShop();


    List<Object> getApplyEnterpriseListByParam(EnterpriseApplyParam applyParam);

    void auditEnterprise();
}
