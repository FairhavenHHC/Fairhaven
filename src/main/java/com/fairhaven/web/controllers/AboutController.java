/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.controllers;

// Import log4j class
import com.fairhaven.db.dao.DAOFactory;
import com.fairhaven.web.forms.MessageFormbackingBean;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
<<<<<<< HEAD

    @Resource
    private DAOFactory daof;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView about(MessageFormbackingBean message) {
        ModelAndView mav = new ModelAndView("com.fairhaven.about");
        if (message != null) {
            mav.addObject("message", message);
        } else {
            MessageFormbackingBean newMessage = new MessageFormbackingBean();
            newMessage.setNewsletter(true);
            mav.addObject("message", newMessage);
        }
        
        return mav;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ModelAndView about(@ModelAttribute("message") @Valid MessageFormbackingBean message, BindingResult validationResults) {
         ModelAndView mav = new ModelAndView("com.fairhaven.about");

        if (!validationResults.hasErrors()) {
            mav = this.about(null);
        }else{
            mav.addObject("message", message);
        }
        
        return mav;
=======
    
<<<<<<< HEAD
    /**
     *
     * @return
     */
    @RequestMapping(path = "/about.htm", method = RequestMethod.GET)
=======
    @RequestMapping(path = "/", method = RequestMethod.GET)
>>>>>>> login
    public ModelAndView news(){
        return new ModelAndView("com.fairhaven.about");
>>>>>>> c4c55a6de9ef3c9716c8d750a5b4d5d57a1445b2
    }

}
