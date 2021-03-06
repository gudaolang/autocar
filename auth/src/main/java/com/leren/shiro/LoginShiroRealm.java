package com.leren.shiro;

import com.leren.CacheConstants;
import com.leren.entity.auth.ShopEmpAccount;
import com.leren.service.impl.ShopEmpAccountServiceImpl;
import com.leren.service.results.EmpRoleResult;
import com.leren.service.results.ShopEmpPermissionResult;
import com.util.RedisUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lee
 * @Date:27/02/2018
 */
public class LoginShiroRealm extends AuthorizingRealm {


    @Resource
    private ShopEmpAccountServiceImpl shopEmpAccountService;

    @Resource
    private RedisUtil redisUtil;

    /**
     * 获取登录人员权限(角色/权限信息)
     *
     * @param principals 参数主体
     * @return 主体权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String username = (String) principals.getPrimaryPrincipal();

        ShopEmpAccount empAccount = shopEmpAccountService.getByAccount(username);

        if (empAccount == null) {
            throw new UnknownAccountException();
        }

        String shopEmpUuid = empAccount.getShopEmpUuid();

        List<EmpRoleResult> empRoles = shopEmpAccountService.getRolesByShopEmpUuid(shopEmpUuid);

        Set<String> roles = empRoles.stream().map(EmpRoleResult::getRoleName).collect(Collectors.toSet());

        //获取用户权限
        List<ShopEmpPermissionResult> shopEmpPermissions = shopEmpAccountService.getPermissionsByShopEmpUuid(shopEmpUuid);

        Set<String> permissions = shopEmpPermissions.stream().map(ShopEmpPermissionResult::getPermissionName).collect(Collectors.toSet());

        //保存权限信息以及角色信息
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        simpleAuthorizationInfo.setStringPermissions(permissions);

        simpleAuthorizationInfo.setRoles(roles);

        return simpleAuthorizationInfo;
    }


    /**
     * 认证客户信息
     *
     * @param token 身份验证信息
     * @return 认证信息
     * @throws AuthenticationException 认证异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        String username = userToken.getUsername();

        ShopEmpAccount empAccount = shopEmpAccountService.getByAccount(username);

        if (null == empAccount) {
            throw new UnknownAccountException();
        }
        redisUtil.setCacheObject(CacheConstants.user(username), empAccount);

        if (empAccount.getLocked() == 1) {
            throw new LockedAccountException();
        }

        return new SimpleAuthenticationInfo(username, empAccount.getPassword(),
                ByteSource.Util.bytes(empAccount.getPwdSalt()), LoginShiroRealm.class.getSimpleName());
    }

}
