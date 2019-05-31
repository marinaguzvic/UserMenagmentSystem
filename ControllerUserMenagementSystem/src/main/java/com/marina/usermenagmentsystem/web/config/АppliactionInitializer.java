/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author MARINA
 */
public class АppliactionInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(ApplicationConfig.class);
        sc.addListener(new ContextLoaderListener(rootContext));
        AnnotationConfigWebApplicationContext dispatcherWebContext = new AnnotationConfigWebApplicationContext();
        dispatcherWebContext.register(WebConfig.class);
        ServletRegistration.Dynamic dispatcher = sc.addServlet("mvc", new DispatcherServlet(dispatcherWebContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
    
}
