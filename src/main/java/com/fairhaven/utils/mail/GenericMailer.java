/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.utils.mail;

import java.io.File;
import java.util.Date;
import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sam
 */
@Component
public class GenericMailer implements Mailer<GenericEmailTemplate> {

    @Resource
    private JavaMailSender mailSender;

    /**
     *
     * @param email
     * @param htmlText
     */
    @Override
    public void sendMail(GenericEmailTemplate email, boolean htmlText) {

        MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(email.getTo().toArray(new InternetAddress[email.getTo().size()]));
                message.setBcc(email.getBcc().toArray(new InternetAddress[email.getBcc().size()]));
                message.setFrom(email.getFrom());
                message.setSubject(email.getSubject());
                message.setSentDate(new Date());
                message.setText(email.getMessage(), htmlText);

                for (File attachment : email.getAttachments()) {
                    message.addAttachment(attachment.getName(), attachment);
                }
            }

        };
        mailSender.send(messagePreparator);
    }

}
