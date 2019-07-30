package cn.iyhome.dao;

import cn.iyhome.domain.User;

import java.util.List;

/**
 * @Author: enzo
 * @DateTime: 2019/7/30 12:17
 * @Description: TODO
 */
public interface IUserDao {
    /**
     * @return 所有用户对象
     */
    List<User> findAll();


}
