/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.mapper;

import com.marina.usermenagmentsystem.data.model.Position;
import com.marina.usermenagmentsystem.service.model.PositionDTO;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

/**
 *
 * @author MARINA
 */
@Mapper(componentModel = "spring")
public interface PositionMapper {

    PositionDTO toDtoModel(Position position, @Context CycleAvoidingMappingContext context);

    List<PositionDTO> toDtoModel(List<Position> positions, @Context CycleAvoidingMappingContext context);

    Position toDataModel(PositionDTO position, @Context CycleAvoidingMappingContext context);
}
