package com.komodo.mybatis.session;

import java.util.List;

/**
 * @Author ZhangGJ
 * @Date 2021/04/14 22:30
 */
public interface SqlSession {

    /**
     * 查询所有
     *
     * @param statementId
     * @param param
     * @param <E>
     * @return
     */
    <E> List<E> selectList(String statementId, Object... param);

    /**
     * 查询一个
     *
     * @param statementId
     * @param param
     * @param <T>
     * @return
     */
    <T> T selectOne(String statementId, Object... param);

    /**
     * close
     */
    void close();
}
