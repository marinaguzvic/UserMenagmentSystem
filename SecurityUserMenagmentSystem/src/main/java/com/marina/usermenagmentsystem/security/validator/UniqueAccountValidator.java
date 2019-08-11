/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.validator;

import com.marina.usermenagmentsystem.security.database.model.dto.AccountDTO;
import com.marina.usermenagmentsystem.security.service.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author MARINA
 */
@Component("uniqueAccountValidator")
public class UniqueAccountValidator {

    @Autowired
    AccountService accountService;
    
    public boolean valid(Long id, String email){
        List<AccountDTO> persons = accountService.getAll();
        for (AccountDTO person : persons) {
            if(person.getId() != id && person.getEmail().equalsIgnoreCase(email))return false;
        }
        return true;
    }
}
