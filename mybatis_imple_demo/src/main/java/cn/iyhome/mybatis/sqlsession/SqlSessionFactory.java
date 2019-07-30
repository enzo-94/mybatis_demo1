package cn.iyhome.mybatis.sqlsession;

/**
 * @Author: enzo
 * @DateTime: 2019/7/30 16:50
 * @Description: TODO
 */
public interface SqlSessionFactory {
    /**
     * @return 返回SqlSession核心类
     */
    SqlSession openSession();
}
