package com.komodo.mybatis.executor;

import com.komodo.mybatis.configuration.Configuration;
import com.komodo.mybatis.statement.MappedStatement;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author ZhangGJ
 * @Date 2021/04/14 22:45
 */
public interface Executor {

    /**
     * 查询
     *
     * @param configuration
     * @param mappedStatement
     * @param param
     * @param <E>
     * @return
     */
    <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object[] param)
            throws SQLException, NoSuchFieldException, IllegalAccessException,
            InstantiationException, InvocationTargetException, IntrospectionException;

    /**
     * close
     */
    void close() throws SQLException;
}
