package cn.iyhome.test;

import cn.iyhome.dao.IUserDao;
import cn.iyhome.domain.QueryVo;
import cn.iyhome.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
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

    @Test
    public void findAll() {
        //
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = iUserDao.findAll();
        if (users == null) {
            System.out.println("===");
        }else{
        for (User user : users) {
            System.out.println(user);
        }}
    }

    @Test
    public void insetData(){
        //
        IUserDao users = sqlSession.getMapper(IUserDao.class);
        //
        User user = new User();
        user.setUsername("zhangsan");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("深圳");

        users.insertData(user);

        sqlSession.commit();
        System.out.println(user);
    }

    @Test
    public void delete() {
        IUserDao users = sqlSession.getMapper(IUserDao.class);
        //
        users.deleteData(52);
        sqlSession.commit();
    }

    @Test
    public void updateData() {
        IUserDao users = sqlSession.getMapper(IUserDao.class);
        //
        User user = new User();
        user.setId(51);
        user.setUsername("如花2");
        user.setAddress("中粮商务公园");
        user.setSex("男");
        user.setBirthday(new Date());

        users.updateData(user);

        sqlSession.commit();
    }

    @Test
    public void findDataById(){
        IUserDao users = sqlSession.getMapper(IUserDao.class);
        //
        User user = users.findDataByID(51);

        System.out.println(user);
    }

    @Test
    public void findDataByName() {
        IUserDao users = sqlSession.getMapper(IUserDao.class);

        List<User> us = users.findDataByName("%王%");

        System.out.println(us);
    }

    @Test
    public void findNum() {
        IUserDao users = sqlSession.getMapper(IUserDao.class);

        int num = users.findNum();

        System.out.println(num);
    }

    @Test
    public void findUserByVo() {
        IUserDao users = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setUsername("%王%");

        QueryVo qv = new QueryVo(user);
        List<User> usersUserByVo = users.findUserByVo(qv);

        for (User user1 : usersUserByVo) {
            System.out.println(user1);
        }
    }
}
