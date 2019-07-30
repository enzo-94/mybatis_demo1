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
    SqlSessionFactoryBuilder ssFacBuilder;
    SqlSessionFactory ssFac;
    SqlSession sqlSession;
    InputStream is;
    IUserDao users;

    @Before
    public void init() throws IOException {
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
    }

    @Test
    public void findAll() {
        List<User> allUsers = users.findAll();
        System.out.println(allUsers);
    }
}
