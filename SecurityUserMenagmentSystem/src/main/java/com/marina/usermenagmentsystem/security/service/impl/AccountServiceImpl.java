/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.service.impl;

import com.marina.usermenagmentsystem.security.database.AccountRepository;
import com.marina.usermenagmentsystem.security.database.RoleRepository;
import com.marina.usermenagmentsystem.security.database.model.Account;
import com.marina.usermenagmentsystem.security.database.model.Role;
import com.marina.usermenagmentsystem.security.database.model.dto.AccountDTO;
import com.marina.usermenagmentsystem.security.service.mapper.AccountMapper;
import com.marina.usermenagmentsystem.security.service.AccountService;
import java.util.Arrays;
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
    
    @Autowired
    RoleRepository roleRepository;

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
        account.setEnabled(false);
        account.setCreated(new Date());
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER");
        role.getAccounts().add(account);
        account.setRoles(Arrays.asList(role));
        return accountMapper.toDtoModel(accountRepository.save(account));
    }

    @Override
    public Account getRaw(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public AccountDTO getByEmail(String email) {
        Account account = accountRepository.findByUsername(email);
        return accountMapper.toDtoModel(account);
    }

    @Override
    public void changeUserPassword(Account account, String password) {
        account.setPassword(passwordEncoder.encode(password));
        accountRepository.save(account);
    }

}
