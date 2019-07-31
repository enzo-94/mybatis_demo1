package cn.iyhome.domain;

import java.util.List;

/**
 * @Author: enzo
 * @DateTime: 2019/7/28 20:42
 * @Description: TODO
 */
public class QueryVo {
    private User user;

    private List<Integer> ids;

    public QueryVo(User user,List<Integer> ids) {
        this.user = user;
        this.ids=ids;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
