/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.service;

import com.marina.usermenagmentsystem.security.database.model.Account;
import com.marina.usermenagmentsystem.security.database.model.dto.AccountDTO;
import java.util.List;

/**
 *
 * @author MARINA
 */
public interface AccountService {

    public List<AccountDTO> getAll();

    public AccountDTO get(Long id);

    public AccountDTO update(AccountDTO user);

    public boolean delete(Long id);

    public AccountDTO insert(AccountDTO user);
}
