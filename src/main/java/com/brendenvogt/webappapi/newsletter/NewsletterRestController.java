package com.brendenvogt.webappapi.newsletter;

import com.brendenvogt.webappapi.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("email")
public class NewsletterRestController {

    @Autowired
    private NewsletterSubscriptionRepository newsletterSubscriptionRepository;
    @Autowired
    private EmailService emailService;

    @PostMapping("send")
    public ResponseEntity<String> sendNewsletter() {
        newsletterSubscriptionRepository.findAll()
                .forEach(newsletterSubscription -> {
                    emailService.sendSimpleMessage(
                            newsletterSubscription.getEmail(),
                            "Newsletter",
                            "Welcome to the email newsletter"
                    );
                });
        return ResponseEntity.of(Optional.of("done"));
    }

    @PostMapping("subscription")
    public ResponseEntity<String> subscribeToNewsletter(@RequestBody NewsletterSubscriptionRequest subscriptionRequest) {
        newsletterSubscriptionRepository.findByEmail(subscriptionRequest.getEmail())
                .ifPresentOrElse((item) -> System.out.println("found already"), () -> {
                    final NewsletterSubscription subscription = NewsletterSubscription.builder().email(subscriptionRequest.getEmail()).build();
                    newsletterSubscriptionRepository.save(subscription);
                });
        return ResponseEntity.of(Optional.of("done"));
    }

    @DeleteMapping("subscription/{id}")
    public ResponseEntity<String> subscribeNewsletter(@RequestBody NewsletterSubscriptionRequest subscriptionRequest) {
        newsletterSubscriptionRepository.findByEmail(subscriptionRequest.getEmail())
                .ifPresentOrElse((item) -> newsletterSubscriptionRepository.deleteById(item.getId()),
                        () -> System.out.println("Not found"));
        return ResponseEntity.of(Optional.of("done"));
    }

}
