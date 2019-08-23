/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.impl;

import com.marina.usermenagmentsystem.data.audit.repository.AuditRepository;
import com.marina.usermenagmentsystem.data.model.Document;
import com.marina.usermenagmentsystem.data.model.Person;
import com.marina.usermenagmentsystem.data.model.Template;
import com.marina.usermenagmentsystem.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author MARINA
 */
@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    @Qualifier("documentAuditRepository")
    AuditRepository documentAuditRepository;

    @Autowired
    @Qualifier("personAuditRepository")
    AuditRepository personAuditRepository;

    @Autowired
    @Qualifier("templateAuditRepository")
    AuditRepository templateAuditRepository;

    @Override
    public boolean checkIfUserHasCreatedEntity(String url, String username, String entityType) {
        return chooseRepository(entityType).checkIfUserHasCreatedEntity(url, username);

    }

    private AuditRepository chooseRepository(String entityType) {

        switch (entityType) {
            case "DOCUMENT": case "DOCUMENTS":
                return documentAuditRepository;
            case "TEMPLATE": case "TEMPLATES":
                return templateAuditRepository;
            case "USER": case "USERS":
                return personAuditRepository;
            default:
                return null;

        }
    }

}
