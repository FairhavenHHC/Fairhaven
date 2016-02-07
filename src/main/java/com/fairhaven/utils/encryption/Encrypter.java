/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fairhaven.utils.encryption;

/**
 *
 * @author XUG590
 */
public interface Encrypter{
    
    /**
     *
     * @param stringToEncrypt
     * @return
     * @throws Exception
     */
    public String encryptString(String stringToEncrypt) throws Exception;

    /**
     *
     * @param stringToEncrypt
     * @param encryptionAlgorithm
     * @return
     * @throws Exception
     */
    public String encryptString(String stringToEncrypt, Algorithm encryptionAlgorithm)throws Exception;

    /**
     *
     * @param stringToEncrypt
     * @param encryptionAlgorithm
     * @param encoding
     * @return
     * @throws Exception
     */
    public String encryptString(String stringToEncrypt, Algorithm encryptionAlgorithm, Encoding encoding)throws Exception;
    
}
