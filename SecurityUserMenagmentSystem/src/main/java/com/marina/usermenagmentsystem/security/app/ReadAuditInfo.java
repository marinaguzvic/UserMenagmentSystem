/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.app;

/**
 *
 * @author MARINA
 */
public interface ReadAuditInfo {
    public boolean hasCreatedEntity(String url, String username, String entityType);
}
