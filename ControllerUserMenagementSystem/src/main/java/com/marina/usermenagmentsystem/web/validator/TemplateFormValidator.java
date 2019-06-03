/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.validator;

import com.marina.usermenagmentsystem.service.model.TemplateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author MARINA
 */
@Component
public class TemplateFormValidator implements Validator {

    @Autowired
    @Qualifier("noSpecialCharactersOrNumbersValidator")
    NoSpecialCharactersOrNumbersValidator noSpecialCharactersOrNumbersValidator;

    @Override
    public boolean supports(Class<?> type) {
        return TemplateDTO.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
    }

}
