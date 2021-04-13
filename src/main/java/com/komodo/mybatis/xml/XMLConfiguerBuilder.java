package com.komodo.mybatis.xml;

import com.komodo.community.enums.DatasourceEnum;
import com.komodo.community.pojo.connection.ConnectionInfo;
import com.komodo.community.utils.YamlUtil;
import com.komodo.mybatis.configuration.Configuration;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @Author ZhangGJ
 * @Date 2021/04/13 23:14
 */
public class XMLConfiguerBuilder {

    private Configuration configuration;

    public XMLConfiguerBuilder(Configuration configuration) {
        this.configuration = new Configuration();
    }

    public Configuration parseConfiguration(InputStream inputStream)
            throws DocumentException, PropertyVetoException {
//        Document document = new SAXReader().read(inputStream);
//        Element rootElement = document.getRootElement();
//        List<Element> propertyElements = rootElement.selectNodes("//property");
//        Properties properties = new Properties();
//        for (Element propertyElement : propertyElements) {
//            String name = propertyElement.attributeValue("name");
//            String value = propertyElement.attributeValue("value");
//            properties.setProperty(name, value);
//        }
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        ConnectionInfo connectionInfo =
                YamlUtil.readYaml("config-database.yml", DatasourceEnum.MYSQL.name(),
                        ConnectionInfo.class);
        comboPooledDataSource.setDriverClass(connectionInfo.getDriver());
        comboPooledDataSource.setJdbcUrl(connectionInfo.getUrl());
        comboPooledDataSource.setUser(connectionInfo.getUsername());
        comboPooledDataSource.setPassword(connectionInfo.getPassword());
        configuration.setDataSource(comboPooledDataSource);

        return null;
    }
}
