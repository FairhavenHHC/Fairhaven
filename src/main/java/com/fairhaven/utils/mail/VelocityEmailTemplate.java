/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.utils.mail;

// Import log4j class
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 *
 * @author Sam
 */
@Component
public class VelocityEmailTemplate extends GenericEmailTemplate {

    private static final Logger logger = Logger.getLogger(VelocityEmailTemplate.class.getName());

    @Resource
    private VelocityEngine velocityEngine;
    @Resource
    private Environment env;

    /**
     *
     */
    public VelocityEmailTemplate() {
        super();
    }

    public String getMessage() {
        return VelocityEngineUtils
                .mergeTemplateIntoString(velocityEngine,
                        env.getProperty("mail.velocity.template.question"),
                        env.getProperty("mail.velocity.encoding"),
                        this.getModel());
    }
}
