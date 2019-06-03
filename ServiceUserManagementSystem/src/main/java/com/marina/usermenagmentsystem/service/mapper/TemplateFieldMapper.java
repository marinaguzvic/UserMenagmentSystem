/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.mapper;

import com.marina.usermenagmentsystem.data.model.EnumFieldType;
import com.marina.usermenagmentsystem.service.mapper.context.CycleAvoidingMappingContext;
import com.marina.usermenagmentsystem.data.model.TemplateField;
import com.marina.usermenagmentsystem.data.model.TemplateFieldPK;
import com.marina.usermenagmentsystem.service.model.TemplateFieldDTO;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author MARINA
 */
@Mapper(uses = TemplateMapper.class, componentModel = "spring")
public interface TemplateFieldMapper {

    @Mappings({
        @Mapping(target = "templateId", source = "templateField.templateFieldPK.templateIdFk")
        ,
        @Mapping(target = "templateFieldId", source = "templateField.templateFieldPK.templateFieldId")
    })
    TemplateFieldDTO toDtoModel(TemplateField templateField, @Context CycleAvoidingMappingContext context);

    List<TemplateFieldDTO> toDtoModel(List<TemplateField> templateFields, @Context CycleAvoidingMappingContext context);

    List<TemplateField> toDataModel(List<TemplateFieldDTO> templateFields, @Context CycleAvoidingMappingContext context);

    @Mappings({
        @Mapping(target = "templateFieldPK.templateIdFk", source = "templateField.templateId")
        ,
        @Mapping(target = "templateFieldPK.templateFieldId", source = "templateField.templateFieldId")
    })
    TemplateField toDataModel(TemplateFieldDTO templateField, @Context CycleAvoidingMappingContext context);

//    @Named("toDataModel")
//    default TemplateField toDataModel(TemplateFieldDTO templateField, CycleAvoidingMappingContext context) {
//        TemplateField target = context.getMappedInstance(templateField, TemplateField.class);
//        if (target != null) {
//            return target;
//        }
//
//        if (templateField == null) {
//            return null;
//        }
//
//        TemplateField templateField1 = new TemplateField();
//
//        context.storeMappedInstance(templateField, templateField1);
//
//        templateField1.setTemplateFieldPK(new TemplateFieldPK(templateField.getTemplateId(), templateField.getTemplateFieldId()));
//        templateField1.setTemplateFieldName(templateField.getTemplateFieldName());
//        if (templateField.getTemplateFieldType() != null) {
//            templateField1.setTemplateFieldType(Enum.valueOf(EnumFieldType.class, templateField.getTemplateFieldType()));
//        }
//
//        return templateField1;
//    }
}
