package cn.iyhome.service.impl;

import cn.iyhome.service.IAccountService;

import java.util.*;

/**
 * @Author: enzo
 * @DateTime: 2019/8/3 14:58
 * @Description: TODO
 */
public class IAccountServiceCollection implements IAccountService {

    private Object[] arrs;
    private List<Object> list;
    private Set<Object> set;

    private Map<String,Object> map;
    private Properties properties;


    public void saveAccount() {
        String s = "IAccountServiceCollection{" +
                "arrs=" + Arrays.toString(arrs) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
        System.out.println(s);
    }

    public void setArrs(Object[] arrs) {
        this.arrs = arrs;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public void setSet(Set<Object> set) {
        this.set = set;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }


}
