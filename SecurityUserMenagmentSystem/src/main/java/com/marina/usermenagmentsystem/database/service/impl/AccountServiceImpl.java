/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.database.service.impl;

import com.marina.usermenagmentsystem.database.AccountRepository;
import com.marina.usermenagmentsystem.database.model.Account;
import com.marina.usermenagmentsystem.database.service.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account get(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public Account update(Account user) {
        return accountRepository.save(user);
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
    public Account insert(Account user) {
        return accountRepository.save(user);
    }

}
