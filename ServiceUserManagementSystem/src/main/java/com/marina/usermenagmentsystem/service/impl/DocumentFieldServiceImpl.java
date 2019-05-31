/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.impl;

import com.marina.usermenagmentsystem.data.model.DocumentFieldPK;
import com.marina.usermenagmentsystem.data.repository.DocumentFieldRepository;
import com.marina.usermenagmentsystem.service.DocumentFieldService;
import com.marina.usermenagmentsystem.service.mapper.DocumentFieldMapper;
import com.marina.usermenagmentsystem.service.mapper.DocumentMapper;
import com.marina.usermenagmentsystem.service.model.DocumentFieldDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MARINA
 */
@Service
public class DocumentFieldServiceImpl implements DocumentFieldService {

    @Autowired
    DocumentFieldRepository documentFieldRepository;
    @Autowired
    DocumentFieldMapper documentFieldMapper;

    @Override
    public List<DocumentFieldDTO> getAll(Long documentId) {
        return documentFieldMapper.toDtoModel(documentFieldRepository.findByDocumentFieldPKDocumentIdFk(documentId));
    }

    @Override
    public DocumentFieldDTO get(Long documentId, Integer id) {
        try {
            return documentFieldMapper.toDtoModel(documentFieldRepository.findById(new DocumentFieldPK(documentId, id)).get());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public DocumentFieldDTO update(DocumentFieldDTO document) {
        return documentFieldMapper.toDtoModel(documentFieldRepository.save(documentFieldMapper.toDataModel(document)));
    }

    @Override
    public boolean delete(Long documentId, Integer id) {
        try {
            documentFieldRepository.deleteById(new DocumentFieldPK(documentId, id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public DocumentFieldDTO insert(DocumentFieldDTO document) {
         return documentFieldMapper.toDtoModel(documentFieldRepository.save(documentFieldMapper.toDataModel(document)));
    }

}
