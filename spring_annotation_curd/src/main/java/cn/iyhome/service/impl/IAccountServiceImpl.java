package cn.iyhome.service.impl;

import cn.iyhome.domain.Account;
import cn.iyhome.dao.IAccountDao;
import cn.iyhome.service.IAccountService;

import java.util.List;

/**
 * @Author: enzo
 * @DateTime: 2019/8/3 20:13
 * @Description: TODO
 */
public class IAccountServiceImpl implements IAccountService {

    private IAccountDao iAccountDao;

    public void setiAccountDao(IAccountDao iAccountDao) {
        this.iAccountDao = iAccountDao;
    }

    public List<Account> findAllAccount() {
        return iAccountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return iAccountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        iAccountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        iAccountDao.updateAccount(account);
    }

    public void deleteAccount(Integer acccountId) {
        iAccountDao.deleteAccount(acccountId);
    }
}
