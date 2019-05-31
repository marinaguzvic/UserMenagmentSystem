/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service;

import com.marina.usermenagmentsystem.service.model.DocumentDTO;
import com.marina.usermenagmentsystem.service.model.PositionDTO;
import java.util.List;

/**
 *
 * @author MARINA
 */
public interface PositionService {
    public List<PositionDTO> getAll();
    public PositionDTO get(Long id);
    public PositionDTO update(PositionDTO user);
    public boolean delete(Long id);
    public PositionDTO insert(PositionDTO user);
}
