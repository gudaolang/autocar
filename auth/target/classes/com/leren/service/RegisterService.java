package com.leren.service;

import com.leren.service.param.EpRegisterParam;
import com.leren.service.param.ShopRegisterParam;

/**
 * @author lee
 * @Date:27/03/2018
 */

public interface RegisterService {
    
    void registerEnterprise(EpRegisterParam registerParam);

    void registerShop(ShopRegisterParam registerParam);
}
