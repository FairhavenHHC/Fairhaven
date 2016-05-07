/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.db.dao.hibernate;

// Import log4j class
import com.fairhaven.db.dao.AppointmentDAO;
import com.fairhaven.db.entities.Appointment;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sam
 */
@Repository
public class HibernateAppointmentDAO extends GenericHibernateDAO<Appointment, Integer>
        implements AppointmentDAO {

    private static final Logger logger = Logger.getLogger(HibernateAppointmentDAO.class.getName());

}
