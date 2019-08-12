/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.service;

import com.marina.usermenagmentsystem.security.database.model.Account;
import com.marina.usermenagmentsystem.security.database.model.dto.EmailVerificationTokenDTO;

/**
 *
 * @author MARINA
 */
public interface EmailVerificationTokenService {
    public void createVerificationToken(Account account, String token);
    public EmailVerificationTokenDTO getByToken(String token);

    public void deleteByAccount(Long id);
}
