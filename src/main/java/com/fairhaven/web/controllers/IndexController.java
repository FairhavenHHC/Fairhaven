/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.controllers;

// Import log4j class
import com.fairhaven.db.dao.DAOFactory;
import java.util.Locale;
import javax.annotation.Resource;
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
public class IndexController {

    private static final Logger logger = Logger.getLogger(IndexController.class.getName());
    
    @Resource
    private DAOFactory daof;

    /**
     *
     * @param locale
     * @param request
     * @return
     */
    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public ModelAndView index(Locale locale, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("com.fairhaven.index");
        mav.addObject("services", daof.getServicesDAO().findAll());
        return mav;
    }

}
