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
public enum Encoding {
    
    /**
     *
     */
    UTF8("UTF-8"),

    /**
     *
     */
    UTF16("UTF-16");

    private final String encoding;

    private Encoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     *
     * @return
     */
    public String getEncoding() {
        return this.encoding;
    }
}
