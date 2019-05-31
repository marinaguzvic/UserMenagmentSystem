/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

/**
 *
 * @author MARINA
 */
@Component("mobileNumberValidator")
public class MobileNumberValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String MOBILE_NUMBER_PATTERN = "\\+[0-9]{3,5}/[0-9]{3,4}-[0-9]{3,4}";

    public MobileNumberValidator() {
        pattern = Pattern.compile(MOBILE_NUMBER_PATTERN);
    }

    public boolean valid(final String text) {
        if(text == null || text.isEmpty())return true;
        matcher = pattern.matcher(text);
        return matcher.matches();

    }
}
