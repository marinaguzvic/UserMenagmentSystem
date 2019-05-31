/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.impl;

import com.marina.usermenagmentsystem.data.model.TemplateFieldPK;
import com.marina.usermenagmentsystem.data.repository.TemplateFieldRepository;
import com.marina.usermenagmentsystem.service.TemplateFieldService;
import com.marina.usermenagmentsystem.service.mapper.TemplateFieldMapper;
import com.marina.usermenagmentsystem.service.model.TemplateFieldDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MARINA
 */
@Service
public class TemplateFieldServiceImpl implements TemplateFieldService {

    @Autowired
    TemplateFieldRepository templateFieldRepository;
    @Autowired
    TemplateFieldMapper templateFieldMapper;

    @Override
    public List<TemplateFieldDTO> getAll(Long documentId) {
        return templateFieldMapper.toDtoModel(templateFieldRepository.findByTemplateFieldPKTemplateIdFk(documentId));
    }

    @Override
    public TemplateFieldDTO get(Long documentId, Integer id) {
        try {
            return templateFieldMapper.toDtoModel(templateFieldRepository.findById(new TemplateFieldPK(documentId, id)).get());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public TemplateFieldDTO update(TemplateFieldDTO document) {
        return templateFieldMapper.toDtoModel(templateFieldRepository.save(templateFieldMapper.toDataModel(document)));
    }

    @Override
    public boolean delete(Long documentId, Integer id) {
        try {
            templateFieldRepository.deleteById(new TemplateFieldPK(documentId, id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public TemplateFieldDTO insert(TemplateFieldDTO document) {
        return templateFieldMapper.toDtoModel(templateFieldRepository.save(templateFieldMapper.toDataModel(document)));
    }

}
