package cn.iyhome.dao;

import cn.iyhome.domain.QueryVo;
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

    /**
     * 插入数据
     */
    void insertData(User user);

    /**
     * 删除数据
     */
    void deleteData(int key);

    /**
     * 修改数据
     */
    void updateData(User user);

    /**
     * 主键查询
     */
    User findDataByID(int id);

    /**
     * 模糊查询
     */
    List<User> findDataByName(String name);

    /**
     * 查询结果数
     */
    int findNum();

    /**
     * 查找user
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据条件查找
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据ids集合查找数据
     */
    List<User> findUserByIds(QueryVo qv);
}
