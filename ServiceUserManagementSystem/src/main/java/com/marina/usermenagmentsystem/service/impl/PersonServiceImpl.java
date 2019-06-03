/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.impl;

import com.marina.usermenagmentsystem.data.model.Person;
import com.marina.usermenagmentsystem.data.repository.PersonRepository;
import com.marina.usermenagmentsystem.service.model.PersonDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marina.usermenagmentsystem.service.mapper.PersonMapper;
import com.marina.usermenagmentsystem.service.PersonService;
import com.marina.usermenagmentsystem.service.mapper.context.CycleAvoidingMappingContext;

/**
 *
 * @author MARINA
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<PersonDTO> getAll() {
        List<Person> persons = personRepository.findAll();
        return personMapper.toDtoModel(persons,CycleAvoidingMappingContext.getInstance());
    }

    @Override
    public PersonDTO get(Long id) {
        try {
            Person person = personRepository.findById(id).get();
            return personMapper.toDtoModel(person,CycleAvoidingMappingContext.getInstance());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {
        Person person = personRepository.save(personMapper.toDataModel(personDTO,CycleAvoidingMappingContext.getInstance()));
        return personMapper.toDtoModel(person,CycleAvoidingMappingContext.getInstance());
    }

    @Override
    public boolean delete(Long id) {
        try {
            personRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public PersonDTO insert(PersonDTO personDTO) {
        Person person = personRepository.save(personMapper.toDataModel(personDTO,CycleAvoidingMappingContext.getInstance()));
        return personMapper.toDtoModel(person,CycleAvoidingMappingContext.getInstance());
   }
}
