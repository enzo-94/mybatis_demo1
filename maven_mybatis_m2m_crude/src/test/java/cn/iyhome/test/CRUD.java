package cn.iyhome.test;

import cn.iyhome.dao.IRoleDao;
import cn.iyhome.dao.IUserDao;
import cn.iyhome.domain.Role;
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
 * @DateTime: 2019/7/31 16:19
 * @Description: TODO
 */
public class CRUD {
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
     * 测试所有用户信息,只有用户信息
     */
    @Test
    public void testFindAllUser() {
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> allUser = userDao.findAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
    }


    /**
     * 测试查找所有角色信息,只包含角色信息
     */
    @Test
    public void testFindAllRole() {
        IRoleDao roleDao = sqlSession.getMapper(IRoleDao.class);
        List<Role> allRole = roleDao.findAllRole();
        for (Role role : allRole) {
            System.out.println(role);
        }
    }

    /**测试根据用户ID查找角色*/
    @Test
    public void testFindRoleByCondition(){
        IRoleDao iRoleDao = sqlSession.getMapper(IRoleDao.class);
        List<Role> roles = iRoleDao.findRoleByCondition(41);
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    @Test
    public void testFindRole2User() {
        IRoleDao roleDao = sqlSession.getMapper(IRoleDao.class);
        List<Role> role2Users = roleDao.findRole2User();
        for (Role role2User : role2Users) {
            System.out.println(role2User);
        }
    }

    @Test
    public void testFindUser2Role() {
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> user2Roles = userDao.findUser2Role();
        /*for (User user2Role : user2Roles) {
            System.out.println(user2Role);
        }*/
    }
}






























