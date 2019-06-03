/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.mapper;

import com.marina.usermenagmentsystem.service.mapper.context.CycleAvoidingMappingContext;
import com.marina.usermenagmentsystem.data.model.Person;
import com.marina.usermenagmentsystem.service.model.PersonDTO;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author MARINA
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDTO toDtoModel(Person user, @Context CycleAvoidingMappingContext context);

    List<PersonDTO> toDtoModel(List<Person> users, @Context CycleAvoidingMappingContext context);

    Person toDataModel(PersonDTO userDto, @Context CycleAvoidingMappingContext context);

}
