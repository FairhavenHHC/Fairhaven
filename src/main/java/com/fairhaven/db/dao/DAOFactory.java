/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.db.dao;

/**
 *
 * @author Sam
 */
public interface DAOFactory {

    /**
     *
     * @return
     */
    public UsersDAO getUsersDAO();

    /**
     *
     * @return
     */
    public GroupsDAO getGroupsDAO();

    /**
     *
     * @return
     */
    public ServicesDAO getServicesDAO();

    /**
     *
     * @return
     */
    public FaqDAO getFaqDAO();

    /**
     *
     * @return
     */
    public ContactDAO getContactDAO();

    /**
     *
     * @return
     */
    public ContactTypeDAO getContactTypeDAO();

    /**
     *
     * @return
     */
    public LocationDAO getLocationDAO();
}
