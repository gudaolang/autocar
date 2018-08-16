package jpa.auth;

import javax.persistence.*;

/**
 * @author lee
 * @Date:28/02/2018
 */

@Entity
public class ShopDeptPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Integer deptId;

    @Column(nullable = false)
    private Integer permissionId;

    //正常:0 禁用:1
    @Column(nullable = false, columnDefinition = "Integer default 0")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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
