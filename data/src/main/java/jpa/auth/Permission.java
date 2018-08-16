package jpa.auth;

import javax.persistence.*;

/**
 * @author lee
 * @Date:28/O2/2O18
 */

@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, columnDefinition = "INTEGER(2) comment '系统标识'")
    private Integer systemId;

    //权限名称
    //格式:system:menu:view/system:oper:visible/system:dir:visible or invisible
    @Column(nullable = false)
    private String permissionName;

    //路径
    @Column
    private String url;

    //父级权限标识
    @Column(nullable = false)
    private Integer parentId;

    //图标
    @Column
    private String icon;

    //权限值
    @Column
    private String permissionValue;

    //权限类型:1,目录 2,菜单 3,按钮(操作)
    @Column(nullable = false)
    private Integer type;


    //所属模块
    @Column(nullable = false)
    private Integer moduleId;

    //序号
    @Column
    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPermissionValue() {
        return permissionValue;
    }

    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }


}
