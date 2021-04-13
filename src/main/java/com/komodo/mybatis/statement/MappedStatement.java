package com.komodo.mybatis.statement;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author ZhangGJ
 * @Date 2021/04/13 23:09
 */
@Data
public class MappedStatement implements Serializable {

    private static final long serialVersionUID = 2085557782556762597L;

    private Integer id;

    private String sql;

    private Class<?> parameterType;

    private Class<?> resultType;
}
