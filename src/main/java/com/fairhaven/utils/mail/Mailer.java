/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.utils.mail;

/**
 *
 * @author Sam
 * @param <T>
 */
public interface Mailer<T> {

    /**
     *
     * @param email
     * @param htmlText
     */
    public void sendMail(T email, boolean htmlText);
}
