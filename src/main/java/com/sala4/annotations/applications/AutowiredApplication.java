package com.sala4.annotations.applications;

import com.sala4.annotations.services.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredApplication {

    @Autowired
    private IMailService mailService;

    public void sendMail(String to, String subject, String body) {
        this.mailService.sendMail(to, subject, body);
    }
}
