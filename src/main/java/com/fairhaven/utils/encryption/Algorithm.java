/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.utils.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author XUG590
 */
public enum Algorithm {

    SHA1("SHA-1"),
    SHA2("SHA-256"),
    MD5("MD5");

    private final MessageDigest algorithm;

    private Algorithm(String algorithm) throws ExceptionInInitializerError {
        try {
            this.algorithm = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public MessageDigest getMessageDigester(){
        return this.algorithm;
    }

}
