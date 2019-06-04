/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.validator;

import com.marina.usermenagmentsystem.service.model.TemplateDTO;
import com.marina.usermenagmentsystem.service.model.TemplateFieldDTO;
import com.marina.usermenagmentsystem.web.controller.file.TemplateDTOFileProxy;
import com.marina.usermenagmentsystem.web.controller.util.TemplateUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class TemplateFormSaveValidator implements Validator {

    @Autowired
    @Qualifier("noSpecialCharactersOrNumbersValidator")
    NoSpecialCharactersOrNumbersValidator noSpecialCharactersOrNumbersValidator;

    @Autowired
    @Qualifier("noSpecialCharactersValidator")
    NoSpecialCharactersValidator noSpecialCharactersValidator;
    
    @Autowired
    TemplateUtil templateUtil;

    @Override
    public boolean supports(Class<?> type) {
        return TemplateDTOFileProxy.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TemplateDTOFileProxy template = (TemplateDTOFileProxy) o;
        try {
            templateUtil.setFile(template);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "template.templateName", "NotEmpty.templateForm.templateName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "template.templateFile", "NotEmpty.templateForm.templateFile");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "template.templateFileType", "NotEmpty.templateForm.templateFileType");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "template.templateFileName", "NotEmpty.templateForm.templateFileName");

        if (!noSpecialCharactersValidator.valid(template.getTemplate().getTemplateName())) {
            errors.reject("template.templateName", "Pattern.templateForm.templateName");
        }


        for (int i = 0; i < template.getTemplate().getTemplateFieldList().size() - 1; i++) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "template.templateFieldList[" + i + "].templateFieldName", "NotEmpty.templateForm.templateFieldName");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "template.templateFieldList[" + i + "].templateFieldType", "NotEmpty.templateForm.templateFieldType");
            if (!noSpecialCharactersOrNumbersValidator.valid(template.getTemplate().getTemplateFieldList().get(i).getTemplateFieldName())) {
                errors.reject("template.templateFieldList[" + i + "].templateFieldName", "Pattern.templateForm.templateFieldName");
            }
        }
        
        if(template.getTemplate().getTemplateFieldList().size() <= 1){
            errors.reject("template","NotEmpty.templateForm.template");
        }

    }

}
