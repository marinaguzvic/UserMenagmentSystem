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
@Component("noSpecialCharactersValidator")
public class NoSpecialCharactersValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String NO_SPECIAL_CHARACTERS_PATTERN = "[a-z0-9 ]+";

    public NoSpecialCharactersValidator() {
        pattern = Pattern.compile(NO_SPECIAL_CHARACTERS_PATTERN, Pattern.CASE_INSENSITIVE);
    }

    public boolean valid(final String text) {

        matcher = pattern.matcher(text);
        return matcher.matches();

    }
}
