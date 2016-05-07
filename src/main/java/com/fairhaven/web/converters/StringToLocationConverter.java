/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.converters;

// Import log4j class
import com.fairhaven.db.dao.DAOFactory;
import com.fairhaven.db.entities.Location;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sam
 */
@Component
public class StringToLocationConverter implements Converter<String, Location> {

    private static final Logger logger = Logger.getLogger(StringToLocationConverter.class.getName());

    @Resource
    private DAOFactory daof;

    @Override
    public Location convert(String source) {

        Location location;

        if (source != null) {
            location = daof.getLocationDAO().findById(Integer.parseInt(source), false);
        } else {
            throw new RuntimeException("Error converting " + source + " to a location");
        }

        return location;
    }

}
