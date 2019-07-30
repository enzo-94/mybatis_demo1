package cn.iyhome.mybatis.sessionimp;

import cn.iyhome.mybatis.cfg.Configuration;
import cn.iyhome.mybatis.sqlsession.SqlSession;

/**
 * @Author: enzo
 * @DateTime: 2019/7/30 17:33
 * @Description: TODO
 */
public class SqlSessionImpl implements SqlSession {

    private Configuration config;

    public SqlSessionImpl(Configuration config) {
        this.config = config;
    }

    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return null;
    }

    public void close() {

    }
}
