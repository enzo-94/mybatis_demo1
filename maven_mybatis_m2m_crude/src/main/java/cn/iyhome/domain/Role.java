package cn.iyhome.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: enzo
 * @DateTime: 2019/7/31 17:24
 * @Description: TODO
 */
public class Role implements Serializable {
    private Integer roleId;
    private String roleName;
    private String roleDesc;

    private List<User> userList = new ArrayList<User>();

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", userList=" + userList +
                '}';
    }
}
