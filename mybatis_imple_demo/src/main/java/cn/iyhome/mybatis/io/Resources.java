package cn.iyhome.mybatis.io;

import java.io.InputStream;

/**
 * @Author: enzo
 * @DateTime: 2019/7/30 16:46
 * @Description: TODO
 */
public class Resources {
    public static InputStream getResourceAsStream(String filepath) {
        return Resources.class.getClassLoader().getResourceAsStream(filepath);
    }
}
