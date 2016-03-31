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
    
    public UsersDAO getUsersDAO();
    public GroupsDAO getGroupsDAO();
    public ServicesDAO getServicesDAO();
    public FaqDAO getFaqDAO();
    public ContactDAO getContactDAO();
    public ContactTypeDAO getContactTypeDAO();
    public LocationDAO getLocationDAO();
}