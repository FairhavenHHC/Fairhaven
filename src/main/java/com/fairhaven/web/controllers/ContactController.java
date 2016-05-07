/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.controllers;

// Import log4j class
import com.fairhaven.db.dao.DAOFactory;
import com.fairhaven.db.entities.Appointment;
import com.fairhaven.db.entities.Contact;
import com.fairhaven.db.entities.Location;
import com.fairhaven.utils.mail.GenericEmailTemplate;
import com.fairhaven.utils.mail.Mailer;
import com.fairhaven.web.forms.LocationZipFormbackingBean;
import com.fairhaven.web.forms.MessageFormbackingBean;
import java.util.Collection;
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
@RequestMapping(path = "/contact")
public class ContactController {

    private static final Logger logger = Logger.getLogger(ContactController.class.getName());

    @Resource
    private Mailer mailer;
    @Resource
    private GenericEmailTemplate velocityEmailTemplate;
    @Resource
    private Environment env;
    @Resource
    private DAOFactory daof;

    /**
     *
     * @return
     */
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView contactIndex() {
        Collection<Location> locations = this.daof.getLocationDAO().findAll();
        ModelAndView mav = new ModelAndView("com.fairhaven.contact");

        Map<String, Contact> contacts = new HashMap<>();
        Collection<Contact> contact_list = this.daof.getContactDAO().findAll();
        for (Contact contact : contact_list) {
            contacts.put(contact.getType().getName(), contact);
        }
        mav.addObject("contacts", contacts);

        MessageFormbackingBean newQuestion = new MessageFormbackingBean();
        newQuestion.setNewsletter(true);
        mav.addObject("locations", locations);
        mav.addObject("zipBean", new LocationZipFormbackingBean());
        mav.addObject("services", this.daof.getServicesDAO().findAll());
        mav.addObject("question", newQuestion);
        mav.addObject("appointment", new Appointment());
        return mav;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView contactIndex(@PathVariable("id") Location location) {
        return this.contactIndex();
    }

    @RequestMapping(path = "/zip", method = RequestMethod.POST)
    public ModelAndView findLocation(@ModelAttribute("zipBean") @Valid LocationZipFormbackingBean zipBean, BindingResult results) {

        ModelAndView mav;

        if (results.hasErrors()) {
            mav = this.contactIndex();
            mav.addObject("zipBean", zipBean);
        } else {
            mav = this.contactIndex();
            mav.addObject("locations", this.daof.getLocationDAO().search(zipBean.getZip(), "zip"));
            mav.addObject("search_results", true);
            mav.addObject("zipBean", zipBean);

        }

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
            mav = this.contactIndex();
            mav.addObject("email_scuccess", true);
        } else {
            mav = this.contactIndex();
            mav.addObject("question", question);
        }
        return mav;
    }

    @RequestMapping(path = "/appointment", method = RequestMethod.POST)
    public ModelAndView saveAppointment(@ModelAttribute("appointment") @Valid Appointment appointment, BindingResult validationResults) throws Exception {
        ModelAndView mav = this.contactIndex();

        if (validationResults.hasErrors()) {
            mav.addObject("appointment_success", false);
        } else {
            mav.addObject("saved_appointment", daof.getAppointmentDAO().saveOrUpdate(appointment));
            mav.addObject("appointment_success", true);
        }

        mav.addObject(appointment);
        return mav;
    }

}
