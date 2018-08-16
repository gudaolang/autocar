package com.leren.service;

import com.leren.entity.auth.ShopEmpAccount;
import com.leren.service.results.EmpRoleResult;
import com.leren.service.results.ShopEmpPermissionResult;

import java.util.List;

/**
 * @author lee
 * @Date:28/02/2018
 */
public interface ShopEmpAccountService {

    /**
     * 根据用户名获取账号信息
     *
     * @param username 用户名
     * @return 账号信息
     */
    ShopEmpAccount getByAccount(String username);


    /**
     * 根据账号标识更新账号状态
     *
     * @param shopEmpUuid 账号标识
     * @param status      状态
     */
    void updateStatus(String shopEmpUuid, int status);

    /**
     * 获取人员角色信息
     *
     * @param shopEmpUuid 账号标识
     * @return 角色列表
     */
    List<EmpRoleResult> getRolesByShopEmpUuid(String shopEmpUuid);

    /**
     * 获取人员权限信息
     *
     * @param shopEmpUuid 账号标识
     * @return 权限列表
     */
    List<ShopEmpPermissionResult> getPermissionsByShopEmpUuid(String shopEmpUuid);
}
