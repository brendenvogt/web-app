package com.brendenvogt.webappapi.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfiguration {

    @Bean
    public CommandLineRunner testEmailSender(final EmailService emailService) {
        return args -> {
            System.out.println("Sending email");
            //emailService.sendSimpleMessage(
            //        "bvogtdev@gmail.com",
            //        "Hey from spring",
            //        "This is a test from spring local dev"
            //);
        };
    }

}
