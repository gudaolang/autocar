package com.leren.service.impl;

import com.leren.entity.auth.Enterprise;
import com.leren.service.EnterpriseService;
import com.leren.service.RegisterService;
import com.leren.service.ShopService;
import com.leren.service.param.EpRegisterParam;
import com.leren.service.param.ShopRegisterParam;
import com.util.UUIDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lee
 * @Date:27/03/2018
 */

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private ShopService shopService;

    @Override
    public void registerEnterprise(EpRegisterParam registerParam) {

        Enterprise enterprise = new Enterprise();

        BeanUtils.copyProperties(registerParam, enterprise);

        enterprise.setUuid(UUIDUtil.getUuid());
        enterpriseService.save(enterprise);

        shopService.saveBatch(enterprise.getUuid(), registerParam.getShops());
    }


    @Override
    public void registerShop(ShopRegisterParam registerParam) {
        shopService.save(registerParam);
    }
}
