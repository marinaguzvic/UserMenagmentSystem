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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MARINA
 */
@Component("documentAuditRepository")
public class DocumentAuditRepositoryImpl extends AuditRepositoryImpl {


    @Override
    protected void extractIdFromUrl(String url) throws InvalidIdException {
        String split = "documents/";
        String[] urlParts = url.split(split);
        if (urlParts.length > 1) {
            String urlPart2 = urlParts[1];
            String[] urlPart2parts = urlPart2.split("/");
            String idString = urlPart2parts[0];
            Long id = Long.parseLong(idString);
            ((Document) object).setDocumentId(id);
        } else {
            throw new InvalidIdException("The id of the document can not be extracted from url");
        }
    }

    @Override
    protected void createObject() {
        object = new Document();
    }

    @Override
    protected void addEntitySpecificQueryAttributes(AuditQuery query) {
        query.add(AuditEntity.property("documentId").eq(((Document) object).getDocumentId()));
    }

}
