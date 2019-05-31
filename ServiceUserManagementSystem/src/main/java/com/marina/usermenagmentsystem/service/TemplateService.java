/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service;

import com.marina.usermenagmentsystem.service.model.TemplateDTO;
import java.util.List;

/**
 *
 * @author MARINA
 */
public interface TemplateService {
    public List<TemplateDTO> getAll();
    public TemplateDTO get(Long id);
    public TemplateDTO update(TemplateDTO user);
    public boolean delete(Long id);
    public TemplateDTO insert(TemplateDTO user);
}
