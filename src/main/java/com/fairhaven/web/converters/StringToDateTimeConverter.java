/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.converters;

// Import log4j class
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sam
 */
@Component
public class StringToDateTimeConverter implements Converter<String, Date> {

    private static final Logger logger = LogManager.getLogger(StringToDateTimeConverter.class.getName());

    private String regex = "[0-2][0-3]:[0-5][0-9]";

    @Override
    public Date convert(String source) {
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(source);
            DateFormat format;

            if (matcher.matches()) {
                format = new SimpleDateFormat("HH:mm");
            } else {
                format = new SimpleDateFormat("dd MMMM, yyyy");
            }
            Date date = format.parse(source);
            return date;
        } catch (ParseException ex) {
            logger.error("Failed to convert " + source + " to Date object", ex);
            throw new RuntimeException("Failed to convert " + source + " to Date object", ex);
        }
    }

}
