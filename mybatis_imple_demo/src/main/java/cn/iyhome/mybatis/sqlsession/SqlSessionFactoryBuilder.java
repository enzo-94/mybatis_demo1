package cn.iyhome.mybatis.sqlsession;

import cn.iyhome.mybatis.cfg.Configuration;
import cn.iyhome.mybatis.sessionimp.SqlSessionFactoryImpl;
import cn.iyhome.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @Author: enzo
 * @DateTime: 2019/7/30 16:48
 * @Description: TODO
 */
public class SqlSessionFactoryBuilder {
    /**
     * 创建SqlSessionFactory工厂类
     * @param is
     * @return
     */
    public SqlSessionFactory build(InputStream is) {
        Configuration config = XMLConfigBuilder.loadConfiguration(is);
        return new SqlSessionFactoryImpl(config);
    }
}
