package cn.iyhome.service.impl;

import cn.iyhome.dao.IAccountDao;
import cn.iyhome.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @Author: enzo
 * @DateTime: 2019/8/3 16:18
 * @Description: TODO
 */
@Service("iAccountServiceImpl")
public class IAccountServiceImpl implements IAccountService{

    /*@Autowired
    @Qualifier("iAccountDaoImpl2")*/
    @Resource(name="iAccountDaoImpl2")
    private IAccountDao iAccountDaoImpl;


    public void saveAccount() {
        iAccountDaoImpl.saveAccount();
    }
}
