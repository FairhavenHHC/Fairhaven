/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.config;

// Import log4j class
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 *
 * @author Sam
 */
@Configuration
@EnableWebSecurity
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = false)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource(name = "dataSource")
    private DataSource dataSource;
    @Resource
    private Environment env;
    @Resource(name = "md5PasswordEncoder")
    private Md5PasswordEncoder encoder;

    /**
     *
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .rolePrefix("ROLE_")
                .usersByUsernameQuery("select username, password, case enabled when 1 then 'true' ELSE 'false' END enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username =?");
        //.passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("ADMIN");
        http.formLogin()
                .loginProcessingUrl("/security_check")
                .failureUrl("/login.htm?error=wrong_credentials")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/login.htm")
                .defaultSuccessUrl("/index.htm");
        http.exceptionHandling()
                .accessDeniedPage("/login.htm?error=access_denied");
        http.rememberMe()
                .tokenValiditySeconds(1209600)
                .rememberMeParameter("cookie")
                .rememberMeCookieName("remember-me-token")
                .tokenRepository(persistentTokenRepository());
        http.logout()
                .logoutUrl("/logout.htm");
        http.csrf();

    }

    /**
     *
     * @return
     */
    @Bean(name = "bcryptEncoder")
    public BCryptPasswordEncoder getBcryptPasswordEncoder() {
        Integer strength = Integer.parseInt(env.getProperty("security.password.encryption_strength"));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
        return passwordEncoder;
    }

    /**
     *
     * @return
     */
    @Bean(name = "md5PasswordEncoder")
    public Md5PasswordEncoder getMd5PasswordEncoder() {
        Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
        return passwordEncoder;
    }

    /**
     *
     * @return
     */
    @Bean(name = "persistentTokenRepository")
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
        tokenRepositoryImpl.setDataSource(dataSource);
        return tokenRepositoryImpl;
    }
}
