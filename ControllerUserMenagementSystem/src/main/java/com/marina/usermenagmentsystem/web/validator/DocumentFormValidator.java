/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.validator;

import com.marina.usermenagmentsystem.service.model.DocumentDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author MARINA
 */
@Component
public class DocumentFormValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return DocumentDTO.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
    }
    
}
