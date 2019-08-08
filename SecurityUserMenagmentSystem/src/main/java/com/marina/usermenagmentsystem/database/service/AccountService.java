/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.database.service;

import com.marina.usermenagmentsystem.database.model.Account;
import java.util.List;

/**
 *
 * @author MARINA
 */
public interface AccountService {

    public List<Account> getAll();

    public Account get(Long id);

    public Account update(Account user);

    public boolean delete(Long id);

    public Account insert(Account user);
}
