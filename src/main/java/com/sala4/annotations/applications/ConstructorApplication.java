package com.sala4.annotations.applications;

import com.sala4.annotations.services.IMailService;
import org.springframework.stereotype.Component;

@Component
public class ConstructorApplication {

        private final IMailService mailService;

        public ConstructorApplication(IMailService mailService) {
            this.mailService = mailService;
        }

        public void sendMail(String to, String subject, String body) {
            mailService.sendMail(to, subject, body);
        }
}
