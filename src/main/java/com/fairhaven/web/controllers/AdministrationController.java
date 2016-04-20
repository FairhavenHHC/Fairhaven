<<<<<<< HEAD:src/main/java/com/fairhaven/web/controllers/AdministrationController.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.controllers;

// Import log4j class
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
@RequestMapping(path = "/administration")
public class AdministrationController {

    private static final Logger logger = Logger.getLogger(AdministrationController.class.getName());

    /**
     *
     * @return
     */
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView profile() {
        ModelAndView mav = new ModelAndView("com.fairhaven.admin.dashboard");
        return mav;
    }

}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.controllers;

// Import log4j class
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
@RequestMapping(path = "/members")
public class MembersController {

    private static final Logger logger = Logger.getLogger(MembersController.class.getName());

<<<<<<< HEAD
    /**
     *
     * @return
     */
    @RequestMapping(path = "/profile.htm", method = RequestMethod.GET)
=======
    @RequestMapping(path = "/", method = RequestMethod.GET)
>>>>>>> login
    public ModelAndView profile() {
        ModelAndView mav = new ModelAndView("com.fairhaven.memebers.profile");
        return mav;
    }

}
>>>>>>> 2bf9b035f0db61dbe80228b054532731c6f55b2d:src/main/java/com/fairhaven/web/controllers/MembersController.java
