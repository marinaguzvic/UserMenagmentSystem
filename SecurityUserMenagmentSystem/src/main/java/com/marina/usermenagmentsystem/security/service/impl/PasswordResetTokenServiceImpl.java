/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.service.impl;

import com.marina.usermenagmentsystem.security.database.PasswordResetTokenRepository;
import com.marina.usermenagmentsystem.security.database.model.PasswordResetToken;
import com.marina.usermenagmentsystem.security.database.model.dto.AccountDTO;
import com.marina.usermenagmentsystem.security.service.PasswordResetTokenService;
import com.marina.usermenagmentsystem.security.service.mapper.AccountMapper;
import java.util.Arrays;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author MARINA
 */
@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public boolean deleteByAccountId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert(AccountDTO account) {
        String token = UUID.randomUUID().toString();
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setAccount(accountMapper.toDataModel(account));
        passwordResetToken.setExpiryDate();
        passwordResetToken.setToken(token);
        passwordResetTokenRepository.save(passwordResetToken);
        return token;
    }

    @Override
    public boolean exists(Long id, String token) {
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);
        if (passwordResetToken != null && passwordResetToken.getAccount().getId() == id) {
            final Authentication auth = new UsernamePasswordAuthenticationToken(passwordResetToken.getAccount(), null, Arrays.asList(new SimpleGrantedAuthority("CHANGE_PASSWORD_PRIVILEGE")));
            SecurityContextHolder.getContext().setAuthentication(auth);
            return true;
        }
        return false;
    }

}
