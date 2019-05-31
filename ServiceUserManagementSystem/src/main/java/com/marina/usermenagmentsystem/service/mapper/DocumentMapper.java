/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.mapper;

import com.marina.usermenagmentsystem.data.model.Document;
import com.marina.usermenagmentsystem.service.model.DocumentDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author MARINA
 */

@Mapper(componentModel = "spring")
public interface DocumentMapper {
//    @Mappings({
//        @Mapping(target = "documentID", source = "documentField.documentFieldPK.documentIdFk"),
//        @Mapping(target = "documentFieldID", source = "documentField.documentFieldPK.fieldId")
//    })
    DocumentDTO toDtoModel(Document document);

    List<DocumentDTO> toDtoModel(List<Document> documents);
    List<Document> toDataModel(List<DocumentDTO> documents);
    
    Document toDataModel(DocumentDTO document);
}
