package cn.iyhome.dao;

import cn.iyhome.domain.User;

import java.util.List;

/**
 * @Author: enzo
 * @DateTime: 2019/7/28 17:46
 * @Description: TODO
 */
public interface IUserDao {
    /**
     * 查找所有数据
     */
    List<User> findAll();

    /*查找用户名下所有账户信息*/
    List<User> findAllUserAccount();
}
