package com.komodo.mybatis.session;

import com.komodo.mybatis.configuration.Configuration;

/**
 * @Author ZhangGJ
 * @Date 2021/04/13 23:15
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
