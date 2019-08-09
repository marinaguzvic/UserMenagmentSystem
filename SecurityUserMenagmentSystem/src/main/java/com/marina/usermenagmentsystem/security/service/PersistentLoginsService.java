/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.security.service;

import com.marina.usermenagmentsystem.security.database.model.PersistentLogins;
import java.util.List;

/**
 *
 * @author MARINA
 */
public interface PersistentLoginsService {

    public List<PersistentLogins> getAll();

    public PersistentLogins get(String id);

    public PersistentLogins update(PersistentLogins user);

    public boolean delete(String id);

    public PersistentLogins insert(PersistentLogins user);
}
