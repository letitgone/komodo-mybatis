package com.komodo.mybatis.session;

import com.komodo.mybatis.configuration.Configuration;
import com.komodo.mybatis.statement.MappedStatement;

import java.util.List;

/**
 * @Author ZhangGJ
 * @Date 2021/04/14 22:32
 */
public class DefaultSqlSession implements SqlSession{

    private Configuration configuration;

//    private Executor simpleExecutor = new SimpleExecutor();

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object... param) {
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
//        List<E> query = simpleExecutor.query(configuration, mappedStatement, param);
//        return query;
        return null;
    }

    @Override
    public <T> T selectOne(String statementId, Object... param) {
        List<Object> objects = selectList(statementId, param);
        if (objects.size() == 1) {
            return (T) objects.get(0);
        } else {
            throw new RuntimeException("Too manny result!");
        }
    }

    @Override
    public void close() {
//        simpleExecutor.close();
    }
}
