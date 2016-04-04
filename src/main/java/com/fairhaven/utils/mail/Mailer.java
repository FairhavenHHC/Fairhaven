/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.utils.mail;

// Import log4j class
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 *
 * @author Sam
 */
@Component
public class Mailer {

    private static final Logger logger = Logger.getLogger(Mailer.class.getName());

    @Resource
    private JavaMailSender mailSender;
    @Resource
    private VelocityEngine velocityEngine;

    public void sendMail(String from, String to, String subject, String msg) {

        logger.info("Sending mail to: " + to);

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(to);
                message.setFrom(from);
                message.setSubject(subject);
                message.setSentDate(new Date());
                Map model = new HashMap();
                model.put("email", from);
                model.put("name", "Sam Indiazi");

                String text = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, "velocity/templates/service_inquiry.vm", "UTF-8", model);
                message.setText(text, true);
            }
        };
        mailSender.send(preparator);

        logger.info("Email successfully sent to: " + to);
    }

}
