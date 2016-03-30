/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fairhaven.web.exceptions;



// Import log4j class
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Sam
 */

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="The requested service doesn't exist")
public class ServiceNotFoundException extends RuntimeException{

    private static final Logger logger = Logger.getLogger(ServiceNotFoundException.class.getName());

}
