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

    public T findById(ID id, boolean lock);

    public List<T> findAll();

    public List<T> findAll(int pageSize, int firstResult);

    public List<T> findByExample(T exampleInstance);

    public T saveOrUpdate(T entity);

    public void delete(T entity);

    public Collection<T> deleteAll(Collection<T> entities);

    public Collection<T> updateAll(Collection<T> entities);

    public int count();

}
