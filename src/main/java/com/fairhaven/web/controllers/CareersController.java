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
@RequestMapping("/careers")
public class CareersController {

    private static final Logger logger = Logger.getLogger(CareersController.class.getName());

    @Resource
    private DAOFactory daof;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView careersIndex() {
        return new ModelAndView("com.fairhaven.careers.index");
    }

}
