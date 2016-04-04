/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.db.dao.hibernate;

import com.fairhaven.db.dao.GenericDAO;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sam
 * @param <T>
 * @param <ID>
 */
@Repository
public class GenericHibernateDAO<T, ID extends Serializable>
        implements GenericDAO<T, ID> {

    private Class<T> persistentClass;
    private final int BATCH_SIZE = 20;
    private final int RESULT_SIZE_MAX = 10000;

    @Resource
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(GenericHibernateDAO.class.getName());

    /**
     *
     */
    public GenericHibernateDAO() {
    }

    /**
     *
     * @return
     */
    public Session getCurrentSession() {
        return this.getSessionFactory().getCurrentSession();
    }

    /**
     *
     * @return
     */
    public Class<T> getPersistentClass() {
        if (this.persistentClass == null) {
            this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return persistentClass;
    }

    /**
     *
     * @param id
     * @param lock
     * @return
     */
    @Transactional
    @Override
    public T findById(ID id, boolean lock) {
        T entity;
        Session s = this.getCurrentSession();
        if (lock) {
            entity = (T) s.get(getPersistentClass(), id, LockMode.UPGRADE);
        } else {
            entity = (T) s.get(getPersistentClass(), id);
        }
        return entity;
    }

    /**
     *
     * @return
     */
    @Override
    @Transactional
    public List<T> findAll() {
        return findByCriteria(0, RESULT_SIZE_MAX);
    }

    /**
     *
     * @param firstResult
     * @param pageSize
     * @return
     */
    @Override
    @Transactional
    public List<T> findAll(int firstResult, int pageSize) {
        return findByCriteria(firstResult, pageSize);
    }

    /**
     *
     * @param exampleInstance
     * @param excludeProperty
     * @return
     */
    @Transactional
    public List<T> findByExample(T exampleInstance, String... excludeProperty) {
        Session s = this.getCurrentSession();
        Criteria criteria = s.createCriteria(getPersistentClass());
        Example example = Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        criteria.add(example);
        return criteria.list();
    }

    /**
     *
     * @param exampleInstance
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<T> findByExample(T exampleInstance) {

        return this.findByExample(exampleInstance, new String[0]);
    }

    /**
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional
    public T saveOrUpdate(T entity) {
        logger.info("Saving entity...");
        Session s = this.getCurrentSession();
        s.saveOrUpdate(entity);
        s.flush();

        return entity;
    }

    /**
     *
     * @param entities
     * @return
     */
    @Override
    @Transactional
    public Collection<T> updateAll(Collection<T> entities) {
        logger.info("Updating entities...");
        Session s = this.getCurrentSession();

        int i = 1;
        for (T entity : entities) {
            logger.info("Saving object " + i + " of " + entities.size());
            s.saveOrUpdate(entity);
            if (i % this.BATCH_SIZE == 0 || i == entities.size()) {
                s.flush();
                s.clear();
                logger.info("Clearing and flushing session...");
            }
            i++;
        }

        return entities;

    }

    /**
     *
     * @param entity
     */
    @Override
    @Transactional
    public void delete(T entity) {
        Session s = this.getCurrentSession();
        s.delete(entity);
        s.flush();

    }

    /**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     *
     * @param entities
     * @return
     */
    @Override
    @Transactional
    public Collection<T> deleteAll(Collection<T> entities) {
        Session s = this.getCurrentSession();

        int i = 1;
        for (T entity : entities) {
            logger.info("Deleting entities...");
            logger.info("Deleting object " + i + " of " + entities.size());
            s.delete(entity);
            if (i % this.BATCH_SIZE == 0 || i == entities.size()) {
                s.flush();
                s.clear();
                logger.info("Clearing and flushing session...");
            }
            i++;
        }
        return entities;
    }

    /**
     *
     * @return
     */
    @Override
    @Transactional
    public int count() {
        return this.count(this.getCurrentSession()
                .createCriteria(this.getPersistentClass()));
    }

    /**
     *
     * @param criteria
     * @return
     */
    @Transactional
    protected int count(Criteria criteria) {
        return ((Long) criteria
                .setProjection(Projections.rowCount()).uniqueResult()).intValue();
    }

    /**
     * Use this inside subclasses as a convenience method.
     *
     * @param firstResult
     * @param pageSize
     * @param criterion
     * @return
     */
    @Transactional
    protected List<T> findByCriteria(int firstResult, int pageSize, Criterion... criterion) {
        Session s = this.getCurrentSession();
        Criteria criteria = s.createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            criteria.add(c);
        }
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(pageSize);
        return criteria.list();
    }
}
