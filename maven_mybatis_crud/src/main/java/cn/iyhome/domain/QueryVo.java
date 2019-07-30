package cn.iyhome.domain;

/**
 * @Author: enzo
 * @DateTime: 2019/7/28 20:42
 * @Description: TODO
 */
public class QueryVo {
    private User user;

    public QueryVo(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
