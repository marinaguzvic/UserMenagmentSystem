/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.service.impl;

import com.marina.usermenagmentsystem.security.database.AccountRepository;
import com.marina.usermenagmentsystem.security.database.model.Account;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MARINA
 */
@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService{
    
    @Autowired
    private AccountRepository accountRepository;
    
    
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {

        Account account = accountRepository.findByUsername(string);
        UserBuilder builder = null;        
        if(account != null){
            builder = User.withUsername(string);
            builder.disabled(!account.isEnabled());
            builder.password(account.getPassword());
            //Change code for authorities
            String [] authorities = new String[]{"ROLE_USER","ROLE_ADMIN"};
            builder.authorities(authorities);
        }else{
            throw new UsernameNotFoundException("User not found");
        }
        return builder.build();
    }
    
}
