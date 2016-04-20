/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.controllers;

// Import log4j class
import com.fairhaven.db.dao.DAOFactory;
import com.fairhaven.db.entities.Contact;
import com.fairhaven.db.entities.Services;
import com.fairhaven.utils.mail.GenericEmailTemplate;
import com.fairhaven.utils.mail.Mailer;
import com.fairhaven.web.forms.MessageFormbackingBean;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    @Resource
    private Mailer mailer;
    @Resource
    private GenericEmailTemplate velocityEmailTemplate;
    @Resource
    private Environment env;

    /**
     *
     * @return
     */
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView servicesIndex() {
        ModelAndView mav = new ModelAndView("com.fairhaven.services");

        MessageFormbackingBean newQuestion = new MessageFormbackingBean();
        newQuestion.setNewsletter(true);
        Map<String, Contact> contacts = new HashMap<>();
        for (Contact contact : this.daof.getContactDAO().findAll()) {
            contacts.put(contact.getType().getName(), contact);
        }
        mav.addObject("contacts", contacts);
        mav.addObject("question", newQuestion);
        mav.addObject("faqs", this.daof.getFaqDAO().findAll());
        mav.addObject("services", this.daof.getServicesDAO().findAll());
        return mav;
    }

    /**
     *
     * @param question
     * @param validationResults
     * @return
     * @throws java.lang.Exception
     */
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ModelAndView sendMessage(@ModelAttribute("question") @Valid MessageFormbackingBean question, BindingResult validationResults) throws Exception {

        ModelAndView mav;

        if (!validationResults.hasErrors()) {
            velocityEmailTemplate.setFrom(new InternetAddress(question.getEmail()));
            velocityEmailTemplate.addTo(new InternetAddress(env.getProperty("mail.username")));
            velocityEmailTemplate.setSubject("This is just a test email");
            velocityEmailTemplate.getModel().put("user", question);
            mailer.sendMail(velocityEmailTemplate, true);
            mav = this.servicesIndex();
            mav.addObject("email_scuccess", true);
        } else {
            mav = this.servicesIndex();
            mav.addObject("question", question);
        }
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
