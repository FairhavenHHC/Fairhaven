/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fairhaven.web.converters;



// Import log4j class
import com.fairhaven.db.entities.Services;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sam
 */

@Component
public class ServiceToStringConverter implements Converter<Services, String>{

    private static final Logger logger = Logger.getLogger(ServiceToStringConverter.class.getName());

    /**
     *
     * @param service
     * @return
     */
    @Override
    public String convert(Services service) {
        
        String result = "";
        
        if(service != null){
           result =  Integer.toString(service.getId());
        }
        
        return result;
    }

}
