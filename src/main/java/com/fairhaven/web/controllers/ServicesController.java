/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.controllers;

// Import log4j class
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sam
 */
@Controller
@RequestMapping("/services")
public class ServicesController {

    private static final Logger logger = Logger.getLogger(ServicesController.class.getName());

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView servicesIndex() {
        ModelAndView mav = new ModelAndView("com.fairhaven.services");
        return mav;
    }
    
<<<<<<< HEAD
    /**
     *
     * @return
     */
    @RequestMapping(path = "/services.htm", method = RequestMethod.GET)
    public ModelAndView news(){
        return new ModelAndView("com.fairhaven.services");
=======
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView servicesIndex(@PathVariable("id") Integer id) {
        ModelAndView mav = new ModelAndView("com.fairhaven.services");
        return mav;
>>>>>>> login
    }

}
