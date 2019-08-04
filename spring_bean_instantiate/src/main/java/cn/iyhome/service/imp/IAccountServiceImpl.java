package cn.iyhome.service.imp;

import cn.iyhome.service.IAccountService;

/**
 * @Author: enzo
 * @DateTime: 2019/8/3 11:22
 * @Description: TODO
 */
public class IAccountServiceImpl implements IAccountService {

    public IAccountServiceImpl() {
        System.out.println("IAccountServiceImpl对象创建了");
    }

    public void saveAccount() {
        System.out.println("调用IAccountDaoImpl");
    }

    public void destory() {
        System.out.println("destory");
    }

    public void init() {
        System.out.println("inti...");
    }
}
