/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.forms;

// Import log4j class
import com.fairhaven.db.entities.Services;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Sam
 */
public class MessageFormbackingBean {

    private static final Logger logger = Logger.getLogger(MessageFormbackingBean.class.getName());

    @NotNull(message = "{form.message.first_name.not_null}")
    @Length(min = 2, max = 45, message = "{field.length}")
    private String firstName;
    @NotNull(message = "{form.message.last_name_name.not_null}")
    @Length(min = 2, max = 45, message = "{field.length}")
    private String lastName;
    @NotNull(message = "{form.message.email.not_null}")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "{form.message.email.valid}")
    private String email;
    @Length(min = 0, max = 10, message = "{field.length.max}")
    private String message;
    @Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}" ,message = "{form.message.phone.valid}")
    private String phone;
    @NotNull(message = "{form.message.service.not_null}")
    private Services service;
    private boolean newsletter;

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the service
     */
    public Services getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(Services service) {
        this.service = service;
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
     * @return the newsletter
     */
    public boolean isNewsletter() {
        return newsletter;
    }

    /**
     * @param newsletter the newsletter to set
     */
    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
