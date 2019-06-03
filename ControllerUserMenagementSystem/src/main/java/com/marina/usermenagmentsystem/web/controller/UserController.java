/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.controller;

import com.marina.usermenagmentsystem.service.CompanyService;
import com.marina.usermenagmentsystem.service.model.PersonDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.marina.usermenagmentsystem.service.PersonService;
import com.marina.usermenagmentsystem.service.PositionService;
import com.marina.usermenagmentsystem.service.model.CompanyDTO;
import com.marina.usermenagmentsystem.service.model.PositionDTO;
import com.marina.usermenagmentsystem.web.validator.PersonFormValidator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author MARINA
 */
//@Transactional
@Controller
@RequestMapping(value = "/users")
public class UserController {


    @Autowired
    private PersonService personService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    PersonFormValidator personFormValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.setValidator(personFormValidator);
    }

    @GetMapping
    public ModelAndView all() {
        List<PersonDTO> persons = personService.getAll();
        ModelAndView mv = new ModelAndView("persons");
        mv.addObject("persons", persons);
        return mv;
    }

    @GetMapping(value = "/add")
    public ModelAndView add() {
        List<CompanyDTO> companies = companyService.getAll();
        ModelAndView mv = new ModelAndView("new-person");
        mv.addObject("person", new PersonDTO());
        mv.addObject("companies", companies);
        mv.addObject("action", "/usermgmt/users");
        return mv;
    }

    @PostMapping
    @ResponseBody
    public ModelAndView insert(@ModelAttribute("person") @Validated PersonDTO person, BindingResult result) {
        List<CompanyDTO> companies = companyService.getAll();
        ModelAndView mv = new ModelAndView("view-person", result.getModel());
        mv.addObject("companies", companies);
        if (result.hasErrors()) {
            mv.addObject("person", person);
            mv.addObject("action", "/usermgmt/users");
            populateErrorCss(result, mv);
            return mv;
        } else {
            mv.addObject("css", "success");
            mv.addObject("msg", "Person added successfully!");
        }
        person = personService.insert(person);
        mv.addObject("person", person);
        mv.addObject("action", "/usermgmt/users/" + person.getId());
        return mv;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView viewById(@PathVariable("id") Long id) {
        PersonDTO person = personService.get(id);
        List<CompanyDTO> companies = companyService.getAll();
        ModelAndView mv = new ModelAndView("view-person");
        mv.addObject("person", person);
        mv.addObject("companies", companies);
        mv.addObject("action", "/usermgmt/users/" + person.getId());
        return mv;
    }

    @PostMapping(value = "/{id}")
    @ResponseBody
    public ModelAndView update(@ModelAttribute("person") @Validated PersonDTO person, BindingResult result) {
        List<CompanyDTO> companies = companyService.getAll();
        ModelAndView mv = new ModelAndView("view-person", result.getModel());
        mv.addObject("companies", companies);
        if (result.hasErrors()) {
            mv.addObject("person", person);
            mv.addObject("css", "danger");
            mv.addObject("msg", "Person could not be updated!");
            populateErrorCss(result, mv);
            return mv;
        } else {
            mv.addObject("css", "success");
            mv.addObject("msg", "Person updated successfully!");
        }
        person = personService.update(person);
        mv.addObject("person", person);
        mv.addObject("action", "/usermgmt/users/" + person.getId());
        return mv;
    }

    @PostMapping(value = "/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        personService.delete(id);
        List<PersonDTO> persons = personService.getAll();
        ModelAndView mv = new ModelAndView("persons");
        mv.addObject("persons", persons);
        return mv;
    }

    List<String> getListOfAttributes() {
        List<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add("email");
        listOfAttributes.add("firstName");
        listOfAttributes.add("lastName");
        listOfAttributes.add("mobileNumber");
        listOfAttributes.add("gender");
        listOfAttributes.add("dateOfBirth");
        listOfAttributes.add("position");
        return listOfAttributes;
    }

    private void populateErrorCss(BindingResult result, ModelAndView mv) {
        for (String attribute : getListOfAttributes()) {
            if (result.hasFieldErrors(attribute)) {
                mv.addObject(attribute + "Vld", "is-invalid");
            } else {
                mv.addObject(attribute + "Vld", "is-valid");
            }
        }
    }

}
