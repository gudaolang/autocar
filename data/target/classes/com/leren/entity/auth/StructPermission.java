package com.leren.entity.auth;

import javax.persistence.*;

/**
 * @author lee
 * @Date:28/02/2018
 */

@Entity
public class StructPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Integer structId;

    @Column(nullable = false)
    private Integer permissionId;

    //正常:0 禁用:1
    @Column(nullable = false,columnDefinition = "Integer default 0")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStructId() {
        return structId;
    }

    public void setStructId(Integer structId) {
        this.structId = structId;
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
