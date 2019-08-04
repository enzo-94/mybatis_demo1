package cn.iyhome.test;

import cn.iyhome.dao.IUserDao;
import cn.iyhome.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Author: enzo
 * @DateTime: 2019/7/31 16:19
 * @Description: TODO
 */
public class CRUD {

    @Test
    public void testFindAll() throws Exception{
        SqlSessionFactoryBuilder ssFacBuilder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory ssFac = ssFacBuilder.build(is);
        SqlSession sqlSession1 = ssFac.openSession();
        IUserDao iUserDao = sqlSession1.getMapper(IUserDao.class);
        List<User> users1 = iUserDao.findAllUser();
        sqlSession1.clearCache();
        sqlSession1.close();

        System.out.println("==============================");

        SqlSession sqlSession2 = ssFac.openSession();
        IUserDao iUserDao2 = sqlSession2.getMapper(IUserDao.class);
        List<User> users2 = iUserDao2.findAllUser();
        sqlSession2.clearCache();
        sqlSession2.close();


        System.out.println(users1);
        System.out.println(users2);
        System.out.println(users1==users2);
    }
}






























