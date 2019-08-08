/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.token;

import com.marina.usermenagmentsystem.database.PersistentLoginsRepository;
import com.marina.usermenagmentsystem.database.model.PersistentLogins;
import com.marina.usermenagmentsystem.database.service.PersistentLoginsService;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MARINA
 */
@Repository("persistentLoginsRepository")
@Transactional(transactionManager = "securityTransactionManager")
public class PersistentLoginsTokenRepositoryImp implements PersistentTokenRepository{
    
    @Autowired
    private PersistentLoginsRepository persistentLoginsRepository;

    
    @Override
    public void createNewToken(PersistentRememberMeToken prmt) {
        PersistentLogins persistentLogins = new PersistentLogins();
        persistentLogins.setUsername(prmt.getUsername());
        persistentLogins.setSeries(prmt.getSeries());
        persistentLogins.setToken(prmt.getTokenValue());
        persistentLogins.setLastUsed(prmt.getDate());
        persistentLoginsRepository.save(persistentLogins);
    }

    @Override
    public void updateToken(String series, String token, Date date) {
        PersistentLogins persistentLogins = persistentLoginsRepository.findById(series).get();
        persistentLogins.setToken(token);
        persistentLogins.setLastUsed(date);
        persistentLoginsRepository.save(persistentLogins);
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String series) {
        PersistentLogins persistentLogins = persistentLoginsRepository.findById(series).get();
        if(persistentLogins != null){
            return new PersistentRememberMeToken(persistentLogins.getUsername(), persistentLogins.getSeries(), persistentLogins.getToken(), persistentLogins.getLastUsed());
        }
        return null;
    }

    @Override
    public void removeUserTokens(String string) {
        persistentLoginsRepository.deleteByUsername(string);
    }
    
}
