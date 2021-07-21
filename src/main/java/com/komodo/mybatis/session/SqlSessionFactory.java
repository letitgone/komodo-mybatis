package com.komodo.mybatis.session;

/**
 * @Author ZhangGJ
 * @Date 2021/04/13 23:15
 */
public interface SqlSessionFactory {

    SqlSession openSession();
}
