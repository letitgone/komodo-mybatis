package com.komodo.mybatis.xml;

import com.komodo.community.enums.DatasourceEnum;
import com.komodo.community.pojo.connection.ConnectionInfo;
import com.komodo.community.utils.YamlUtil;
import com.komodo.mybatis.configuration.Configuration;
import com.komodo.mybatis.io.Resources;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;

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
        connectionPool();
        parseXml(inputStream);
        return configuration;
    }

    private void connectionPool() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        ConnectionInfo connectionInfo =
                YamlUtil.readYaml("config-database.yml", DatasourceEnum.MYSQL.name(),
                        ConnectionInfo.class);
        comboPooledDataSource.setDriverClass(connectionInfo.getDriver());
        comboPooledDataSource.setJdbcUrl(connectionInfo.getUrl());
        comboPooledDataSource.setUser(connectionInfo.getUsername());
        comboPooledDataSource.setPassword(connectionInfo.getPassword());
        configuration.setDataSource(comboPooledDataSource);
    }

    private void parseXml(InputStream inputStream) throws DocumentException {
        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();
        List<Element> mapperElements = rootElement.selectNodes("//mapper");
        XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(configuration);
        for (Element mapperElement : mapperElements) {
            String mapperPath = mapperElement.attributeValue("resource");
            InputStream resourceAsStream = Resources.getResourceAsStream(mapperPath);
            xmlMapperBuilder.parse(resourceAsStream);
        }
    }
}
