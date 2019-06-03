/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.validator;

import com.marina.usermenagmentsystem.service.model.TemplateDTO;
import com.marina.usermenagmentsystem.service.model.TemplateFieldDTO;
import com.marina.usermenagmentsystem.web.controller.file.TemplateDTOFileProxy;
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
public class TemplateFormAddFieldValidator implements Validator {

    @Autowired
    @Qualifier("noSpecialCharactersOrNumbersValidator")
    NoSpecialCharactersOrNumbersValidator noSpecialCharactersOrNumbersValidator;

    @Autowired
    @Qualifier("noSpecialCharactersValidator")
    NoSpecialCharactersValidator noSpecialCharactersValidator;

    @Override
    public boolean supports(Class<?> type) {
        return TemplateDTOFileProxy.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TemplateDTOFileProxy template = (TemplateDTOFileProxy) o;

        for (int i = 0; i < template.getTemplate().getTemplateFieldList().size(); i++) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "template.templateFieldList[" + i + "].templateFieldName", "NotEmpty.templateForm.templateFieldName");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "template.templateFieldList[" + i + "].templateFieldType", "NotEmpty.templateForm.templateFieldType");
            if (!noSpecialCharactersOrNumbersValidator.valid(template.getTemplate().getTemplateFieldList().get(i).getTemplateFieldName())) {
                errors.reject("template.templateFieldList[" + i + "].templateFieldName", "Pattern.templateForm.templateFieldName");
            }
        }

    }

}
