/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.data.audit.repository.impl;

import com.marina.usermenagmentsystem.data.audit.exception.InvalidIdException;
import com.marina.usermenagmentsystem.data.model.Person;
import com.marina.usermenagmentsystem.data.model.Template;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MARINA
 */
@Component("templateAuditRepository")
public class TemplateAuditRepositoryImpl extends AuditRepositoryImpl {

    @Override
    protected void extractIdFromUrl(String url) throws InvalidIdException {
        String split = "templates/";
        String[] urlParts = url.split(split);
        if (urlParts.length > 1) {
            String urlPart2 = urlParts[1];
            String[] urlPart2parts = urlPart2.split("/");
            String idString = urlPart2parts[0];
            try {
                Long id = Long.parseLong(idString);
                ((Template) object).setTemplateId(id);
            } catch (Exception e) {
                throw new InvalidIdException("The id of the template can not be extracted from url");
            }

        } else {
            throw new InvalidIdException("The id of the template can not be extracted from url");
        }
    }

    @Override
    protected void createObject() {
        object = new Template();
    }

    @Override
    protected void addEntitySpecificQueryAttributes(AuditQuery query) {
        query.add(AuditEntity.property("templateId").eq(((Template) object).getTemplateId()));
    }

}
