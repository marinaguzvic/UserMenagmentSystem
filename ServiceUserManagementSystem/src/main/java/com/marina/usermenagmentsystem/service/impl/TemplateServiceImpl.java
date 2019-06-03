/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.impl;

import com.marina.usermenagmentsystem.data.model.Template;
import com.marina.usermenagmentsystem.data.model.TemplateField;
import com.marina.usermenagmentsystem.data.repository.TemplateRepository;
import com.marina.usermenagmentsystem.service.TemplateService;
import com.marina.usermenagmentsystem.service.mapper.context.CycleAvoidingMappingContext;
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
        List<Template> templates = templateRepository.findAll();
        return templateMapper.toDtoModel(templates,CycleAvoidingMappingContext.getInstance());
    }

    @Override
    public TemplateDTO get(Long id) {
        try {
            Template template = templateRepository.findById(id).get();
            return templateMapper.toDtoModel(template,CycleAvoidingMappingContext.getInstance());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public TemplateDTO update(TemplateDTO user) {
        Template template = templateRepository.save(templateMapper.toDataModel(user,CycleAvoidingMappingContext.getInstance()));
        return templateMapper.toDtoModel(template,CycleAvoidingMappingContext.getInstance());
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
        try {
            Long id = generateNewId();
            Template template = templateMapper.toDataModel(user,CycleAvoidingMappingContext.getInstance());
            template.setTemplateId(id);
            for (TemplateField templateField : template.getTemplateFieldList()) {
                templateField.setTemplate(template);
                templateField.getTemplateFieldPK().setTemplateIdFk(id);
            }
            template = templateRepository.save(template);
            return templateMapper.toDtoModel(template,CycleAvoidingMappingContext.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private Long generateNewId() {
        List<Template> templates = templateRepository.findAll();
        Long id = 0l;
        for (Template template : templates) {
            if (template.getTemplateId() > id) {
                id = template.getTemplateId();
            }
        }
        return ++id;
    }
}
