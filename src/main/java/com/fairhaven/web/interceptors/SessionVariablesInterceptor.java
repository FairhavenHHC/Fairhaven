/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.interceptors;

// Import log4j class
import com.fairhaven.db.dao.DAOFactory;
import com.fairhaven.db.entities.Contact;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sam
 */
@Component
public class SessionVariablesInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(SessionVariablesInterceptor.class.getName());

    @Resource
    private DAOFactory daof;

    @Value("${application.name}")
    private String applicationName;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getSession().getAttribute("services") == null) {
            request.getSession().setAttribute("services", daof.getServicesDAO().findAll());
        }

        if (request.getSession().getAttribute("contacts") == null) {
            Map<String, Contact> contacts = new HashMap<>();
            Collection<Contact> contact_list = this.daof.getContactDAO().findAll();
            for (Contact contact : contact_list) {
                contacts.put(contact.getType().getName(), contact);
            }
            request.getSession().setAttribute("contacts", contacts);
        }

        if (request.getSession().getAttribute("application_name") == null) {
            request.getSession().setAttribute("application_name", applicationName);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
