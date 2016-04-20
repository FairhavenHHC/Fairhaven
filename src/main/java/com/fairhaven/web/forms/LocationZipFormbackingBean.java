/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.forms;

// Import log4j class
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Sam
 */
public class LocationZipFormbackingBean {

    private static final Logger logger = Logger.getLogger(LocationZipFormbackingBean.class.getName());

    @NotNull(message = "{form.location.zip.not_null}")
    @Length(min = 5, max = 10, message = "{form.location.zip.length}")
    @Pattern(regexp = "^\\d{5}(?:[-\\s]\\d{4})?$", message = "{form.location.zip.valid}")
    private String zip;

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

}
