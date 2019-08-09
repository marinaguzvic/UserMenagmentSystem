/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.controller;

import com.marina.usermenagmentsystem.security.database.model.dto.AccountDTO;
import com.marina.usermenagmentsystem.security.service.AccountService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MARINA
 */
@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {
    
    @Autowired
    AccountService accountService;

    @GetMapping
    public ModelAndView showRegistration() {
        ModelAndView mv = new ModelAndView("registration");
        mv.addObject("account", new AccountDTO());
        return mv;
    }
    
    @PostMapping
    public ModelAndView register(@ModelAttribute("account") @Validated AccountDTO account, BindingResult bindingResult){
        ModelAndView mv = new ModelAndView("login");
        if (bindingResult.hasErrors()) {
            mv.setViewName("registration");
            mv.addObject("account", account);
            populateErrorCss(bindingResult, mv);
            return mv;
        } else {
            mv.addObject("css", "success");
            mv.addObject("msg", "Person added successfully!");
        }
        account = accountService.insert(account);
        return mv;
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
