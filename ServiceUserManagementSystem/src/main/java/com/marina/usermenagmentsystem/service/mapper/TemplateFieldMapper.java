/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.mapper;

import com.marina.usermenagmentsystem.data.model.TemplateField;
import com.marina.usermenagmentsystem.service.model.TemplateFieldDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author MARINA
 */

@Mapper(componentModel = "spring")
public interface TemplateFieldMapper {
    @Mappings({
        @Mapping(target = "templateId", source = "templateField.templateFieldPK.templateIdFk"),
        @Mapping(target = "templateFieldId", source = "templateField.templateFieldPK.templateFieldId")
    })
     TemplateFieldDTO toDtoModel(TemplateField templateField);

    List<TemplateFieldDTO> toDtoModel(List<TemplateField> templateFields);
    List<TemplateField> toDataModel(List<TemplateFieldDTO> templateFields);
    
    @Mappings({
        @Mapping(target = "templateFieldPK.templateIdFk", source = "templateField.templateId"),
        @Mapping(target = "templateFieldPK.templateFieldId", source = "templateField.templateFieldId")
    })
    TemplateField toDataModel(TemplateFieldDTO templateField);
}
