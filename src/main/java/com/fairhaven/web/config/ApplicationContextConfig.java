/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.config;

// Import log4j class
import java.util.Properties;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Sam
 */
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.fairhaven"}, excludeFilters = @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION))
@Configuration
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = false)
public class ApplicationContextConfig {

    private static final Logger logger = Logger.getLogger(ApplicationContextConfig.class.getName());

    @Resource
    private Environment env;

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        datasource.setUrl(env.getProperty("jdbc.url"));
        datasource.setUsername(env.getProperty("jdbc.username"));
        datasource.setPassword(env.getProperty("jdbc.password"));
        return datasource;
    }

    @Bean(name = "sessionFactory")
    @Autowired
    public LocalSessionFactoryBean sessionFactory(DataSource datasource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(datasource);
        sessionFactory.setPackagesToScan(new String[]{"com.fairhaven.db.entities"});
        sessionFactory.setHibernateProperties(new Properties() {
            {
                setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
                setProperty("hibernate.c3p0.min_size", env.getProperty("hibernate.c3p0.min_size"));
                setProperty("hibernate.c3p0.max_size", env.getProperty("hibernate.c3p0.max_size"));
                setProperty("hibernate.c3p0.timeout", env.getProperty("hibernate.c3p0.timeout"));
                setProperty("hibernate.c3p0.max_statements", env.getProperty("hibernate.c3p0.max_statements"));
                setProperty("hibernate.c3p0.idle_test_period", env.getProperty("hibernate.c3p0.idle_test_period"));
                setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
                setProperty("hibernate.connection.autocommit", env.getProperty("hibernate.connection.autocommit"));
                setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
                setProperty("hibernate.flushmode", env.getProperty("hibernate.flushmode"));
            }
        });

        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
