/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service;

import com.marina.usermenagmentsystem.service.model.DocumentDTO;
import com.marina.usermenagmentsystem.service.model.DocumentFieldDTO;
import java.util.List;

/**
 *
 * @author MARINA
 */
public interface DocumentFieldService {
    public List<DocumentFieldDTO> getAll(Long documentId);
    public DocumentFieldDTO get(Long documentId, Integer id);
    public DocumentFieldDTO update(DocumentFieldDTO document);
    public boolean delete(Long documentId, Integer id);
    public DocumentFieldDTO insert(DocumentFieldDTO document);
}
