/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.service;

import com.marina.usermenagmentsystem.security.database.model.dto.AccountDTO;
import org.springframework.stereotype.Service;

/**
 *
 * @author MARINA
 */
@Service
public interface PasswordResetTokenService {


    public boolean deleteByAccountId(Long id);

    public String insert(AccountDTO account);

    public boolean exists(Long id, String token);
}
