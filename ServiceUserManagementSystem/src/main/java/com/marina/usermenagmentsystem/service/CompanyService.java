/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service;

import com.marina.usermenagmentsystem.service.model.AccountDTO;
import com.marina.usermenagmentsystem.service.model.CompanyDTO;
import java.util.List;

/**
 *
 * @author MARINA
 */
public interface CompanyService {
    public List<CompanyDTO> getAll();
    public CompanyDTO get(Long id);
    public CompanyDTO update(CompanyDTO user);
    public boolean delete(Long id);
    public CompanyDTO insert(CompanyDTO user);
}
