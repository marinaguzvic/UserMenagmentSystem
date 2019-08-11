/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

/**
 *
 * @author MARINA
 */
@Component("noSpecialCharactersNumbersValidator")
public class NoSpecialCharactersNumbersValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String NO_SPECIAL_CHARACTERS_OR_NUMBERS_PATTERN = "[A-Za-z ]+";

    public NoSpecialCharactersNumbersValidator() {
        pattern = Pattern.compile(NO_SPECIAL_CHARACTERS_OR_NUMBERS_PATTERN, Pattern.CASE_INSENSITIVE);
    }

    public boolean valid(final String text) {

        matcher = pattern.matcher(text);
        return matcher.matches();

    }
}
