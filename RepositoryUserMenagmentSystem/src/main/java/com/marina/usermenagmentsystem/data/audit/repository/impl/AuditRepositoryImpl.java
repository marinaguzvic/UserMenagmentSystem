/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.data.audit.repository.impl;

import com.marina.usermenagmentsystem.data.audit.exception.InvalidIdException;
import com.marina.usermenagmentsystem.data.audit.repository.AuditRepository;
import com.marina.usermenagmentsystem.data.model.Document;
import com.marina.usermenagmentsystem.data.model.revision.AuditRevisionEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author MARINA
 */
public abstract class AuditRepositoryImpl implements AuditRepository {

    @Autowired
    @Qualifier("entityManagerFactory")
    EntityManagerFactory entityManagerFactory;

    protected Object object;

    @Override
    public boolean checkIfUserHasCreatedEntity(String url, String username) {
        createObject();
        try {
            extractIdFromUrl(url);
        } catch (InvalidIdException ex) {
            return false;
        }
        AuditReader reader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        AuditQuery query = reader.createQuery().
                forRevisionsOfEntity(object.getClass(), false).add(AuditEntity.revisionType().eq(RevisionType.ADD));
        addEntitySpecificQueryAttributes(query);
        query.addOrder(AuditEntity.revisionNumber().asc());
        AuditRevisionEntity auditRevisionEntity = (AuditRevisionEntity) query.getSingleResult();
        String user = auditRevisionEntity.getUsername();
        if (user.equals(username)) {
            return true;
        } else {
            return false;
        }
    }

    protected abstract void extractIdFromUrl(String url) throws InvalidIdException;

    protected abstract void createObject();

    protected abstract void addEntitySpecificQueryAttributes(AuditQuery query);
}
