package jpa.auth;

import javax.persistence.*;

/**
 * @author lee
 * @Date:28/02/2018
 */

@Entity
public class EnterpriseModule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String enterpriseId;

    @Column(nullable = false)
    private String moduleId;

    //正常:0 禁用:1
    @Column(nullable = false,columnDefinition = "Integer default 0")
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

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
