/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fairhaven.db.dao.hibernate;



// Import log4j class
import com.fairhaven.db.dao.LocationDAO;
import com.fairhaven.db.entities.Location;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sam
 */

@Repository
public class HibernateLocationDAO extends GenericHibernateDAO<Location, Integer>
implements LocationDAO{

    private static final Logger logger = Logger.getLogger(HibernateLocationDAO.class.getName());

}
