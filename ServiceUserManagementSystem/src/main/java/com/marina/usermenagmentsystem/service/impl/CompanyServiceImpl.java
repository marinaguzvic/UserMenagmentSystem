/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.impl;

import com.marina.usermenagmentsystem.data.repository.CompanyRepository;
import com.marina.usermenagmentsystem.service.CompanyService;
import com.marina.usermenagmentsystem.service.mapper.CompanyMapper;
import com.marina.usermenagmentsystem.service.mapper.context.CycleAvoidingMappingContext;
import com.marina.usermenagmentsystem.service.model.CompanyDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MARINA
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CompanyMapper companyMapper;

    @Override
    public List<CompanyDTO> getAll() {
        return companyMapper.toDtoModel(companyRepository.findAll(), CycleAvoidingMappingContext.getInstance());
    }

    @Override
    public CompanyDTO get(Long id) {
        try {
            return companyMapper.toDtoModel(companyRepository.findById(id).get(), CycleAvoidingMappingContext.getInstance());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public CompanyDTO update(CompanyDTO user) {
        return companyMapper.toDtoModel(companyRepository.save(companyMapper.toDataModel(user, CycleAvoidingMappingContext.getInstance())), CycleAvoidingMappingContext.getInstance());
    }

    @Override
    public boolean delete(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public CompanyDTO insert(CompanyDTO user) {
        return companyMapper.toDtoModel(companyRepository.save(companyMapper.toDataModel(user, CycleAvoidingMappingContext.getInstance())), CycleAvoidingMappingContext.getInstance());
    }

}
