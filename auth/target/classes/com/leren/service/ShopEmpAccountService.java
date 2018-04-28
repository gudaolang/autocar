package com.leren.service;

import com.leren.entity.auth.EmpRole;
import com.leren.entity.auth.ShopEmpAccount;
import com.leren.entity.auth.ShopEmpPermission;
import com.leren.service.results.EmpRoleResult;
import com.leren.service.results.ShopEmpPermissionResult;

import java.util.List;

/**
 * @author lee
 * @Date:28/02/2018
 */
public interface ShopEmpAccountService {

    ShopEmpAccount getByAccount(String username);

    void updateStatus(String sessionId, int status);

    List<EmpRoleResult> getRolesByShopEmpUuid(String shopEmpUUid);

    List<ShopEmpPermissionResult> getPermissionsByShopEmpUuid(String shopEmpUUid);
}
