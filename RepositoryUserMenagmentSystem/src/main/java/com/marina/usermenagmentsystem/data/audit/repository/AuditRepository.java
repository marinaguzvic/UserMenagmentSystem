/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.data.audit.repository;

/**
 *
 * @author MARINA
 */
public interface AuditRepository {
    boolean checkIfUserHasCreatedEntity(String url, String username);
}
