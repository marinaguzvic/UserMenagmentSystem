/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.impl;

import com.marina.usermenagmentsystem.data.repository.DocumentRepository;
import com.marina.usermenagmentsystem.service.DocumentService;
import com.marina.usermenagmentsystem.service.mapper.DocumentMapper;
import com.marina.usermenagmentsystem.service.model.DocumentDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MARINA
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    DocumentMapper documentMapper;

    @Override
    public List<DocumentDTO> getAll() {
        return documentMapper.toDtoModel(documentRepository.findAll());
    }

    @Override
    public DocumentDTO get(Long id) {
        try {
            return documentMapper.toDtoModel(documentRepository.findById(id).get());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public DocumentDTO update(DocumentDTO user) {
        return documentMapper.toDtoModel(documentRepository.save(documentMapper.toDataModel(user)));
    }

    @Override
    public boolean delete(Long id) {
        try {
            documentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public DocumentDTO insert(DocumentDTO user) {
        return documentMapper.toDtoModel(documentRepository.save(documentMapper.toDataModel(user)));
    }

}
