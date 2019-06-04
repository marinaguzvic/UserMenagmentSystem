/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.mapper.context;

import com.marina.usermenagmentsystem.data.model.DocumentField;
import com.marina.usermenagmentsystem.service.model.DocumentFieldDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Component;

/**
 *
 * @author MARINA
 */
@Component
public class ValueFactory {

    public String toValueDTO(DocumentField documentField) {
        switch (documentField.getTemplateField().getTemplateFieldType()) {
            case DATE:
                return new SimpleDateFormat("dd/mm/yyyy").format(documentField.getFieldValueDate());
            case DOUBLE:
                return documentField.getFieldValueDouble()+"";
            case INTEGER:
                return documentField.getFieldValueInteger()+"";
            case LONG:
                return documentField.getFieldValueLong()+"";
            case STRING:
                return documentField.getFieldValueString();
            default:
                return "";
        }
    }

    public void setValue(String value, DocumentField documentField) throws ParseException {
        switch (documentField.getTemplateField().getTemplateFieldType()) {
            case DATE:
                documentField.setFieldValueDate(new SimpleDateFormat("dd/mm/yyyy").parse(value));
                break;
            case DOUBLE:
                documentField.setFieldValueDouble(Double.parseDouble(value));
                break;
            case INTEGER:
                documentField.setFieldValueInteger(Integer.getInteger(value));
                break;
            case LONG:
                documentField.setFieldValueLong(Long.parseLong(value));
                break;
            case STRING:
                documentField.setFieldValueString(value);
                break;
            default:
        }
    }
}
