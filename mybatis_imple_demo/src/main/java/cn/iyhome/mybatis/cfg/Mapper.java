package cn.iyhome.mybatis.cfg;


/**
 * @Author: enzo
 * @DateTime: 2019/7/30 17:14
 * @Description: TODO
 */
public class Mapper {
    private String queryString;
    private String resultType;



    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
