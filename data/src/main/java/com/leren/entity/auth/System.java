package com.leren.entity.auth;

import javax.persistence.*;

/**
 * @author lee
 * @Date:02/03/2018
 */

@Entity
public class System {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, columnDefinition = "VARCHAR(20) comment '系统名称'")
    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(20) comment '系统简写'")
    private String code;

    @Column(nullable = false, columnDefinition = "INTEGER(2) default 0 comment '状态:正常 0;停用:-1'")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
