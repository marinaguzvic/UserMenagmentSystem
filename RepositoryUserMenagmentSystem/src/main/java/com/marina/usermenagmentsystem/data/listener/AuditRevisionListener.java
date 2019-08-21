/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.data.listener;

import com.marina.usermenagmentsystem.data.model.revision.AuditRevisionEntity;
import com.marina.usermenagmentsystem.security.app.Security;
import org.hibernate.envers.RevisionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author MARINA
 */
@Component
public class AuditRevisionListener implements RevisionListener{
    @Autowired
    Security security;

    @Override
    public void newRevision(Object o) {
        AuditRevisionEntity entity = (AuditRevisionEntity)o;
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        entity.setUsername(name);
    }
    
}
