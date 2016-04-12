/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.db.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Sam
 * @param <T> DB object type being accessed
 * @param <ID> DB object ID type
 */
public interface GenericDAO<T, ID extends Serializable> {

    /**
     *
     * @param id
     * @param lock
     * @return
     */
    public T findById(ID id, boolean lock);

    /**
     *
     * @return
     */
    public List<T> findAll();

    /**
     *
     * @param pageSize
     * @param firstResult
     * @return
     */
    public List<T> findAll(int pageSize, int firstResult);

    /**
     *
     * @param exampleInstance
     * @return
     */
    public List<T> findByExample(T exampleInstance);

    /**
     *
     * @param entity
     * @return
     */
    public T saveOrUpdate(T entity);

    /**
     *
     * @param entity
     */
    public void delete(T entity);

    /**
     *
     * @param entities
     * @return
     */
    public Collection<T> deleteAll(Collection<T> entities);

    /**
     *
     * @param entities
     * @return
     */
    public Collection<T> updateAll(Collection<T> entities);

    /**
     *
     * @return
     */
    public int count();

    /**
     *
     * @param search_string
     * @param fields
     * @return
     */
    public Collection<T> search(String search_string, String... fields);

}
