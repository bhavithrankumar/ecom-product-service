package com.ecom.product.config;

import com.ecom.product.constant.CommonConstant;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@Slf4j
public class DataSourceConfig implements DataSourceInterface {

    @Value(CommonConstant.MYSQL_URL)
    private String url;
    @Value(CommonConstant.MYSQL_USERNAME)
    private String userName;
    @Value(CommonConstant.MYSQL_PASSWORD)
    private String password;
    @Value(CommonConstant.MYSQL_DRIVER)
    private String driverClass;

    @Bean
    @ConfigurationProperties(prefix = CommonConstant.MYSQL_DATASOURCE)
    public DataSource dataSource() {
        ComboPooledDataSource datasource = new ComboPooledDataSource();
        try {
            datasource.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        datasource.setJdbcUrl(url);
        datasource.setUser(userName);
        datasource.setPassword(password);
        datasource.setMinPoolSize(5);
        datasource.setMaxIdleTime(2000);
        datasource.setMaxPoolSize(20);
        datasource.setMaxStatements(2000);
        return datasource;
    }
}
