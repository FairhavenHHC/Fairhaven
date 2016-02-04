/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.controllers;

// Import log4j class
import com.fairhaven.web.forms.LoginFormBackingBean;
import java.util.Locale;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sam
 */
@Controller
public class LoginController {

    private static final Logger logger = Logger.getLogger(LoginController.class.getName());
    
    @Resource
    private MessageSource messageSource;

    @RequestMapping(path = "/login.htm", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(name = "error", required=false)String error, Locale locale) {
        ModelAndView mav = new ModelAndView("com.fairhaven.admin.login");
        LoginFormBackingBean login = new LoginFormBackingBean();
        mav.addObject("login", login);
        return mav;
    }

}
