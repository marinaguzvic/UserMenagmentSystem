/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.mapper;

import com.marina.usermenagmentsystem.data.model.DocumentField;
import com.marina.usermenagmentsystem.service.model.DocumentFieldDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author MARINA
 */
@Mapper(componentModel = "spring")
public interface DocumentFieldMapper {

    @Mappings({
        @Mapping(target = "documentId", source = "documentField.documentFieldPK.documentIdFk"),
        @Mapping(target = "documentFieldId", source = "documentField.documentFieldPK.fieldId")
    })
    DocumentFieldDTO toDtoModel(DocumentField documentField);

    List<DocumentFieldDTO> toDtoModel(List<DocumentField> documents);
    List<DocumentField> toDataModel(List<DocumentFieldDTO> documents);
    @Mappings({
        @Mapping(target = "documentFieldPK.documentIdFk", source = "documentField.documentId"),
        @Mapping(target = "documentFieldPK.fieldId", source = "documentField.documentFieldId")
    })
    DocumentField toDataModel(DocumentFieldDTO documentField);
}
