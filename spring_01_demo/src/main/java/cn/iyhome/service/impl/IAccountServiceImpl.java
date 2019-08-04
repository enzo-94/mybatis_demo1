package cn.iyhome.service.impl;

import cn.iyhome.dao.IAccountDao;
import cn.iyhome.dao.impl.IAccountDaoImpl;
import cn.iyhome.service.IAccountService;

/**
 * @Author: enzo
 * @DateTime: 2019/8/3 10:17
 * @Description: TODO
 */
public class IAccountServiceImpl implements IAccountService {

    public IAccountServiceImpl() {
        System.out.println("IAccountServiceImpl对象创建了");
    }

    private IAccountDao accountDao = new IAccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
