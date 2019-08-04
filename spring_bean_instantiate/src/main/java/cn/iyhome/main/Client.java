package cn.iyhome.main;

import cn.iyhome.service.imp.IAccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: enzo
 * @DateTime: 2019/8/3 11:27
 * @Description: TODO
 */
public class Client {
    public static void main(String[] args) {
        //获得核心容器对象
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //通过bean id 获取对象

        //方案一,使用默认无参构造实例化
        IAccountServiceImpl accService = appContext.getBean("accountService", IAccountServiceImpl.class);

        //方案二,使用静态工厂类的方法获取对象
        //IAccountServiceImpl accService = appContext.getBean("accountServiceByStaticFac", IAccountServiceImpl.class);

        //方案三,使用非静态工程类的方法获取对象
//        IAccountServiceImpl accService = appContext.getBean("accountServiceByFac", IAccountServiceImpl.class);



        //调用方法
        accService.saveAccount();

        //关闭
        appContext.close();
    }
}
