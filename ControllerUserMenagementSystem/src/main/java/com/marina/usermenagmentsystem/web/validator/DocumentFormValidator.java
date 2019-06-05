/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.validator;

import com.marina.usermenagmentsystem.service.model.DocumentDTO;
import com.marina.usermenagmentsystem.service.model.DocumentFieldDTO;
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
public class DocumentFormValidator implements Validator {

    @Autowired
    @Qualifier("typeValueValidator")
    TypeValueValidator typeValueValidator;

    @Autowired
    @Qualifier("noSpecialCharactersValidator")
    NoSpecialCharactersValidator noSpecialCharactersValidator;

    @Override
    public boolean supports(Class<?> type) {
        return DocumentDTO.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        DocumentDTO document = (DocumentDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "documentName", "NotEmpty.documentForm.documentName");
        
        if(!noSpecialCharactersValidator.valid(document.getDocumentName())){
            errors.rejectValue("documentName","Pattern.documentForm.documentName");
        }

        for (int i = 0; i < document.getDocumentFieldList().size(); i++) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "documentFieldList[" + i + "].fieldValue", "NotEmpty.documentForm.fieldValue");
            if (!typeValueValidator.valid(document.getDocumentFieldList().get(i))) {
                errors.rejectValue("documentFieldList[" + i + "].fieldValue", "Type.documentForm.fieldValue");
            }
        }
    }

}
