package com.leren.service;

import com.leren.service.param.ShopRegisterParam;

import java.util.List;

/**
 * @author lee
 * @Date:28/03/2018
 */

public interface ShopService {

    void saveBatch(String enterpriseUuid, List<ShopRegisterParam> shops);

    void save(ShopRegisterParam registerParam);
}
