/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.converters;

// Import log4j class
import com.fairhaven.db.dao.DAOFactory;
import com.fairhaven.db.entities.Services;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sam
 */
@Component
public class StringToServiceConverter implements Converter<String, Services> {

    @Resource
    private DAOFactory daof;

    private static final Logger logger = Logger.getLogger(StringToServiceConverter.class.getName());

    @Override
    public Services convert(String serviceId) {
        logger.info("Convertrting " + serviceId + " to a Services object...");
        
        Services service;
        
        if(serviceId != null){
             service = daof.getServicesDAO().findById(Integer.parseInt(serviceId), true);
        }else{
            throw new NullPointerException("The service id cannot be null");
        }
        
        return service;
    }
}
