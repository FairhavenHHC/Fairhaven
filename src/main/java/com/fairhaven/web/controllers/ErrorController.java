/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.controllers;

// Import log4j class
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sam
 */
@Controller
public class ErrorController {

    private static final Logger logger = Logger.getLogger(ErrorController.class.getName());

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/error.htm", method = RequestMethod.GET)
    public ModelAndView handleError(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("com.fairhaven.404");
        return mav;
    }

}
