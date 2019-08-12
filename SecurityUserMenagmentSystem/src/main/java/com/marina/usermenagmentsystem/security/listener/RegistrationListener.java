/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.listener;

import com.marina.usermenagmentsystem.security.database.EmailVerificationTokenRepository;
import com.marina.usermenagmentsystem.security.database.model.Account;
import com.marina.usermenagmentsystem.security.database.model.EmailVerificationToken;
import com.marina.usermenagmentsystem.security.database.model.dto.AccountDTO;
import com.marina.usermenagmentsystem.security.event.RegistrationCompleteEvent;
import com.marina.usermenagmentsystem.security.service.AccountService;
import com.marina.usermenagmentsystem.security.service.EmailVerificationTokenService;
import java.util.Locale;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author MARINA
 */
@Component
public class RegistrationListener implements ApplicationListener<RegistrationCompleteEvent>{
    
    @Autowired
    EmailVerificationTokenService emailVerificationTokenService;

    @Autowired
    private MessageSource messageSource;
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent e) {
        this.confirmRegistration(e);
    }

    private void confirmRegistration(RegistrationCompleteEvent e) {
        Account account = e.getAccount();
        String token = UUID.randomUUID().toString();
        
        emailVerificationTokenService.deleteByAccount(account.getId());
        // create verification token
        //create service for it?
        emailVerificationTokenService.createVerificationToken(account, token);
        String recipientAddress = account.getUsername();
        String subject = "Registration Confirmation";
        String confirmationUrl = e.getAppUrl() + "/registration/confirm?token=" + token;
        
//        String message = messageSource.getMessage("message.registration.success", null, e.getLocale());
        String message = "Click on link ";
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        
        email.setText(message + " rn" + "http://localhost:8080" + confirmationUrl);
        javaMailSender.send(email);
    }
    
}
