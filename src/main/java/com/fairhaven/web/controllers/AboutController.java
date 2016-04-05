/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.controllers;

// Import log4j class
import com.fairhaven.db.dao.DAOFactory;
import com.fairhaven.db.entities.Contact;
import com.fairhaven.utils.mail.Mailer;
import com.fairhaven.web.forms.MessageFormbackingBean;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.core.env.Environment;
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

    @Resource
    private DAOFactory daof;
    @Resource
    private Mailer mailer;
    @Resource
    private Environment env;

    /**
     *
     * @param message
     * @return
     */
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

        Map<String, Contact> contacts = new HashMap<>();
        for (Contact contact : this.daof.getContactDAO().findAll()) {
            contacts.put(contact.getType().getName(), contact);
        }
        mav.addObject("contacts", contacts);
        mav.addObject("locations", daof.getLocationDAO().findAll());
        return mav;
    }

    /**
     *
     * @param message
     * @param validationResults
     * @return
     */
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ModelAndView about(@ModelAttribute("message") @Valid MessageFormbackingBean message, BindingResult validationResults) {
        ModelAndView mav = new ModelAndView("com.fairhaven.about");

        if (!validationResults.hasErrors()) {
            mailer.sendMail(message.getEmail(), env.getProperty("mail.username"), "Test message from application", message.getMessage());
            mav = this.about(null);
        } else {
            mav = this.about(message);
        }

        return mav;
    }

    @RequestMapping(path = "/careers/", method = RequestMethod.GET)
    public ModelAndView careers() {
        ModelAndView mav = new ModelAndView("com.fairhaven.about.careers");
        return mav;
    }

}
