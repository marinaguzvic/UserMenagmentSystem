/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.mapper;

import com.marina.usermenagmentsystem.data.model.DocumentField;
import com.marina.usermenagmentsystem.data.model.DocumentFieldPK;
import com.marina.usermenagmentsystem.service.mapper.context.CycleAvoidingMappingContext;
import com.marina.usermenagmentsystem.service.mapper.context.ValueFactory;
import com.marina.usermenagmentsystem.service.model.DocumentFieldDTO;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author MARINA
 */
@Mapper(uses = {DocumentMapper.class, TemplateFieldMapper.class}, componentModel = "spring")
public abstract class DocumentFieldMapper {
    
    @Autowired
    TemplateFieldMapper templateFieldMapper;
    @Autowired
    ValueFactory valueFactory;
//    @Mappings({
//        @Mapping(target = "documentId", source = "documentField.documentFieldPK.documentIdFk"),
//        @Mapping(target = "documentFieldId", source = "documentField.documentFieldPK.fieldId")
//    })
//    DocumentFieldDTO toDtoModel(DocumentField documentField, @Context CycleAvoidingMappingContext context);

    public abstract List<DocumentFieldDTO> toDtoModel(List<DocumentField> documents, @Context CycleAvoidingMappingContext context);
    
    public abstract List<DocumentField> toDataModel(List<DocumentFieldDTO> documents, @Context CycleAvoidingMappingContext context);
//    @Mappings({
//        @Mapping(target = "documentFieldPK.documentIdFk", source = "documentField.documentId"),
//        @Mapping(target = "documentFieldPK.fieldId", source = "documentField.documentFieldId")
//    })

    public DocumentField toDataModel(DocumentFieldDTO documentField, @Context CycleAvoidingMappingContext context) throws ParseException {
        DocumentField target = context.getMappedInstance(documentField, DocumentField.class);
        if (target != null) {
            return target;
        }
        
        if (documentField == null) {
            return null;
        }
        
        DocumentField documentField1 = new DocumentField();
        
        context.storeMappedInstance(documentField, documentField1);
        documentField1.setTemplateField(templateFieldMapper.toDataModel(documentField.getTemplateField(), context));
        valueFactory.setValue(documentField.getFieldValue(), documentField1);
        documentField1.setDocumentFieldPK(new DocumentFieldPK(documentField.getDocumentId(), documentField.getDocumentFieldId()));
        
        
        return documentField1;
    }
    
    public DocumentFieldDTO toDtoModel(DocumentField documentField, @Context CycleAvoidingMappingContext context) {
        DocumentFieldDTO target = context.getMappedInstance(documentField, DocumentFieldDTO.class);
        if (target != null) {
            return target;
        }
        
        if (documentField == null) {
            return null;
        }
        
        DocumentFieldDTO documentFieldDTO = new DocumentFieldDTO();
        
        context.storeMappedInstance(documentField, documentFieldDTO);
        
        documentFieldDTO.setDocumentFieldId(documentField.getDocumentFieldPK().getFieldId());
        documentFieldDTO.setDocumentId(documentField.getDocumentFieldPK().getDocumentIdFk());
        documentFieldDTO.setTemplateField(templateFieldMapper.toDtoModel(documentField.getTemplateField(), context));
        documentFieldDTO.setFieldValue(valueFactory.toValueDTO(documentField));
        
        return documentFieldDTO;
    }
}
