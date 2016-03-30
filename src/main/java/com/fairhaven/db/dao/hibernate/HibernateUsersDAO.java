/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fairhaven.db.dao.hibernate;



// Import log4j class
import com.fairhaven.db.dao.UsersDAO;
import com.fairhaven.db.entities.Users;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sam
 */

@Repository
public class HibernateUsersDAO extends GenericHibernateDAO<Users,String>
implements UsersDAO{

    private static final Logger logger = Logger.getLogger(HibernateUsersDAO.class.getName());

}
