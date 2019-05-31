/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.impl;

import com.marina.usermenagmentsystem.data.repository.AccountRepository;
import com.marina.usermenagmentsystem.service.AccountService;
import com.marina.usermenagmentsystem.service.mapper.AccountMapper;
import com.marina.usermenagmentsystem.service.model.AccountDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MARINA
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<AccountDTO> getAll() {
        return accountMapper.toDtoModel(accountRepository.findAll());
    }

    @Override
    public AccountDTO get(Long id) {
        try {
            return accountMapper.toDtoModel(accountRepository.findById(id).get());
        } catch (Exception e) {
            return null;
        }
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
        return accountMapper.toDtoModel(accountRepository.save(accountMapper.toDataModel(user)));
    }

}
