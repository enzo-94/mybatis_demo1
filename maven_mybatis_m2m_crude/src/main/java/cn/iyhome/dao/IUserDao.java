package cn.iyhome.dao;

import cn.iyhome.domain.Role;
import cn.iyhome.domain.User;

import java.util.List;

/**
 * @Author: enzo
 * @DateTime: 2019/7/31 16:55
 * @Description: TODO
 */
public interface IUserDao {
    /**
     * 查找所有用户
     * @return User对象的集合
     */
    List<User> findAllUser();

    List<User> findUser2Role();
}
