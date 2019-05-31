/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service;

import com.marina.usermenagmentsystem.service.model.PersonDTO;
import java.util.List;

/**
 *
 * @author MARINA
 */
public interface PersonService {
    public List<PersonDTO> getAll();
    public PersonDTO get(Long id);
    public PersonDTO update(PersonDTO user);
    public boolean delete(Long id);
    public PersonDTO insert(PersonDTO user);
}
