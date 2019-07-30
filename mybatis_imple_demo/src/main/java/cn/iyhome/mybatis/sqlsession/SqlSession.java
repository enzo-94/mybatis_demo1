package cn.iyhome.mybatis.sqlsession;

/**
 * @Author: enzo
 * @DateTime: 2019/7/30 16:52
 * @Description: 自定义mybatis中和数据库交互的核心类,它可以创建Dao接口的代理对象
 */
public interface SqlSession {
    /**
     * 根据参数创建代理对象
     * @param daoInterfaceClass dao的字节码对象
     * @param <T>
     * @return
     */
    <T>T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
