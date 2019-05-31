/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.validator;

import com.marina.usermenagmentsystem.service.PersonService;
import com.marina.usermenagmentsystem.service.model.PersonDTO;
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
public class PersonFormValidator implements Validator {

    @Autowired
    @Qualifier("emailPatternValidator")
    EmailPatternValidator emailPatternValidator;
    
    @Autowired
    @Qualifier("emailUniqueValidator")
    EmailUniqueValidator emailUniqueValidator;
    
    @Autowired
    @Qualifier("dateOfBirthValidator")
    DateOfBirthValidator dateOfBirthValidator;
    
    @Autowired
    @Qualifier("genderValidator")
    GenderValidator genderValidator;
    
    @Autowired
    @Qualifier("mobileNumberValidator")
    MobileNumberValidator mobileNumberValidator;
    
    @Autowired
    @Qualifier("noSpecialCharactersOrNumbersValidator")
    NoSpecialCharactersOrNumbersValidator noSpecialCharactersOrNumbersValidator;
    
    @Autowired
    PersonService personService;

    @Override
    public boolean supports(Class<?> type) {
        return PersonDTO.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PersonDTO person = (PersonDTO)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.personForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.personForm.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.personForm.lastName");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNumber", "NotEmpty.personForm.mobileNumber");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty.personForm.gender");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "NotEmpty.personForm.dateOfBirth");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "position", "NotEmpty.personForm.position");
        
        if(!emailPatternValidator.valid(person.getEmail())){
            errors.rejectValue("email", "Pattern.personForm.email");
        }
        
        if(!emailUniqueValidator.valid(person.getId(),person.getEmail())){
            errors.rejectValue("email", "Unique.personForm.email");
        }
        
        if(!noSpecialCharactersOrNumbersValidator.valid(person.getFirstName())){
            errors.rejectValue("firstName", "Pattern.personForm.firstName");
        }
        
        if(!noSpecialCharactersOrNumbersValidator.valid(person.getLastName())){
            errors.rejectValue("lastName", "Pattern.personForm.lastName");
        }

        if(!mobileNumberValidator.valid(person.getMobileNumber())){
            errors.rejectValue("mobileNumber", "Pattern.personForm.mobileNumber");
        }
        
        if(!genderValidator.valid(person.getGender())){
            errors.rejectValue("gender", "Values.personForm.gender");
        }
        
        if(!dateOfBirthValidator.valid(person.getDateOfBirth())){
            errors.rejectValue("dateOfBirth", "Years.personForm.dateOfBirth");
        }
        
        
    }

}
