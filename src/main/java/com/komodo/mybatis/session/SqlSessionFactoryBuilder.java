package com.komodo.mybatis.session;

import com.komodo.mybatis.configuration.Configuration;
import com.komodo.mybatis.xml.XMLConfiguerBuilder;

import java.io.InputStream;

/**
 * @Author ZhangGJ
 * @Date 2021/04/13 23:12
 */
public class SqlSessionFactoryBuilder {

    private Configuration configuration;

    public SqlSessionFactoryBuilder() {
        this.configuration = new Configuration();
    }

    public SqlSessionFactory build(InputStream inputStream) {
        XMLConfiguerBuilder xmlConfiguerBuilder = new XMLConfiguerBuilder(configuration);
        Configuration configuration = xmlConfiguerBuilder.parseConfiguration(inputStream);
        return new DefaultSqlSessionFactory(configuration);
    }

}
