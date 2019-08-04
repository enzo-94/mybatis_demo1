package cn.iyhome.factory;

import cn.iyhome.service.imp.IAccountServiceImpl;

/**
 * @Author: enzo
 * @DateTime: 2019/8/3 11:48
 * @Description: TODO
 */
public class StaticFactory {
    public static IAccountServiceImpl getAccountService() {
        return new IAccountServiceImpl();
    }
}
