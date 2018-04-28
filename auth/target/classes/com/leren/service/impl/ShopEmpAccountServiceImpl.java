package com.leren.service.impl;

import com.leren.entity.auth.ShopEmpAccount;
import com.leren.mapper.ShopEmpAccountMapper;
import com.leren.service.ShopEmpAccountService;
import com.leren.service.results.EmpRoleResult;
import com.leren.service.results.ShopEmpPermissionResult;
import com.util.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lee
 * @Date:01/03/2018
 */

@Service
public class ShopEmpAccountServiceImpl implements ShopEmpAccountService {

    @Resource
    private ShopEmpAccountMapper shopEmpAccountMapper;


    @Override
    @Transactional(readOnly = true)
    public ShopEmpAccount getByAccount(String account) {
        Map<String, Object> param = new HashMap<>();
        MapUtils.addToMap(param, "account", account);
        return shopEmpAccountMapper.selectSingleByParam(param);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStatus(String uuid, int status) {
        ShopEmpAccount shopEmpAccount = new ShopEmpAccount();
        shopEmpAccount.setUuid(uuid);
        shopEmpAccount.setOnline(status);
        shopEmpAccountMapper.updateByPrimaryKeySelective(shopEmpAccount);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmpRoleResult> getRolesByShopEmpUuid(String shopEmpUUid) {
        return null;
    }


    /**
     * 获取组织架构以及用户自己的权限
     *
     * @param shopEmpUuid
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<ShopEmpPermissionResult> getPermissionsByShopEmpUuid(String shopEmpUuid) {
        return null;
    }
}
