/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.db.dao.hibernate;

// Import log4j class
import com.fairhaven.db.dao.ServicesDAO;
import com.fairhaven.db.entities.Services;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sam
 */
@Repository
public class HibernateServicesDAO extends GenericHibernateDAO<Services, Integer>
        implements ServicesDAO {

    private final int MAX_RESULTS_SIZE = 1000;

    private static final Logger logger = Logger.getLogger(HibernateServicesDAO.class.getName());

    @Override
    public List<Services> findAll() {
        Criteria criteria = this.getCurrentSession().createCriteria(Services.class, "service");
        criteria.addOrder(Order.asc("service.id"));
        return criteria.list();
    }

}
