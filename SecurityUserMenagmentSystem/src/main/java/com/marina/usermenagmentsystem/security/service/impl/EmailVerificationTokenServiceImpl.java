/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.service.impl;

import com.marina.usermenagmentsystem.security.database.EmailVerificationTokenRepository;
import com.marina.usermenagmentsystem.security.database.model.Account;
import com.marina.usermenagmentsystem.security.database.model.EmailVerificationToken;
import com.marina.usermenagmentsystem.security.database.model.dto.AccountDTO;
import com.marina.usermenagmentsystem.security.database.model.dto.EmailVerificationTokenDTO;
import com.marina.usermenagmentsystem.security.service.EmailVerificationTokenService;
import com.marina.usermenagmentsystem.security.service.mapper.AccountMapper;
import com.marina.usermenagmentsystem.security.service.mapper.EmailVerificationTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MARINA
 */
@Service
public class EmailVerificationTokenServiceImpl implements EmailVerificationTokenService{
    
    @Autowired
    EmailVerificationTokenRepository emailVerificationTokenRepository;
    
    @Autowired
    AccountMapper accountMapper;
    
    @Autowired
    EmailVerificationTokenMapper mapper;

    @Override
    public void createVerificationToken(Account account, String token) {
        EmailVerificationToken emailVerificationToken = new EmailVerificationToken();
        emailVerificationToken.setAccount(account);
        emailVerificationToken.setToken(token);
        emailVerificationToken.setExpiryDate();
        emailVerificationTokenRepository.save(emailVerificationToken);
    }

    @Override
    public EmailVerificationTokenDTO getByToken(String token) {
        return mapper.toDtoModel(emailVerificationTokenRepository.findByToken(token));
    }
    
}
