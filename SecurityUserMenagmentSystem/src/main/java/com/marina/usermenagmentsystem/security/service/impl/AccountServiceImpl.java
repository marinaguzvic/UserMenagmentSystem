/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.service.impl;

import com.marina.usermenagmentsystem.security.database.AccountRepository;
import com.marina.usermenagmentsystem.security.database.model.Account;
import com.marina.usermenagmentsystem.security.database.model.dto.AccountDTO;
import com.marina.usermenagmentsystem.security.service.mapper.AccountMapper;
import com.marina.usermenagmentsystem.security.service.AccountService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MARINA
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;
    
    @Autowired
    AccountMapper accountMapper;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<AccountDTO> getAll() {
        return accountMapper.toDtoModel(accountRepository.findAll());
    }

    @Override
    public AccountDTO get(Long id) {
        return accountMapper.toDtoModel(accountRepository.findById(id).get());
    }

    @Override
    public AccountDTO update(AccountDTO user) {
        return accountMapper.toDtoModel(accountRepository.save(accountMapper.toDataModel(user)));
    }

    @Override
    public boolean delete(Long id) {
        try {
            accountRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public AccountDTO insert(AccountDTO user) {
        Account account = accountMapper.toDataModel(user);
        account.setEnabled(true);
        account.setCreated(new Date());
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountMapper.toDtoModel(accountRepository.save(account));
    }

}
