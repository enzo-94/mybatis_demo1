package cn.iyhome.service.impl;

import cn.iyhome.dao.IAccountDao;
import cn.iyhome.service.IAccountService;

import java.util.Date;

/**
 * @Author: enzo
 * @DateTime: 2019/8/3 12:16
 * @Description: TODO
 */
public class IAccountServiceImpl implements IAccountService {
    IAccountDao iaccountDao;

    private String username;
    private Date date;

    public IAccountServiceImpl() {
    }

    public IAccountServiceImpl(String username, Date date) {
        this.username = username;
        this.date = date;
    }

    public void saveAccount() {
//        System.out.println("username: "+username+" || date: " +date);
        iaccountDao.saveAccount();
    }

    public void setIaccountDao(IAccountDao iaccountDao) {
        this.iaccountDao = iaccountDao;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
