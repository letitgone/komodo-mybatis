package com.komodo.mybatis.executor;

import com.komodo.mybatis.configuration.Configuration;
import com.komodo.mybatis.sql.BoundSql;
import com.komodo.mybatis.statement.MappedStatement;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author ZhangGJ
 * @Date 2021/04/14 22:47
 */
public class SimpleExecutor implements Executor{

    private Connection connection = null;


    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement,
            Object[] param) throws SQLException, NoSuchFieldException, IllegalAccessException,
            InstantiationException, InvocationTargetException, IntrospectionException {
        connection = configuration.getDataSource().getConnection();
        String sql = mappedStatement.getSql();
        BoundSql boundSql = getBoundSql(sql);
//        String finalSql = boundSql.getSqlText();
        Class<?> parameterType = mappedStatement.getParameterType();
//        PreparedStatement preparedStatement = connection.prepareStatement(finalSql);
//        List<ParameterMapping> parameterMappingList = boundSql.getParameterMappingList();
//        for (int i = 0; i < parameterMappingList.size(); i++) {
//            ParameterMapping parameterMapping = parameterMappingList.get(i);
//            String name = parameterMapping.getName();
//            Field field = parameterType.getDeclaredField(name);
//            field.setAccessible(true);
//            Object o = field.get(param[0]);
//            preparedStatement.setObject(i + 1, o);
//        }
//        ResultSet resultSet = preparedStatement.executeQuery();
//        Class<?> resultType = mappedStatement.getResultType();
//        List<E> results = new ArrayList<>();
//        while (resultSet.next()) {
//            ResultSetMetaData metaData = resultSet.getMetaData();
//            E o = (E) resultType.newInstance();
//            int columnCount = metaData.getColumnCount();
//            for (int i = 1; i <= columnCount; i++) {
//                String columnName = metaData.getColumnName(i);
//                Object value = resultSet.getObject(columnCount);
//                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnName, resultType);
//                Method method = propertyDescriptor.getWriteMethod();
//                method.invoke(o, value);
//            }
//            results.add(o);
//        }
//        return results;
        return null;
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }

    private BoundSql getBoundSql(String sql) {
//        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        return null;
    }
}
