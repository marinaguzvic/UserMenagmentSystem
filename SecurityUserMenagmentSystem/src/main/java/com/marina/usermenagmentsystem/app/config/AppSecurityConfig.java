/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.app.config;

import com.marina.usermenagmentsystem.database.service.AccountService;
import com.marina.usermenagmentsystem.database.service.impl.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *
 * @author MARINA
 */
@Configuration
@ComponentScan(basePackages = {"com.marina.usermenagmentsystem.database.service"})
public class AppSecurityConfig {
    
    @Bean
    AccountService accountService(){
        return new AccountServiceImpl();
    }
}
