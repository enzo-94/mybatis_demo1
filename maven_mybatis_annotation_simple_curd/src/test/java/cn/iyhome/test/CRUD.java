package cn.iyhome.test;

import cn.iyhome.dao.IUserDao;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 查找所有
     */
    @Test
    public void testFindAll() {
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        List<User> allUser = iUserDao.findAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
    }

    /**
     * 插入数据
     */
    @Test
    public void testInsert() {
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setUsername("lisi");
        user.setAddress("高老庄");
        user.setSex("男");
        user.setBirthday(new Date());
        iUserDao.Save(user);
        System.out.println(user);
    }

    /**
     * 更新数据
     */
    @Test
    public void testModify() {
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setUsername("悟空");
        user.setUserId(53);
        iUserDao.modify(user);
    }

    /**
     * 删除数据
     */
    @Test
    public void testDelete() {
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setUserId(52);
        iUserDao.delete(user);
    }

    /**
     * 通过名字和性别模糊查找,方案一
     */
    @Test
    public void testFindUserByNameAndSex() {
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = iUserDao.findUserByNameAndSex("%王%", "男");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 通过名字和性别模糊查找,方案二
     */
    @Test
    public void testFindUserByNameAndSex2() {
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        User u = new User();
        u.setUsername("%王%");
        u.setSex("男");
        List<User> users = iUserDao.findUserByNameAndSex2(u);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 通过名字和性别模糊查找,方案三
     */
    @Test
    public void testFindUserByNameAndSex3() {
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        Map map = new HashMap();
        map.put("username", "%王%");
        map.put("sex","男");
        List<User> users = iUserDao.findUserByNameAndSex3(map);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**通过Id查找*/
    @Test
    public void testFindUserById() {
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        User user = iUserDao.findUserById(53);
        System.out.println(user);
    }

}






























