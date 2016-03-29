/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fairhaven.db.dao.hibernate;



// Import log4j class
import com.fairhaven.db.dao.DAOFactory;
import com.fairhaven.db.dao.FaqDAO;
import com.fairhaven.db.dao.GroupsDAO;
import com.fairhaven.db.dao.ServicesDAO;
import com.fairhaven.db.dao.UsersDAO;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sam
 */

@Component
public class HibernateDAOFactory implements DAOFactory {

    private static final Logger logger = Logger.getLogger(HibernateDAOFactory.class.getName());
    
    @Resource
    private ServicesDAO serviceDAO;
    @Resource
    private GroupsDAO groupsDAO;
    @Resource
    private UsersDAO usersDAO;
    @Resource
    private FaqDAO faqDAO;

    @Override
    public UsersDAO getUsersDAO() {
        return this.usersDAO;
    }

    @Override
    public GroupsDAO getGroupsDAO() {
       return this.groupsDAO;
    }

    @Override
    public ServicesDAO getServicesDAO() {
        return this.serviceDAO;
    }

    @Override
    public FaqDAO getFaqDAO() {
        return faqDAO;
    }

}
