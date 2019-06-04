/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.controller.util;

import com.marina.usermenagmentsystem.data.model.EnumFieldType;
import com.marina.usermenagmentsystem.service.model.TemplateDTO;
import com.marina.usermenagmentsystem.service.model.TemplateFieldDTO;
import com.marina.usermenagmentsystem.web.controller.file.TemplateDTOFileProxy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MARINA
 */
@Component
public class TemplateUtil {

    public void setFile(TemplateDTOFileProxy templateProxy) throws IOException {
        if (!templateProxy.getFile().isEmpty()) {
            templateProxy.getTemplate().setTemplateFile(templateProxy.getFile().getBytes());
            templateProxy.getTemplate().setTemplateFileType(templateProxy.getFile().getContentType());
            templateProxy.getTemplate().setTemplateFileName(templateProxy.getFile().getOriginalFilename());
        }
    }

    public List<String> getTypes() {
        List<String> types = new ArrayList<>();
        for (EnumFieldType value : EnumFieldType.values()) {
            types.add(value.name());
        }
        return types;
    }

    public int generateUpdateId(TemplateDTO template) {
        int max = 0;
        for (TemplateFieldDTO templateFieldDTO : template.getTemplateFieldList()) {
            if (templateFieldDTO.getTemplateFieldId() > max) {
                max = templateFieldDTO.getTemplateFieldId();
            }
        }
        return max + 1;
    }

    public void populateErrorCss(BindingResult result, ModelAndView mv, int size) {
        for (String attribute : getListOfAttributes()) {
            if (result.hasFieldErrors("template." + attribute)) {
                mv.addObject(attribute + "Vld", "is-invalid");
            } else {
                mv.addObject(attribute + "Vld", "is-valid");
            }
        }

        for (String attribute : getListOfFieldAttributes()) {
            List<String> validations = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                if (result.hasFieldErrors("template.templateFieldList[" + i + "]." + attribute)) {
                    validations.add("is-invalid");
                } else {
                    validations.add("is-valid");
                }
            }
            mv.addObject(attribute + "Vld", validations);
        }
    }

    List<String> getListOfAttributes() {
        List<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add("templateName");
        listOfAttributes.add("templateFile");
        listOfAttributes.add("templateFileName");
        listOfAttributes.add("templateFileType");
        return listOfAttributes;
    }

    List<String> getListOfFieldAttributes() {
        List<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add("templateFieldName");
        return listOfAttributes;
    }
}
