/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.validator;

import com.marina.usermenagmentsystem.data.model.EnumFieldType;
import com.marina.usermenagmentsystem.service.model.DocumentFieldDTO;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author MARINA
 */
@Component("typeValueValidator")
public class TypeValueValidator {

    boolean valid(DocumentFieldDTO documentFieldDTO) {
        try {
            switch (EnumFieldType.valueOf(documentFieldDTO.getTemplateField().getTemplateFieldType())) {
                case DATE:
                    Date date = new SimpleDateFormat("dd/mm/yyyy").parse(documentFieldDTO.getFieldValue());
                    break;
                case DOUBLE:
                    double d = Double.parseDouble(documentFieldDTO.getFieldValue());
                    break;
                case INTEGER:
                    int i = Integer.getInteger(documentFieldDTO.getFieldValue());
                    break;
                case LONG:
                    long a = Long.parseLong(documentFieldDTO.getFieldValue());
                    break;
                case STRING:
                    break;
                default:
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        } catch (Exception e){
            return false;
        }

    }
}
