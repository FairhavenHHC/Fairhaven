/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.utils.mail;

// Import log4j class
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import org.apache.log4j.Logger;

/**
 *
 * @author Sam
 */
public class GenericEmailTemplate {

    private static final Logger logger = Logger.getLogger(GenericEmailTemplate.class.getName());

    private String subject;
    private InternetAddress from;
    private Collection<File> attachments;
    private Collection<InternetAddress> to;
    private Collection<InternetAddress> bcc;
    private String message;
    private HashMap<String, Object> model;

    /**
     *
     */
    public GenericEmailTemplate() {
        this.to = new ArrayList<>();
        this.attachments = new ArrayList<>();
        this.bcc = new ArrayList<>();
        this.model = new HashMap<>();
    }

    /**
     *
     * @param toAddress
     */
    public void addTo(InternetAddress toAddress) {
        this.getTo().add(toAddress);
    }

    /**
     *
     * @param toAddress
     * @throws AddressException
     */
    public void addTo(String toAddress) throws AddressException {
        this.getTo().add(new InternetAddress(toAddress));
    }

    /**
     *
     * @param bccAddress
     */
    public void addBcc(InternetAddress bccAddress) {
        this.getBcc().add(bccAddress);
    }

    /**
     *
     * @param bccAddress
     * @throws AddressException
     */
    public void addBcc(String bccAddress) throws AddressException {
        this.getBcc().add(new InternetAddress(bccAddress));
    }

    /**
     *
     * @param attachment
     * @param attachmentName
     */
    public void addAttachment(File attachment, String attachmentName) {
        this.getAttachments().add(attachment);
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @return the from
     */
    public InternetAddress getFrom() {
        return from;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(InternetAddress from) {
        this.from = from;
    }

    /**
     * @return the attachments
     */
    public Collection<File> getAttachments() {
        return attachments;
    }

    /**
     * @param attachments the attachments to set
     */
    public void setAttachments(Collection<File> attachments) {
        this.attachments = attachments;
    }

    /**
     * @return the to
     */
    public Collection<InternetAddress> getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(Collection<InternetAddress> to) {
        this.to = to;
    }

    /**
     * @return the bcc
     */
    public Collection<InternetAddress> getBcc() {
        return bcc;
    }

    /**
     * @param bcc the bcc to set
     */
    public void setBcc(Collection<InternetAddress> bcc) {
        this.bcc = bcc;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the model
     */
    public HashMap<String, Object> getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(HashMap<String, Object> model) {
        this.model = model;
    }
}
