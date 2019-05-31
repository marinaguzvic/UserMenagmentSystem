/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service;

import com.marina.usermenagmentsystem.service.model.DocumentFieldDTO;
import com.marina.usermenagmentsystem.service.model.TemplateFieldDTO;
import java.util.List;

/**
 *
 * @author MARINA
 */
public interface TemplateFieldService {

    public List<TemplateFieldDTO> getAll(Long documentId);

    public TemplateFieldDTO get(Long documentId, Integer id);

    public TemplateFieldDTO update(TemplateFieldDTO document);

    public boolean delete(Long documentId, Integer id);

    public TemplateFieldDTO insert(TemplateFieldDTO document);

}
