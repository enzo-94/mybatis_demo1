package cn.iyhome.main;


import cn.iyhome.service.impl.IAccountServiceCollection;
import cn.iyhome.service.impl.IAccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @Author: enzo
 * @DateTime: 2019/8/3 12:21
 * @Description: TODO
 */
public class Client {
    public static void main(String[] args) {

        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

//        IAccountServiceImpl accountServiceImpl = appContext.getBean("IAccountServiceImpl", IAccountServiceImpl.class);
//        IAccountServiceImpl accountServiceImpl = appContext.getBean("IAccountSerImpBySet", IAccountServiceImpl.class);
//        IAccountServiceImpl accountServiceImpl = appContext.getBean("IAccountSerImpByP", IAccountServiceImpl.class);
//        IAccountServiceCollection accountServiceImpl = appContext.getBean("ICollectionImp", IAccountServiceCollection.class);

        IAccountServiceImpl accountServiceImpl = appContext.getBean("IAccountServiceImpl2", IAccountServiceImpl.class);


        accountServiceImpl.saveAccount();

    }
}
