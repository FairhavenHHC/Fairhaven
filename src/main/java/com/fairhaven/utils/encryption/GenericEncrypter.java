/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.utils.encryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.log4j.Logger;

/**
 *
 * @author XUG590
 */
public class GenericEncrypter implements Encrypter {

    private static final Logger logger = Logger.getLogger(GenericEncrypter.class.getName());

    /**
     *
     */
    protected final Algorithm ALGORITHM;

    /**
     *
     */
    protected final Encoding ENCODING;

    /**
     *
     */
    public GenericEncrypter() {
        this.ALGORITHM = Algorithm.MD5;
        this.ENCODING = Encoding.UTF8;
    }

    /**
     *
     * @param algorithm
     * @param encoding
     */
    public GenericEncrypter(Algorithm algorithm, Encoding encoding) {
        if (encoding != null && algorithm != null) {
            this.ALGORITHM = algorithm;
            this.ENCODING = encoding;
        } else {
            throw new IllegalArgumentException("Null parameters are not allowed. All parameters (Algorithm, Encoding and the String to encrypt) are required");
        }
    }

    /**
     *
     * @param stringToEncrypt
     * @return
     * @throws Exception
     */
    @Override
    public String encryptString(String stringToEncrypt) throws Exception {
        return this.encryptString(stringToEncrypt, ALGORITHM, ENCODING);
    }

    /**
     *
     * @param stringToEncrypt
     * @param encryptionAlgorithm
     * @return
     * @throws Exception
     */
    @Override
    public String encryptString(String stringToEncrypt, Algorithm encryptionAlgorithm) throws Exception {
        return this.encryptString(stringToEncrypt, encryptionAlgorithm, ENCODING);
    }

    /**
     *
     * @param stringToEncrypt
     * @param encryptionAlgorithm
     * @param encoding
     * @return
     * @throws Exception
     */
    @Override
    public String encryptString(String stringToEncrypt, Algorithm encryptionAlgorithm, Encoding encoding) throws Exception {
        if (encryptionAlgorithm != null && encoding != null && stringToEncrypt != null && !stringToEncrypt.isEmpty()) {
            String encodedPassword = "";

            MessageDigest md = encryptionAlgorithm.getMessageDigester();
            md.update(stringToEncrypt.getBytes(encoding.getEncoding()));
            encodedPassword = bytesToHex(md.digest());
            return encodedPassword;
        } else {
            throw new IllegalArgumentException("Null parameters are not allowed. All parameters (Algorithm, Encoding and the String to encrypt) are required");
        }
    }

    private String bytesToHex(byte[] bytes) {

        StringBuilder result = new StringBuilder();

        for (byte byt : bytes) {
            result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

}
