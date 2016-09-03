/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.controllers;

// Import log4j class
import com.fairhaven.db.dao.DAOFactory;
import javax.annotation.Resource;
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
@RequestMapping("/about")
public class AboutController {

    private static final Logger logger = Logger.getLogger(AboutController.class.getName());

    @Resource
    private DAOFactory daof;

    /**
     *
     * @return
     */
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView about() {
        ModelAndView mav = new ModelAndView("com.fairhaven.about");
        mav.addObject("locations", daof.getLocationDAO().findAll());
        return mav;
    }

    /**
     *
     * @return
     */
    @RequestMapping(path = "/careers/", method = RequestMethod.GET)
    public ModelAndView careers() {
        ModelAndView mav = new ModelAndView("com.fairhaven.about.careers");
        return mav;
    }

}
