/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.config;

// Import log4j class
import com.fairhaven.utils.mail.GenericEmailTemplate;
import com.fairhaven.utils.mail.VelocityEmailTemplate;
import java.io.IOException;
import java.util.Properties;
import javax.annotation.Resource;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

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

    /**
     *
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        datasource.setUrl(env.getProperty("jdbc.url"));
        datasource.setUsername(env.getProperty("jdbc.username"));
        datasource.setPassword(env.getProperty("jdbc.password"));
        return datasource;
    }

    /**
     *
     * @param datasource
     * @return
     */
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
                setProperty("hibernate.search.default.directory_provider", "filesystem");
                setProperty("hibernate.search.default.indexBase", "/tmp/lucene/indexes");
            }
        });

        return sessionFactory;
    }

    /**
     *
     * @param sessionFactory
     * @return
     */
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

    /**
     *
     * @return
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /**
     *
     * @return
     */
    @Bean
    public JavaMailSenderImpl mailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("mail.host"));
        mailSender.setPort(env.getProperty("mail.port", Integer.class));
        mailSender.setUsername(env.getProperty("mail.username"));
        mailSender.setPassword(env.getProperty("mail.password"));

        Properties javaMailProperties = new Properties();
        javaMailProperties.setProperty("mail.smtp.auth", env.getProperty("mail.java.smtp.auth"));
        javaMailProperties.setProperty("mail.smtp.starttls.enable", env.getProperty("mail.java.smtp.starttls.enable"));

        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }

    /**
     *
     * @return @throws VelocityException
     * @throws IOException
     */
    @Bean
    public VelocityEngine getVelocityEngine() throws VelocityException, IOException {

        //Testing Jenkins 1
        VelocityEngineFactoryBean engine = new VelocityEngineFactoryBean();
        Properties velocityProperties = new Properties();
        velocityProperties.setProperty("resource.loader", "class");
        velocityProperties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        engine.setVelocityProperties(velocityProperties);

        return engine.createVelocityEngine();
    }

    @Bean(name = "message_velocity_email_template")
    public GenericEmailTemplate getMessageEmailTemplate() throws AddressException, VelocityException, IOException {
        GenericEmailTemplate template = new VelocityEmailTemplate(this.getVelocityEngine(), env.getProperty("mail.velocity.template.question"),
                env.getProperty("mail.velocity.encoding"));
        template.addTo(new InternetAddress(env.getProperty("mail.message.email")));
        return template;
    }

    @Bean(name = "appointment_velocity_email_template")
    public GenericEmailTemplate getAppointmentEmailTemplate() throws AddressException, VelocityException, IOException {
        GenericEmailTemplate template = new VelocityEmailTemplate(this.getVelocityEngine(), env.getProperty("mail.velocity.template.appointment"),
                env.getProperty("mail.velocity.encoding"));
        template.setFrom(new InternetAddress(env.getProperty("mail.appointment.email")));
        return template;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
