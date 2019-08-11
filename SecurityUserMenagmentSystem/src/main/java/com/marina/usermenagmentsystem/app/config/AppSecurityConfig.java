/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.app.config;

import com.marina.usermenagmentsystem.security.database.model.EmailVerificationToken;
import com.marina.usermenagmentsystem.security.service.AccountService;
import com.marina.usermenagmentsystem.security.service.EmailVerificationTokenService;
import com.marina.usermenagmentsystem.security.service.impl.AccountServiceImpl;
import com.marina.usermenagmentsystem.security.service.impl.EmailVerificationTokenServiceImpl;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 *
 * @author MARINA
 */
@Configuration
@ComponentScan(basePackages = {
    "com.marina.usermenagmentsystem.security.service",
    "com.marina.usermenagmentsystem.security.service.mapper"})
public class AppSecurityConfig {

    @Bean
    public AccountService accountService() {
        return new AccountServiceImpl();
    }

    @Bean
    public EmailVerificationTokenService emailVerificationTokenService() {
        return new EmailVerificationTokenServiceImpl();
    }

    @Bean("javaMailSender")
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("marina.test.95@gmail.com");
        mailSender.setPassword("baycbiodtest");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
