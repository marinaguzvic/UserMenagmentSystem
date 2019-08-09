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
@Component("passwordValidator")
public class PasswordValidator {
    	private Pattern pattern;
	private Matcher matcher;

	private static final String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).{4,8}$";

	public PasswordValidator() {
		pattern = Pattern.compile(PASSWORD_PATTERN);
	}

	public boolean valid(final String email) {

		matcher = pattern.matcher(email);
		return matcher.matches();

	}
}
