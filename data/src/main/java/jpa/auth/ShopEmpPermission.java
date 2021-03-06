package jpa.auth;

import javax.persistence.*;

/**
 * @author lee
 * @Date:28/02/2018
 */

//用户权限 = 用户所属角色权限 + 用户自身权限 + 用户所属部门权限
@Entity
public class ShopEmpPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String shopEmpUuid;

    @Column(nullable = false)
    private Integer permissionId;

    //状态: 正常:0 禁用:1
    @Column(nullable = false, columnDefinition = "Integer default 0")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopEmpUuid() {
        return shopEmpUuid;
    }

    public void setShopEmpUuid(String shopEmpUuid) {
        this.shopEmpUuid = shopEmpUuid;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

