/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.mapper.context;

import java.util.IdentityHashMap;
import java.util.Map;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;

/**
 *
 * @author MARINA
 */
public class CycleAvoidingMappingContext {

    private static CycleAvoidingMappingContext instance;
    private Map<Object, Object> knownInstances = new IdentityHashMap<Object, Object>();

    private CycleAvoidingMappingContext() {

    }

    public static CycleAvoidingMappingContext getInstance() {
        if (instance == null) {
            instance = new CycleAvoidingMappingContext();
        }
        return instance;
    }

    @BeforeMapping
    public <T> T getMappedInstance(Object source, @TargetType Class<T> targetType) {
        if(((T)knownInstances.get(source)) == null)return null;
        if(((T)knownInstances.get(source)).getClass() != targetType )return null;
        return (T) knownInstances.get(source);
    }

    @BeforeMapping
    public void storeMappedInstance(Object source, @MappingTarget Object target) {
        knownInstances.put(source, target);
    }
}
