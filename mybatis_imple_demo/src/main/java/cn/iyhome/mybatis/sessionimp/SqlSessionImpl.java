package cn.iyhome.mybatis.sessionimp;

import cn.iyhome.mybatis.Proxy.MapperProxy;
import cn.iyhome.mybatis.cfg.Configuration;
import cn.iyhome.mybatis.sqlsession.SqlSession;
import cn.iyhome.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: enzo
 * @DateTime: 2019/7/30 17:33
 * @Description: TODO
 */
public class SqlSessionImpl implements SqlSession {

    private Configuration config;
    private Connection conn;

    public SqlSessionImpl(Configuration config) {
        this.config = config;
        conn = DataSourceUtil.getConnection(config);
    }

    public <T> T getMapper(Class<T> daoInterfaceClass) {
        T t = (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, new MapperProxy(config.getMappers(), conn));
        return t;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
