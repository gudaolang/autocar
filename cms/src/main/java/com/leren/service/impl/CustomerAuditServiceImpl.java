package com.leren.service.impl;

import com.leren.service.CustomerAuditService;
import com.leren.service.param.EnterpriseApplyParam;
import com.leren.service.param.ShopApplyParam;
import org.omg.CORBA.Object;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lee
 * @Date:13/03/2018
 */
@Service
public class CustomerAuditServiceImpl implements CustomerAuditService {


    @Override
    @Transactional(readOnly = true)
    public List<Object> getApplyShopListByParam(ShopApplyParam applyParam) {
        return null;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void auditShop() {

    }

    @Override
    @Transactional(readOnly = true)
    public List<Object> getApplyEnterpriseListByParam(EnterpriseApplyParam applyParam) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void auditEnterprise() {

    }
}
