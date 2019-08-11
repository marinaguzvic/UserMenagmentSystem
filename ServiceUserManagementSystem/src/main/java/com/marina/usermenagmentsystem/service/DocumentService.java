/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service;

import com.marina.usermenagmentsystem.service.model.DocumentDTO;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author MARINA
 */
public interface DocumentService {
    public List<DocumentDTO> getAll();
    public DocumentDTO get(Long id);
    public DocumentDTO update(DocumentDTO user);
    public boolean delete(Long id);
    public DocumentDTO insert(DocumentDTO user);
}
