/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.config;

import com.marina.usermenagmentsystem.service.AccountService;
import com.marina.usermenagmentsystem.service.CompanyService;
import com.marina.usermenagmentsystem.service.DocumentFieldService;
import com.marina.usermenagmentsystem.service.DocumentService;
import com.marina.usermenagmentsystem.service.PositionService;
import com.marina.usermenagmentsystem.service.TemplateFieldService;
import com.marina.usermenagmentsystem.service.TemplateService;
import com.marina.usermenagmentsystem.service.impl.AccountServiceImpl;
import com.marina.usermenagmentsystem.service.impl.CompanyServiceImpl;
import com.marina.usermenagmentsystem.service.impl.DocumentFieldServiceImpl;
import com.marina.usermenagmentsystem.service.impl.DocumentServiceImpl;
import com.marina.usermenagmentsystem.service.impl.PositionServiceImpl;
import com.marina.usermenagmentsystem.service.impl.TemplateFieldServiceImpl;
import com.marina.usermenagmentsystem.service.impl.TemplateServiceImpl;
import com.marina.usermenagmentsystem.service.impl.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.marina.usermenagmentsystem.service.PersonService;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 *
 * @author MARINA
 */
@Configuration
@ComponentScan(basePackages = {
    "com.marina.usermenagmentsystem.data",
    "com.marina.usermenagmentsystem.service",
    "com.marina.usermenagmentsystem.web"
})
public class ApplicationConfig {

    @Bean
    public PersonService personService() {
        return new PersonServiceImpl();
    }

    @Bean
    public AccountService accountService() {
        return new AccountServiceImpl();
    }

    @Bean
    public CompanyService companyService() {
        return new CompanyServiceImpl();
    }

    @Bean
    public DocumentFieldService documentFieldService() {
        return new DocumentFieldServiceImpl();
    }

    @Bean
    public DocumentService documentService() {
        return new DocumentServiceImpl();
    }

    @Bean
    public PositionService positionService() {
        return new PositionServiceImpl();
    }

    @Bean
    public TemplateFieldService templateFieldService() {
        return new TemplateFieldServiceImpl();
    }

    @Bean
    public TemplateService templateService() {
        return new TemplateServiceImpl();
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
        rb.setBasenames(new String[]{"messages/validation"});
        return rb;
    }
}
