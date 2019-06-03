/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.mapper;

import com.marina.usermenagmentsystem.service.mapper.context.CycleAvoidingMappingContext;
import com.marina.usermenagmentsystem.data.model.Template;
import com.marina.usermenagmentsystem.service.model.TemplateDTO;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;

/**
 *
 * @author MARINA
 */
@Mapper(uses = TemplateFieldMapper.class, componentModel = "spring")
public interface TemplateMapper {
//        @Mappings({
//        @Mapping(target = "templateId", source = "templateField.templateFieldPK.templateIdFk"),
//        @Mapping(target = "templateFieldId", source = "templateField.templateFieldPK.templateFieldId")
//    })

    TemplateDTO toDtoModel(Template template, @Context CycleAvoidingMappingContext context);

    List<TemplateDTO> toDtoModel(List<Template> templates, @Context CycleAvoidingMappingContext context);

    List<Template> toDataModel(List<TemplateDTO> templates, @Context CycleAvoidingMappingContext context);
//    @Mappings({
//        @Mapping(target = "templateFieldPK.templateIdFk", source = "templateField.templateId"),
//        @Mapping(target = "templateFieldPK.templateFieldId", source = "templateField.templateFieldId")
//    })

    Template toDataModel(TemplateDTO templateField, @Context CycleAvoidingMappingContext context);



}
