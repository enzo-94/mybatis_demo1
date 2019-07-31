package cn.iyhome.test;

import cn.iyhome.dao.IAccountDao;
import cn.iyhome.dao.IUserDao;
import cn.iyhome.domain.Account;
import cn.iyhome.domain.AccountUser;
import cn.iyhome.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: enzo
 * @DateTime: 2019/7/28 17:55
 * @Description: TODO
 */
public class CRUD {
    private SqlSessionFactoryBuilder ssFacBuilder;
    private SqlSessionFactory ssFactory;
    private SqlSession sqlSession;
    private InputStream is;

    @Before
    public void init() throws IOException {
        //获取配置文件
        is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建工厂建筑类
        ssFacBuilder = new SqlSessionFactoryBuilder();
        //创建SQLSessionFactory
        ssFactory = ssFacBuilder.build(is);
        //获得SqlSession
        sqlSession = ssFactory.openSession();

    }

    @After
    public void release() throws IOException {
        sqlSession.close();
        is.close();
    }

    /**
     * 查找用户信息
     */
    @Test
    public void findAll() {
        //
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = iUserDao.findAll();
        if (users == null) {
            System.out.println("===");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    /**
     * 查找账户信息
     */
    @Test
    public void findAllAccount() {
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
        List<Account> accs = accountDao.findAll();
        for (Account acc : accs) {
            System.out.println(acc);

        }
    }


    /**
     * 通过在原来JavaBean中引用其他类来获取账户和用户信息
     */
    @Test
    public void findAllAccountANdUser() {
        //
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
        List<Account> users = accountDao.findAll();
        if (users == null) {
            System.out.println("===");
        } else {
            for (Account acc : users) {
                System.out.println(acc + " " + acc.getUser().getUsername() + " " + acc.getUser().getAddress());
            }
        }
    }

    /**
     * 利用新JavaBean获取账户和用户信息,多对一看成是一对一
     */
    @Test
    public void findAllAccountUser() {
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
        List<AccountUser> accus = accountDao.findAllAccountUser();
        for (AccountUser accu : accus) {
            System.out.println(accu);
        }
    }

    /**
     * 查找用户下所有账户信息,利用原javabean对其他类的引用.一对多
     */
    @Test
    public void findAllUserAccount() {
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> usersacc = userDao.findAllUserAccount();
        for (User user : usersacc) {
            System.out.println(user);
        }
    }

}
