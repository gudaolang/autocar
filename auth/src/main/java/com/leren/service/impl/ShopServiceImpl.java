package com.leren.service.impl;

import com.leren.entity.auth.Shop;
import com.leren.mapper.ShopMapper;
import com.leren.service.ShopService;
import com.leren.service.param.ShopRegisterParam;
import com.util.UUIDUtil;
import org.apache.shiro.util.Assert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lee
 * @Date:28/03/2018
 */

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public void saveBatch(String enterpriseUuid, List<ShopRegisterParam> registerShops) {

        Assert.notEmpty(registerShops, "门店信息不能为空");
        List<Shop> shops = registerShops.stream().map(item -> {
            Shop shop = new Shop();
            BeanUtils.copyProperties(item, shop);
            shop.setUuid(UUIDUtil.getUuid());
            shop.setEnterpriseUuid(enterpriseUuid);
            return shop;
        }).collect(Collectors.toList());

        shopMapper.insertBatch(shops);
    }

    @Override
    public void save(ShopRegisterParam registerParam) {

        Shop shop = new Shop();
        BeanUtils.copyProperties(registerParam, shop);
        shop.setUuid(UUIDUtil.getUuid());
        shopMapper.insert(shop);
    }
}
