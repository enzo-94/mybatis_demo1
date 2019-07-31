package cn.iyhome.dao;

import cn.iyhome.domain.Role;

import java.util.List;

/**
 * @Author: enzo
 * @DateTime: 2019/7/31 17:30
 * @Description: TODO
 */
public interface IRoleDao {
    List<Role> findAllRole();

    List<Role> findRole2User();
}
