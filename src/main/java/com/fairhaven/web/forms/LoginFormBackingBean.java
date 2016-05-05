/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.forms;

// Import log4j class
import org.apache.log4j.Logger;

/**
 *
 * @author Sam
 */
public class LoginFormBackingBean {

    private static final Logger logger = Logger.getLogger(LoginFormBackingBean.class.getName());

    private String username, password, csrf;
    private boolean cookie;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the rememberMe
     */
    public boolean isCookie() {
        return cookie;
    }

    /**
     * @param cookie
     */
    public void setCookie(boolean cookie) {
        this.cookie = cookie;
    }

    /**
     * @return the csrf
     */
    public String getCsrf() {
        return csrf;
    }

    /**
     * @param csrf the csrf to set
     */
    public void setCsrf(String csrf) {
        this.csrf = csrf;
    }

}
