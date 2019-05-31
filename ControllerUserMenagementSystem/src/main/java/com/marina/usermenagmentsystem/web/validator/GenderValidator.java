/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.validator;

import org.springframework.stereotype.Component;

/**
 *
 * @author MARINA
 */
@Component("genderValidator")
public class GenderValidator {
    
    boolean valid(String gender){
        if(gender == null) return false;
        if(gender.equals("Female") || gender.equals("Male"))return true;
        return false;
    }
}
