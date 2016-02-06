/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.controllers;

// Import log4j class
import com.fairhaven.web.forms.LoginFormBackingBean;
import java.util.Locale;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Sam
 */
@Controller
public class LoginController {

    private static final Logger logger = Logger.getLogger(LoginController.class.getName());

    @RequestMapping(path = "/login.htm", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(name = "error", required = false) String error, Locale locale) {
        ModelAndView mav = new ModelAndView("com.fairhaven.admin.login");
        LoginFormBackingBean login = new LoginFormBackingBean();
        login.setCookie(true);
        mav.addObject("login", login);

        //Add error message if it exists
        if (error != null) {
            mav.addObject("error", "There was a problem signing in, please enter your username and password again");
        }
        return mav;
    }

    @RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request,
            HttpServletResponse response,
            RedirectAttributes model) throws Exception {
        Cookie rememberMeCookie = new Cookie("remember-me-token", null);
        request.logout();
        rememberMeCookie.setMaxAge(0);
        response.addCookie(rememberMeCookie);
        return new ModelAndView("redirect:/admin.htm");
    }
}
