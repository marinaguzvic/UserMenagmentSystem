/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.impl;

import com.marina.usermenagmentsystem.data.model.Document;
import com.marina.usermenagmentsystem.data.model.DocumentField;
import com.marina.usermenagmentsystem.data.repository.DocumentRepository;
import com.marina.usermenagmentsystem.service.DocumentService;
import com.marina.usermenagmentsystem.service.mapper.DocumentMapper;
import com.marina.usermenagmentsystem.service.mapper.context.CycleAvoidingMappingContext;
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
        List<Document> documents = documentRepository.findAll();
        return documentMapper.toDtoModel(documents, CycleAvoidingMappingContext.getInstance());
    }

    @Override
    public DocumentDTO get(Long id) {
        try {
            Document document = documentRepository.findById(id).get();
            return documentMapper.toDtoModel(document, CycleAvoidingMappingContext.getInstance());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public DocumentDTO update(DocumentDTO user) {
        Document document = documentRepository.save(documentMapper.toDataModel(user, CycleAvoidingMappingContext.getInstance()));
        return documentMapper.toDtoModel(document, CycleAvoidingMappingContext.getInstance());
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
        try {
            Long id = generateNewId();
            Document document = documentMapper.toDataModel(user, CycleAvoidingMappingContext.getInstance());
            document.setDocumentId(id);
            for (DocumentField documentField : document.getDocumentFieldList()) {
                documentField.setDocument(document);
                documentField.getDocumentFieldPK().setDocumentIdFk(id);
            }
            document = documentRepository.save(document);
            return documentMapper.toDtoModel(document, CycleAvoidingMappingContext.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Long generateNewId() {
        List<Document> documents = documentRepository.findAll();
        Long id = 0l;
        for (Document document : documents) {
            if (document.getDocumentId() > id) {
                id = document.getDocumentId();
            }
        }
        return ++id;
    }
}
