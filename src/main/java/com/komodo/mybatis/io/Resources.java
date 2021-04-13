package com.komodo.mybatis.io;

import java.io.InputStream;

/**
 * @Author ZhangGJ
 * @Date 2021/04/13 23:10
 */
public class Resources {

    public static InputStream getResourceAsStream(String path) {
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }
}
