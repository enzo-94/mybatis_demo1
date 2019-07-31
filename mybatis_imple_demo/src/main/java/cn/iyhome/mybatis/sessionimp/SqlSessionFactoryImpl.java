package cn.iyhome.mybatis.sessionimp;

import cn.iyhome.mybatis.cfg.Configuration;
import cn.iyhome.mybatis.sqlsession.SqlSession;
import cn.iyhome.mybatis.sqlsession.SqlSessionFactory;

import java.sql.SQLException;

/**
 * @Author: enzo
 * @DateTime: 2019/7/30 17:32
 * @Description: TODO
 */
public class SqlSessionFactoryImpl implements SqlSessionFactory {

    private Configuration config;

    public SqlSessionFactoryImpl(Configuration config) {
        this.config=config;
    }
    public SqlSession openSession(){
        return new SqlSessionImpl(config);
    }
}
