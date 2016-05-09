/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.utils.mail;

// Import log4j class
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 *
 * @author Sam
 */
public class VelocityEmailTemplate extends GenericEmailTemplate {

    private static final Logger logger = Logger.getLogger(VelocityEmailTemplate.class.getName());

    private final VelocityEngine velocityEngine;
    private final String encoding, templateLocation;

    /**
     *
     */
    public VelocityEmailTemplate(VelocityEngine velocityEngine, String templateLocation, String encoding) {
        super();
        this.encoding = encoding;
        this.templateLocation = templateLocation;
        this.velocityEngine = velocityEngine;
    }

    @Override
    public String getMessage() {
        return VelocityEngineUtils
                .mergeTemplateIntoString(velocityEngine,
                        this.templateLocation,
                        this.encoding,
                        this.getModel());
    }
}
