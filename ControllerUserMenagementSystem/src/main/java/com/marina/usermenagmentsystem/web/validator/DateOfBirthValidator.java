/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.validator;

import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author MARINA
 */
@Component("dateOfBirthValidator")
public class DateOfBirthValidator {
    
    public boolean valid(Date date){
        if(date == null) return true;
        Date now = new Date();
        now.setYear(now.getYear() - 16);
        return now.after(date);
    }
}
