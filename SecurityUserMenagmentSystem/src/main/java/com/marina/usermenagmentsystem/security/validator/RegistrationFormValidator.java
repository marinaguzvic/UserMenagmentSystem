/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.validator;

import com.marina.usermenagmentsystem.security.database.model.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author MARINA
 */
@Component
public class RegistrationFormValidator implements Validator {

    @Autowired
    @Qualifier("emailPatternValidator")
    EmailPatternValidator emailPatternValidator;

    @Autowired
    @Qualifier("emailUniqueValidator")
    EmailUniqueValidator emailUniqueValidator;

    @Autowired
    @Qualifier("noSpecialCharactersOrNumbersValidator")
    NoSpecialCharactersOrNumbersValidator noSpecialCharactersOrNumbersValidator;

    @Autowired
    @Qualifier("passwordValidator")
    PasswordValidator passwordValidator;

    @Override
    public boolean supports(Class<?> type) {
        return AccountDTO.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AccountDTO a = (AccountDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.registrationForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.registrationForm.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.registrationForm.lastName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty.registrationForm.gender");

        if (!emailPatternValidator.valid(a.getEmail())) {
            errors.rejectValue("email", "Pattern.registrationForm.email");
        }

        if (!emailUniqueValidator.valid(a.getId(), a.getEmail())) {
            errors.rejectValue("email", "Unique.registrationForm.email");
        }

        if (!noSpecialCharactersOrNumbersValidator.valid(a.getFirstName())) {
            errors.rejectValue("firstName", "Pattern.registrationForm.firstName");
        }

        if (!noSpecialCharactersOrNumbersValidator.valid(a.getLastName())) {
            errors.rejectValue("lastName", "Pattern.registrationForm.lastName");
        }

        if (!passwordValidator.valid(a.getPassword())) {
            errors.rejectValue("password", "Pattern.registrationForm.password");
        }

        if (!a.getPassword().equals(a.getConfirmPassword())) {
            errors.rejectValue("password", "Pattern.registrationForm.password");
            errors.rejectValue("confirmPassword", "Pattern.registrationForm.confirmPassword");
        }
    }

}
