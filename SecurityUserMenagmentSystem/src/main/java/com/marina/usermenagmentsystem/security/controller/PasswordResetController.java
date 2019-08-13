/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.controller;

import com.marina.usermenagmentsystem.security.database.model.Account;
import com.marina.usermenagmentsystem.security.error.UserNotFoundException;
import com.marina.usermenagmentsystem.security.database.model.PasswordResetToken;
import com.marina.usermenagmentsystem.security.database.model.dto.AccountDTO;
import com.marina.usermenagmentsystem.security.database.model.dto.PasswordDTO;
import com.marina.usermenagmentsystem.security.service.AccountService;
import com.marina.usermenagmentsystem.security.service.PasswordResetTokenService;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
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
@RequestMapping(value = "/resetPassword")
public class PasswordResetController {

    @Autowired
    AccountService accountService;

    @Autowired
    PasswordResetTokenService passwordResetTokenService;

    @Autowired
    JavaMailSender javaMailSender;
    
    @GetMapping(value = "/request")
    public ModelAndView showRequestPasswordReset(){
        ModelAndView mv = new ModelAndView("forgotPassword");
        return mv;
    }

    @PostMapping(value = "/request")
    public ModelAndView requestPasswordReset(WebRequest request, @RequestParam("email") String email) throws UserNotFoundException {
        ModelAndView mv = new ModelAndView("login");
        AccountDTO account = accountService.getByEmail(email);
        if (account == null) {
            throw new UserNotFoundException();
        }
        String token = passwordResetTokenService.insert(account);
        javaMailSender.send(constructResetTokenEmail(request.getContextPath(),
                request.getLocale(), token, account));
        return mv;
    }
    
    @GetMapping
    public ModelAndView showChangePasswordPage(@RequestParam("id") Long id, @RequestParam("token") String token){
        ModelAndView mv = new ModelAndView("updatePassword");
        boolean exists = passwordResetTokenService.exists(id, token);
        if(!exists){
            //add some message
            mv.setViewName("login");
            return mv;
        }
        PasswordDTO password = new PasswordDTO();
        mv.addObject("password", password);
        return mv;
    }
    
    @PostMapping
    public ModelAndView changePassword(@ModelAttribute("password") @Validated PasswordDTO password){
        //insert validation
        ModelAndView mv = new ModelAndView("login");
        Account account = (Account)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        accountService.changeUserPassword(account, password.getPassword());
        return mv;
    }

    private SimpleMailMessage constructResetTokenEmail(
            String contextPath, Locale locale, String token, AccountDTO account) {
        String url = contextPath + "/resetPassword?id="
                + account.getId() + "&token=" + token;
//        String message = messages.getMessage("message.resetPassword",
//                null, locale);
        return constructEmail("Reset Password"," \r\n" + "http://localhost:8080" + url, account);
    }

    private SimpleMailMessage constructEmail(String subject, String body,
            AccountDTO account) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(account.getEmail());
        return email;
    }
}
