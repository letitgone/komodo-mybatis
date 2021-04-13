package com.komodo.mybatis.configuration;

import com.komodo.mybatis.statement.MappedStatement;
import lombok.Data;

import javax.sql.DataSource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ZhangGJ
 * @Date 2021/04/13 23:02
 */
@Data
public class Configuration implements Serializable {

    private static final long serialVersionUID = -3191976016299597063L;

    private DataSource dataSource;

    private Map<String, MappedStatement> mappedStatementMap = new HashMap<>();

}
