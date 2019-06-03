/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.mapper;

import com.marina.usermenagmentsystem.service.mapper.context.CycleAvoidingMappingContext;
import com.marina.usermenagmentsystem.data.model.Company;
import com.marina.usermenagmentsystem.service.model.CompanyDTO;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

/**
 *
 * @author MARINA
 */
@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyDTO toDtoModel(Company company, @Context CycleAvoidingMappingContext context);

    List<CompanyDTO> toDtoModel(List<Company> companies, @Context CycleAvoidingMappingContext context);

    Company toDataModel(CompanyDTO company, @Context CycleAvoidingMappingContext context);
}
