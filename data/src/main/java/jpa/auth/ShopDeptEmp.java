package jpa.auth;

import javax.persistence.*;

/**
 * @author lee
 * @Date:28/02/2018
 */

@Entity
public class ShopDeptEmp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String enterpriseId;


    @Column(nullable = false)
    private String shopId;

    //用户标识
    @Column(nullable = false)
    private String empUuid;

    //所在机构
    @Column(nullable = false)
    private Integer deptId;

    //正常:0 删除:-1
    @Column(nullable = false, columnDefinition = "Integer default 0")
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

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
