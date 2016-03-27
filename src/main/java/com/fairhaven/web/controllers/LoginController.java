/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.controllers;

// Import log4j class
import com.fairhaven.web.forms.LoginFormBackingBean;
import java.util.Locale;
import javax.servlet.ServletException;
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

    /**
     *
     * @param error Error parameter from the login function if the page is
     * redirected due to a problem while logging in e.g. wrong credentials
     * @param locale The local the error message needs to be displayed in, auto
     * injected by Spring
     * @return Returns a model and view of the login page with localized error
     * messages included in the model if present
     */
    @RequestMapping(path = "/login.htm", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(name = "error", required = false) String error, Locale locale) {
        ModelAndView mav = new ModelAndView("com.fairhaven.memebers.login");
        LoginFormBackingBean login = new LoginFormBackingBean();
        login.setCookie(true);
        mav.addObject("login", login);

        //Add error message if it exists
        if (error != null) {
            mav.addObject("error", "There was a problem signing in, please enter your username and password again");
        }
        return mav;
    }

    /**
     *
     * @param request The {@link HttpServletRequest} object injected by Spring
     * @param response {@link HttpServletRequest} object injected by Spring
     * @param model Map of request attributes to be presented to the view
     * @return Returns a model and view of the login page if the logout was
     * successful
     * @throws ServletException {@link ServletException} that may occur during
     * HttpServletRequest's <code>request.logout()</code> request call
     */
    @RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request,
            HttpServletResponse response,
            RedirectAttributes model) throws ServletException {
        request.logout();
<<<<<<< HEAD
        return new ModelAndView("redirect:/members/profile.htm");
=======
        rememberMeCookie.setMaxAge(0);
        response.addCookie(rememberMeCookie);
        return new ModelAndView("redirect:/members/");
>>>>>>> login
    }
}
