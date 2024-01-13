package com.ssofficial.springsecurityclass.event.listener;

import com.ssofficial.springsecurityclass.entity.User;
import com.ssofficial.springsecurityclass.event.RegistrationCompleteEvent;
import com.ssofficial.springsecurityclass.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create the verification token for the user with links
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);

        // sent mail to user
        String url = event.getApplicationUrl() + "verifyRegistration?token=" + token;

        // sentVerificationEmail()
        log.info("Click the link to verify you account: {}", url);

    }
}
