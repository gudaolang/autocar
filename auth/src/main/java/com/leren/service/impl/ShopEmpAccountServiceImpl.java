package com.leren.service.impl;

import com.google.common.collect.Maps;
import com.leren.entity.auth.ShopEmpAccount;
import com.leren.mapper.ShopEmpAccountMapper;
import com.leren.service.ShopEmpAccountService;
import com.leren.service.results.EmpRoleResult;
import com.leren.service.results.ShopEmpPermissionResult;
import com.util.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author lee
 * @Date:27/02/2018
 */
@Service
public class ShopEmpAccountServiceImpl implements ShopEmpAccountService {

    @Autowired
    private ShopEmpAccountMapper shopEmpAccountMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ShopEmpAccount getByAccount(String account) {

        Map<String, Object> param = Maps.newHashMapWithExpectedSize(1);
        MapUtils.addToMap(param, "account", account);
        return shopEmpAccountMapper.selectSingleByParam(param);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStatus(String shopEmpUuid, int status) {
        ShopEmpAccount shopEmpAccount = new ShopEmpAccount();
        shopEmpAccount.setUuid(shopEmpUuid);
        shopEmpAccount.setOnline(status);
        shopEmpAccountMapper.updateByPrimaryKeySelective(shopEmpAccount);
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<EmpRoleResult> getRolesByShopEmpUuid(String shopEmpUUid) {
        return null;
    }


    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<ShopEmpPermissionResult> getPermissionsByShopEmpUuid(String shopEmpUuid) {
        return null;
    }
}
