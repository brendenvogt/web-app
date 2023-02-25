package com.brendenvogt.webappapi.config;

import com.brendenvogt.webappapi.newsletter.NewsletterRestController;
import com.brendenvogt.webappapi.newsletter.NewsletterSubscription;
import com.brendenvogt.webappapi.newsletter.NewsletterSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Autowired
    private NewsletterSubscriptionRepository newsletterSubscriptionRepository;
    @Autowired
    private NewsletterRestController newsletterRestController;
    @Bean
    public CommandLineRunner initialize() {
        return args -> {
            final NewsletterSubscription subscription = NewsletterSubscription.builder()
                    .email("bvogtdev@gmail.com")
                    .build();
            newsletterSubscriptionRepository.save(subscription);
//            newsletterRestController.sendNewsletter();
        };
    }
}
