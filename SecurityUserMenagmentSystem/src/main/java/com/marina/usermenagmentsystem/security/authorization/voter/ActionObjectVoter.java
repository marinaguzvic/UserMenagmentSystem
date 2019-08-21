/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.authorization.voter;

import com.marina.usermenagmentsystem.security.database.AccountRepository;
import com.marina.usermenagmentsystem.security.database.UrlActionObjectMappingRepository;
import com.marina.usermenagmentsystem.security.database.model.Account;
import com.marina.usermenagmentsystem.security.database.model.Privilege;
import com.marina.usermenagmentsystem.security.database.model.Role;
import com.marina.usermenagmentsystem.security.database.model.UrlActionObjectMapping;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

/**
 *
 * @author MARINA
 */
@Component
public class ActionObjectVoter implements AccessDecisionVoter<Object> {
    
    @Autowired
    public UrlActionObjectMappingRepository urlActionObjectMappingRepository;
    
    @Autowired
    public AccountRepository accountRepository;

    @Override
    public boolean supports(ConfigAttribute ca) {
        return true;
    }

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }

    @Override
    public int vote(Authentication a, Object s, Collection<ConfigAttribute> clctn) {
        String url = ((FilterInvocation)s).getRequestUrl();
        String method = ((FilterInvocation)s).getRequest().getMethod();
        String generalUrl = convertSpecificToGeneralUrl(url);
        UrlActionObjectMapping mapping = urlActionObjectMappingRepository.findByUrlAndMethod(generalUrl, method);
        if(mapping == null)return ACCESS_ABSTAIN;
        Account account = accountRepository.findByUsername(a.getName());
        if(account == null)return ACCESS_ABSTAIN;
        for (Role role : account.getRoles()) {
            for (Privilege privilege : role.getPrivileges()) {
                if((privilege.getActionPrivilege().equals(mapping.getActionPrivilege())
                        || privilege.getActionPrivilege().getName().equalsIgnoreCase("ANY_PRIVILEGE"))
                        && (privilege.getObjectPrivilege().equals(mapping.getObjectPrivilege())
                        || privilege.getObjectPrivilege().getName().equalsIgnoreCase("ANY"))){
                    return ACCESS_GRANTED;
                }
            }
        }
        return ACCESS_DENIED;
    }

    public String convertSpecificToGeneralUrl(String url){
        String newUrl = url.replaceAll("/\\d+/", "/{id}/");
        System.out.println(newUrl);
        return newUrl;
    }
}
