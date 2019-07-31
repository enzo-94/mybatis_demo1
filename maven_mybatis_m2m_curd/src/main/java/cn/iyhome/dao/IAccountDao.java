package cn.iyhome.dao;

import cn.iyhome.domain.Account;
import cn.iyhome.domain.AccountUser;

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
    List<Account> findAll();

    /*查找账户以及对应的用户信息*/
    List<AccountUser> findAllAccountUser();
}
