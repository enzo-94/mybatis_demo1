package cn.iyhome.test;

import cn.iyhome.dao.IAccountDao;
import cn.iyhome.dao.IUserDao;
import cn.iyhome.domain.Account;
import cn.iyhome.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: enzo
 * @DateTime: 2019/8/2 16:14
 * @Description: TODO
 */
public class m2m_curd {
    private SqlSessionFactoryBuilder ssFacBuilder;
    private InputStream is;
    private SqlSessionFactory ssFac;
    private SqlSession sqlSession;

    /**
     * 初始化
     */
    @Before
    public void init() throws IOException {
        ssFacBuilder = new SqlSessionFactoryBuilder();
        is = Resources.getResourceAsStream("sqlMapConfig.xml");
        ssFac = ssFacBuilder.build(is);
        sqlSession = ssFac.openSession();
    }

    /**
     * 释放资源
     */
    @After
    public void release() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    /**
     * 查找所有账户
     */
    @Test
    public void testFindAllAccount() {
        IAccountDao iAccountDao = sqlSession.getMapper(IAccountDao.class);
        List<Account> accs = iAccountDao.findAll();
        for (Account acc : accs) {
            System.out.println(acc);
        }
    }

    /**根据ID查找账户*/
    @Test
    public void testFindAccountById() {
        IAccountDao iAccountDao = sqlSession.getMapper(IAccountDao.class);
        List<Account> accs = iAccountDao.findAccountById(1);
        System.out.println(accs);
    }

    /**查找账户以及对应的用户信息*/
    @Test
    public void testFindAccount2User() {
        IAccountDao iAccountDao = sqlSession.getMapper(IAccountDao.class);
        List<Account> accs = iAccountDao.findAccount2User();
        for (Account acc : accs) {
            System.out.println(acc);
        }
    }

    /**
     * 查找用户信息以及对应的所有账户
     */
    @Test
    public void testFindUser2AccountsMap() {
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        List<User> u2accs = iUserDao.findUser2Accounts();
        for (User u2acc : u2accs) {
            System.out.println(u2acc);
            //System.out.println(u2acc.getAccounts());
        }
    }

}
