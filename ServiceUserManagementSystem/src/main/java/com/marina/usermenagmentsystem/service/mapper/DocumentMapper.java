/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.mapper;

import com.marina.usermenagmentsystem.data.model.Document;
import com.marina.usermenagmentsystem.service.mapper.context.CycleAvoidingMappingContext;
import com.marina.usermenagmentsystem.service.model.DocumentDTO;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

/**
 *
 * @author MARINA
 */

@Mapper(uses = DocumentFieldMapper.class, componentModel = "spring")
public interface DocumentMapper {

    DocumentDTO toDtoModel(Document document, @Context CycleAvoidingMappingContext context);

    List<DocumentDTO> toDtoModel(List<Document> documents, @Context CycleAvoidingMappingContext context);
    List<Document> toDataModel(List<DocumentDTO> documents, @Context CycleAvoidingMappingContext context);
    
    Document toDataModel(DocumentDTO document, @Context CycleAvoidingMappingContext context);
}
