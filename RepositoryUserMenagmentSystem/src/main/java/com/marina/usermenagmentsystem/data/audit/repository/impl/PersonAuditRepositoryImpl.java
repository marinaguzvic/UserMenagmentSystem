/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.data.audit.repository.impl;

import com.marina.usermenagmentsystem.data.audit.exception.InvalidIdException;
import com.marina.usermenagmentsystem.data.model.Document;
import com.marina.usermenagmentsystem.data.model.Person;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MARINA
 */
@Component("personAuditRepository")
public class PersonAuditRepositoryImpl extends AuditRepositoryImpl {

    @Override
    protected void extractIdFromUrl(String url) throws InvalidIdException {
        String split = "users/";
        String[] urlParts = url.split(split);
        if (urlParts.length > 1) {
            String urlPart2 = urlParts[1];
            String[] urlPart2parts = urlPart2.split("/");
            String idString = urlPart2parts[0];
            try {
                Long id = Long.parseLong(idString);
                ((Person) object).setId(id);
            } catch (Exception e) {
                throw new InvalidIdException("The id of the person can not be extracted from url");
            }

        } else {
            throw new InvalidIdException("The id of the person can not be extracted from url");
        }
    }

    @Override
    protected void createObject() {
        object = new Person();
    }

    @Override
    protected void addEntitySpecificQueryAttributes(AuditQuery query) {
        query.add(AuditEntity.property("id").eq(((Person) object).getId()));
    }

}
