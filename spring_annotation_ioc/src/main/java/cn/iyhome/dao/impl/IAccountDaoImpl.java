package cn.iyhome.dao.impl;

import cn.iyhome.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @Author: enzo
 * @DateTime: 2019/8/3 16:21
 * @Description: TODO
 */
@Repository("iAccountDaoImpl1")
public class IAccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("Dao层执行了saveAccount()方法111");
    }
}
