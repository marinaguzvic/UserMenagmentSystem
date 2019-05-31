/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.validator;

import com.marina.usermenagmentsystem.service.PersonService;
import com.marina.usermenagmentsystem.service.model.PersonDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author MARINA
 */
@Component("emailUniqueValidator")
public class EmailUniqueValidator {

    @Autowired
    PersonService personService;
    
    public boolean valid(Long id, String email){
        List<PersonDTO> persons = personService.getAll();
        for (PersonDTO person : persons) {
            if(person.getId() != id && person.getEmail().equalsIgnoreCase(email))return false;
        }
        return true;
    }
}
