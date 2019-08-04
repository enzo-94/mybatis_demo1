package cn.iyhome.ui;

import cn.iyhome.dao.impl.IAccountDaoImpl;
import cn.iyhome.service.impl.IAccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @Author: enzo
 * @DateTime: 2019/8/3 10:17
 * @Description: TODO
 */
public class Client {
    public static void main(String[] args) {

//        IAccountService accountService = new IAccountServiceImpl();

        //ApplicationContext的实现类加载配置文件,获取核心容器对象
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //读取<bean/>标签的id属性,创建对象
        IAccountServiceImpl accountService = appContext.getBean("accountService",IAccountServiceImpl.class);
        IAccountDaoImpl accountDao = appContext.getBean("accountDao", IAccountDaoImpl.class);
        //调用对象方法
        accountService.saveAccount();

        /*BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        IAccountServiceImpl as = bf.getBean("accountService",IAccountServiceImpl.class);
        IAccountServiceImpl as1 = bf.getBean("accountService",IAccountServiceImpl.class);
        System.out.println(as);
        System.out.println(as1);
        as.saveAccount();*/

    }
}
