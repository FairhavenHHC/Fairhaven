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

<<<<<<< HEAD:src/main/java/com/fairhaven/web/controllers/ErrorController.java
    @RequestMapping(value = "/error.htm", method = RequestMethod.GET)
    public ModelAndView handleError(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("com.fairhaven.404");
        return mav;
=======
    private static final Logger logger = Logger.getLogger(NewsController.class.getName());
    
<<<<<<< HEAD
    /**
     *
     * @return
     */
    @RequestMapping(path = "/news.htm", method = RequestMethod.GET)
=======
    @RequestMapping(path = "/", method = RequestMethod.GET)
>>>>>>> login
    public ModelAndView news(){
        return new ModelAndView("com.fairhaven.news");
>>>>>>> c4c55a6de9ef3c9716c8d750a5b4d5d57a1445b2:src/main/java/com/fairhaven/web/controllers/NewsController.java
    }

}
