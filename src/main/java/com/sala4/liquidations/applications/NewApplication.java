package com.sala4.liquidations.applications;

import com.sala4.liquidations.services.MailService;
import org.springframework.stereotype.Component;

@Component
public class NewApplication {

    private MailService mailService;

    public void sendMail(String to, String subject, String body) {
        mailService = new MailService();
        mailService.sendMail(to, subject, body);
    }

}
