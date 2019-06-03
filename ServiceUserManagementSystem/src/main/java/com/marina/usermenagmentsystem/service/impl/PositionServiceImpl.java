/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.impl;

import com.marina.usermenagmentsystem.data.repository.PositionRepository;
import com.marina.usermenagmentsystem.service.PositionService;
import com.marina.usermenagmentsystem.service.mapper.context.CycleAvoidingMappingContext;
import com.marina.usermenagmentsystem.service.mapper.PositionMapper;
import com.marina.usermenagmentsystem.service.model.PositionDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MARINA
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    PositionRepository positionRepository;
    @Autowired
    PositionMapper positionMapper;

    @Override
    public List<PositionDTO> getAll() {
        return positionMapper.toDtoModel(positionRepository.findAll(),CycleAvoidingMappingContext.getInstance());
    }

    @Override
    public PositionDTO get(Long id) {
        try {
            return positionMapper.toDtoModel(positionRepository.findById(id).get(),CycleAvoidingMappingContext.getInstance());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PositionDTO update(PositionDTO user) {
        return positionMapper.toDtoModel(positionRepository.save(positionMapper.toDataModel(user, CycleAvoidingMappingContext.getInstance())), CycleAvoidingMappingContext.getInstance());
    }

    @Override
    public boolean delete(Long id) {
        try {
            positionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public PositionDTO insert(PositionDTO user) {
        return positionMapper.toDtoModel(positionRepository.save(positionMapper.toDataModel(user, CycleAvoidingMappingContext.getInstance())), CycleAvoidingMappingContext.getInstance());
    }

}
