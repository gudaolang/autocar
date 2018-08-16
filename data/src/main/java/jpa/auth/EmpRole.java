package jpa.auth;

/**
 * @author lee
 * @Date:28/02/2018
 */

public class EmpRole {

    private Integer id;

    private String enterpriseId;

    private String shopId;

    /**
     * 用户标识
     */
    private String empUuid;

    /**
     * 角色标识
     */
    private Integer roleId;

    /**
     * 正常:0 停用:1
     */
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getEmpUuid() {
        return empUuid;
    }

    public void setEmpUuid(String empUuid) {
        this.empUuid = empUuid;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
