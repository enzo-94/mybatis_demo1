package cn.iyhome.test;

import cn.iyhome.domain.Account;
import cn.iyhome.service.impl.IAccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: enzo
 * @DateTime: 2019/8/4 9:45
 * @Description: TODO
 */
public class Client {
    @Test
    public void testsFindAllAccount() {
        //加载配置文件,获取Spring容器
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取配置文件创建好的对象
        IAccountServiceImpl iAccountServiceImpl = appContext.getBean("iAccountServiceImpl", IAccountServiceImpl.class);
        //调用方法
        List<Account> allAccount = iAccountServiceImpl.findAllAccount();
        //遍历
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindAccountById() {
        //加载配置文件,获取Spring容器
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取配置文件创建好的对象
        IAccountServiceImpl iAccountServiceImpl = appContext.getBean("iAccountServiceImpl", IAccountServiceImpl.class);
        //
        Account accountById = iAccountServiceImpl.findAccountById(1);
        //
        System.out.println(accountById);
    }

    @Test
    public void testUpdateAccount() {
        //加载配置文件,获取Spring容器
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取配置文件创建好的对象
        IAccountServiceImpl iAccountServiceImpl = appContext.getBean("iAccountServiceImpl", IAccountServiceImpl.class);
        //
        Account account = new Account();
        account.setId(1);
        account.setMoney(1000);
        account.setName("zs");
        iAccountServiceImpl.updateAccount(account);
    }

    @Test
    public void testSaveAccount() {
        //加载配置文件,获取Spring容器
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取配置文件创建好的对象
        IAccountServiceImpl iAccountServiceImpl = appContext.getBean("iAccountServiceImpl", IAccountServiceImpl.class);
        //
        Account account = new Account();
        account.setMoney(2000);
        account.setName("ls");
        iAccountServiceImpl.saveAccount(account);
    }

    @Test
    public void testDeleteAccount() {
        //加载配置文件,获取Spring容器
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取配置文件创建好的对象
        IAccountServiceImpl iAccountServiceImpl = appContext.getBean("iAccountServiceImpl", IAccountServiceImpl.class);
        //
        iAccountServiceImpl.deleteAccount(2);
    }
}
