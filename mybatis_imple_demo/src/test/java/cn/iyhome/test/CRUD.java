package cn.iyhome.test;

import cn.iyhome.dao.IUserDao;
import cn.iyhome.domain.User;
import cn.iyhome.mybatis.io.Resources;
import cn.iyhome.mybatis.sqlsession.SqlSession;
import cn.iyhome.mybatis.sqlsession.SqlSessionFactory;
import cn.iyhome.mybatis.sqlsession.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: enzo
 * @DateTime: 2019/7/30 14:58
 * @Description: TODO
 */
public class CRUD {
    /*SqlSessionFactoryBuilder ssFacBuilder;
    SqlSessionFactory ssFac;
    SqlSession sqlSession;
    InputStream is;
    IUserDao users;

    @Before
    public void init() {
        ssFacBuilder = new SqlSessionFactoryBuilder();
        is = Resources.getResourceAsStream("sqlMapConfig.xml");
        ssFac = ssFacBuilder.build(is);
        sqlSession = ssFac.openSession();
        users = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void release() throws IOException {
        //sqlSession.commit();
        sqlSession.close();
        is.close();
    }*/

    @Test
    public void findAll() throws IOException {
        /*List<User> allUsers = users.findAll();
        System.out.println(allUsers);*/
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
