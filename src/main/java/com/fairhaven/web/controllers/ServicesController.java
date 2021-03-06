/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.controllers;

// Import log4j class
import com.fairhaven.db.dao.DAOFactory;
import com.fairhaven.db.entities.Services;
import javax.annotation.Resource;
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

    @Resource
    private DAOFactory daof;

    /**
     *
     * @return
     */
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView servicesIndex() {
        ModelAndView mav = new ModelAndView("com.fairhaven.services");

        mav.addObject("faqs", this.daof.getFaqDAO().findAll());
        return mav;
    }

    /**
     *
     * @param service
     * @return
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView service(@PathVariable("id") Services service) {
        ModelAndView mav = new ModelAndView("com.fairhaven.service");

        mav.addObject("service", service);
        return mav;
    }
}
