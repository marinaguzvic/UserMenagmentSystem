/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.impl;

import com.marina.usermenagmentsystem.data.repository.TemplateRepository;
import com.marina.usermenagmentsystem.service.TemplateService;
import com.marina.usermenagmentsystem.service.mapper.TemplateMapper;
import com.marina.usermenagmentsystem.service.model.TemplateDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MARINA
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    TemplateRepository templateRepository;
    @Autowired
    TemplateMapper templateMapper;

    @Override
    public List<TemplateDTO> getAll() {
        return templateMapper.toDtoModel(templateRepository.findAll());
    }

    @Override
    public TemplateDTO get(Long id) {
        try {
            return templateMapper.toDtoModel(templateRepository.findById(id).get());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public TemplateDTO update(TemplateDTO user) {
        return templateMapper.toDtoModel(templateRepository.save(templateMapper.toDataModel(user)));
    }

    @Override
    public boolean delete(Long id) {
    try {
            templateRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public TemplateDTO insert(TemplateDTO user) {
        return templateMapper.toDtoModel(templateRepository.save(templateMapper.toDataModel(user)));
    }

}
