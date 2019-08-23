/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.test;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author MARINA
 */
@Configuration
@ComponentScan(basePackages = {
    "com.marina.usermenagmentsystem.service",
    "com.marina.usermenagmentsystem.data.model",
    "com.marina.usermenagmentsystem.data.repository",
    "com.marina.usermenagmentsystem.data.audit.repository"
})
public class SpringTestConfig {
    
}
