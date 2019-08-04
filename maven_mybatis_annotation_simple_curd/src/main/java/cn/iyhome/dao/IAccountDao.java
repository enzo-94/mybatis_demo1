package cn.iyhome.dao;

import cn.iyhome.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Author: enzo
 * @DateTime: 2019/7/31 12:05
 * @Description: TODO
 */
public interface IAccountDao {

    /**
     * 查询所有账户
     */
    @Select("select * from account")
    List<Account> findAll();

    @Select("select * from account where uid = #{uid}")
    List<Account> findAccountById(Integer id);


    @Results(id = "Account2UserMap" ,value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "money",column = "money"),
            @Result(property = "user",column = "uid",one = @One(select = "cn.iyhome.dao.IUserDao.findUserById",fetchType = FetchType.LAZY))
    })
    @Select("select * from account")
    List<Account> findAccount2User();



}
