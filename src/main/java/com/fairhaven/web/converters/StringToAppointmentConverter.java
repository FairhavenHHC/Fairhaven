/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.converters;

// Import log4j class
import com.fairhaven.db.dao.DAOFactory;
import com.fairhaven.db.entities.Appointment;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sam
 */
@Component
public class StringToAppointmentConverter implements Converter<String, Appointment> {

    private static final Logger logger = Logger.getLogger(StringToAppointmentConverter.class.getName());

    @Resource
    private DAOFactory daof;

    @Override
    public Appointment convert(String source) {

        Appointment appointment = null;

        if (source != null) {
            appointment = this.daof.getAppointmentDAO().findById(Integer.parseInt(source), true);
        }

        return appointment;
    }

}
