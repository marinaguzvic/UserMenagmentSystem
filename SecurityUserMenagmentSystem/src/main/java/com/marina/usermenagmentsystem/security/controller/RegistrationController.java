/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.controller;

import com.marina.usermenagmentsystem.security.database.model.dto.AccountDTO;
import com.marina.usermenagmentsystem.security.database.model.dto.EmailVerificationTokenDTO;
import com.marina.usermenagmentsystem.security.event.RegistrationCompleteEvent;
import com.marina.usermenagmentsystem.security.service.AccountService;
import com.marina.usermenagmentsystem.security.service.EmailVerificationTokenService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MARINA
 */
@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    AccountService accountService;

    @Autowired
    EmailVerificationTokenService emailVerificationTokenService;

    @Autowired
    MessageSource messageSource;

    @GetMapping
    public ModelAndView showRegistration() {
        ModelAndView mv = new ModelAndView("registration");
        mv.addObject("account", new AccountDTO());
        return mv;
    }

    @PostMapping
    public ModelAndView register(@ModelAttribute("account") @Validated AccountDTO account, BindingResult bindingResult, WebRequest request) {
        ModelAndView mv = new ModelAndView("login");
        if (bindingResult.hasErrors()) {
            mv.setViewName("registration");
            mv.addObject("account", account);
            populateErrorCss(bindingResult, mv);
            return mv;
        } else {
            account = accountService.insert(account);
            try {
                String appUrl = request.getContextPath();
                eventPublisher.publishEvent(new RegistrationCompleteEvent(accountService.getRaw(account.getId()), Locale.ENGLISH, appUrl));
                mv.addObject("css", "success");
                mv.addObject("msg", "Person added successfully!");
            } catch (Exception e) {
                //what if email doesn't go through
                e.printStackTrace();

                System.out.println("Email didn't go through");
            }

        }

        return mv;
    }

    @GetMapping(value = "/confirm")
    public ModelAndView confirmRegistration(WebRequest request, @RequestParam("token") String token) {

        ModelAndView modelAndView = new ModelAndView("login");

        Locale locale = request.getLocale();

        EmailVerificationTokenDTO emailToken = emailVerificationTokenService.getByToken(token);
        if (emailToken == null) {
            String message = messageSource.getMessage("auth.message.invalidToken", null, locale);
            modelAndView.addObject("message", message);
        }
        AccountDTO account = emailToken.getAccount();
        Calendar cal = Calendar.getInstance();

        if ((emailToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            String message = messageSource.getMessage("auth.message.expired", null, locale);
            modelAndView.addObject("message", message);
            return modelAndView;
        }

        account.setEnabled(true);
        accountService.update(account);
        return modelAndView;
    }

    @GetMapping(value = "/resendToken")
    public ModelAndView resendRegistrationToken(WebRequest request, @RequestParam("token") String token) {
        ModelAndView modelAndView = new ModelAndView("login");

        Locale locale = request.getLocale();

        EmailVerificationTokenDTO emailToken = emailVerificationTokenService.getByToken(token);
        if (emailToken == null) {
            String message = messageSource.getMessage("auth.message.invalidToken", null, locale);
            modelAndView.addObject("message", message);
        }
        String appUrl = request.getContextPath();
        eventPublisher.publishEvent(new RegistrationCompleteEvent(accountService.getRaw(emailToken.getAccount().getId()), Locale.ENGLISH, appUrl));

        return modelAndView;
    }

    List<String> getListOfAttributes() {
        List<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add("email");
        listOfAttributes.add("firstName");
        listOfAttributes.add("lastName");
        listOfAttributes.add("password");
        listOfAttributes.add("confirmPassword");
        return listOfAttributes;
    }

    private void populateErrorCss(BindingResult result, ModelAndView mv) {
        for (String attribute : getListOfAttributes()) {
            if (result.hasFieldErrors(attribute)) {
                mv.addObject(attribute + "Vld", "is-invalid");
            } else {
                mv.addObject(attribute + "Vld", "is-valid");
            }
        }
    }
}
