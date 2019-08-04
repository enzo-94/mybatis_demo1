package cn.iyhome.dao;

import cn.iyhome.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * @Author: enzo
 * @DateTime: 2019/7/31 16:55
 * @Description: TODO
 */
public interface IUserDao {
    /**
     * 查找所有用户
     *
     * @return User对象的集合
     */
    @Select("select * from user")
    @Results(id = "UserMap",
            value = {
                    @Result(id = true, column = "id", property = "userId"),
            }
    )
    List<User> findAllUser();

    @SelectKey(statement = "select last_insert_id()", keyProperty = "userId", keyColumn = "id", before = false, resultType = Integer.class)
    @Insert("insert into user values(null,#{username},#{birthday},#{sex},#{address})")
    void Save(User user);

    @Update("update user set username=#{username} where id=#{userId}")
    void modify(User user);

    @Delete("delete from user where id=#{userId}")
    void delete(User user);

    /**
     * 方案一:传递多个条件
     */
    @Select("select * from user where username like #{username} and sex = #{sex}")
    List<User> findUserByNameAndSex(@Param("username") String username, @Param("sex") String sex);

    /**
     * 方案二:传递JavaBean
     */
    @Select("select * from user where username like #{username} and sex = #{sex}")
    List<User> findUserByNameAndSex2(User user);

    /**
     * 方案三:使用Map集合
     */
    @Select("select * from user where username like #{username} and sex = #{sex}")
    List<User> findUserByNameAndSex3(Map map);

    /**
     * 通过id查找
     */
    @Select("select * from user where id = #{id}")
    @ResultMap("UserMap")
    User findUserById(Integer id);


    /**
     * 查找用户以及用户的账户信息
     */
    @Select("select * from user")
    @Results(id = "User2AccountsMap",value = {
            @Result(id = true,property ="userId",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "address",column = "address"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "accounts",column = "id",many = @Many(select = "cn.iyhome.dao.IAccountDao.findAccountById",fetchType = FetchType.LAZY))
    })
    List<User> findUser2Accounts();
}
