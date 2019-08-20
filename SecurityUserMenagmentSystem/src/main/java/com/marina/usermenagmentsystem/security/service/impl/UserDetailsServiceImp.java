/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.service.impl;

import com.marina.usermenagmentsystem.security.database.AccountRepository;
import com.marina.usermenagmentsystem.security.database.model.Account;
import com.marina.usermenagmentsystem.security.database.model.Privilege;
import com.marina.usermenagmentsystem.security.database.model.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {

        Account account = accountRepository.findByUsername(string);
        UserBuilder builder = null;
        if (account != null) {
            builder = User.withUsername(string);
            builder.disabled(!account.isEnabled());
            builder.password(account.getPassword());
            builder.authorities(getAuthorities(account.getRoles()));
        } else {
            throw new UsernameNotFoundException("User not found");
        }
        return builder.build();
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
//        return getGrantedAuthorities(getPrivileges(roles));
    }

//    private List<String> getPrivileges(Collection<Role> roles) {
//
//        List<String> privileges = new ArrayList<>();
//        List<Privilege> collection = new ArrayList<>();
//        for (Role role : roles) {
//            collection.addAll(role.getPrivileges());
//        }
//        for (Privilege item : collection) {
//            privileges.add(item.getName());
//        }
//        return privileges;
//    }
//
//    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (String privilege : privileges) {
//            authorities.add(new SimpleGrantedAuthority(privilege));
//        }
//        return authorities;
//    }
}
