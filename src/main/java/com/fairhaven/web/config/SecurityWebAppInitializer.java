/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.config;

// Import log4j class
import org.apache.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
//import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 *
 * @author Sam
 */
@Order(2)
public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {

    private static final Logger logger = Logger.getLogger(SecurityWebAppInitializer.class.getName());

    @Override
    protected boolean enableHttpSessionEventPublisher() {
        return true;
    }
}
