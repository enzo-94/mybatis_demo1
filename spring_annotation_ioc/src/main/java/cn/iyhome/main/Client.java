package cn.iyhome.main;

import cn.iyhome.service.impl.IAccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: enzo
 * @DateTime: 2019/8/3 16:19
 * @Description: TODO
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        IAccountServiceImpl iAccountServiceImpl =
                appContext.getBean("iAccountServiceImpl", IAccountServiceImpl.class);

        iAccountServiceImpl.saveAccount();


    }
}
