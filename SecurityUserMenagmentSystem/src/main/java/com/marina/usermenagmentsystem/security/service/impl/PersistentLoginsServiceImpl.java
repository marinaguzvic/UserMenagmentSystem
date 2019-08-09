/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.service.impl;

import com.marina.usermenagmentsystem.security.database.PersistentLoginsRepository;
import com.marina.usermenagmentsystem.security.database.model.PersistentLogins;
import com.marina.usermenagmentsystem.security.service.PersistentLoginsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MARINA
 */
@Service
public class PersistentLoginsServiceImpl implements PersistentLoginsService {

    @Autowired
    PersistentLoginsRepository persistentLoginsRepository;

    @Override
    public List<PersistentLogins> getAll() {
        return persistentLoginsRepository.findAll();
    }

    @Override
    public PersistentLogins get(String id) {
        return persistentLoginsRepository.getOne(id);
    }

    @Override
    public PersistentLogins update(PersistentLogins user) {
        return persistentLoginsRepository.save(user);
    }

    @Override
    public boolean delete(String id) {
        try {
            persistentLoginsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    @Override
    public PersistentLogins insert(PersistentLogins user) {
        return persistentLoginsRepository.save(user);
    }

}
