/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.controllers;

// Import log4j class
import com.fairhaven.db.dao.DAOFactory;
import com.fairhaven.db.entities.Appointment;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
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
@RequestMapping(path = "/admin")
public class AdminController {

    private static final Logger logger = Logger.getLogger(AdminController.class.getName());

    @Resource
    private DAOFactory daof;

    /**
     *
     * @return
     */
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView profile() {
        ModelAndView mav = new ModelAndView("com.fairhaven.admin.dashboard");
        mav.addObject("appointments", this.daof.getAppointmentDAO().findAll());
        return mav;
    }

    @RequestMapping(path = "/appointments", method = RequestMethod.GET)
    public ModelAndView appointments() {
        ModelAndView mav = new ModelAndView("com.fairhaven.admin.appointments");
        mav.addObject("appointments", this.daof.getAppointmentDAO().findAll());
        return mav;
    }

    @RequestMapping(path = "/appointments/delete", method = RequestMethod.GET)
    public ModelAndView appointments(@RequestParam(name = "id", required = true) Appointment appointment) {
        this.daof.getAppointmentDAO().delete(appointment);
        ModelAndView mav = this.appointments();
        mav.addObject("delete_success", true);
        return mav;
    }

}
