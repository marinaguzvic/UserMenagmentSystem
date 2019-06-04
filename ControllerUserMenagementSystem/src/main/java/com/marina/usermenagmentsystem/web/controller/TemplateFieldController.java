/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.controller;

import com.marina.usermenagmentsystem.service.TemplateFieldService;
import com.marina.usermenagmentsystem.service.TemplateService;
import com.marina.usermenagmentsystem.service.model.TemplateDTO;
import com.marina.usermenagmentsystem.service.model.TemplateFieldDTO;
import com.marina.usermenagmentsystem.web.controller.file.TemplateDTOFileProxy;
import com.marina.usermenagmentsystem.web.controller.util.TemplateUtil;
import com.marina.usermenagmentsystem.web.validator.TemplateFormAddFieldValidator;
import com.marina.usermenagmentsystem.web.validator.TemplateFormSaveValidator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MARINA
 */
@Controller
@RequestMapping(value = "/templates")
public class TemplateFieldController {

    @Autowired
    TemplateFieldService templateFieldService;

    @Autowired
    TemplateFormAddFieldValidator templateFormAddFieldValidator;

    @Autowired
    TemplateUtil templateUtil;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(templateFormAddFieldValidator);
    }

    @PostMapping(value = "/add-item")
    public ModelAndView addItem(@ModelAttribute("template") @Validated TemplateDTOFileProxy templateProxy, BindingResult result) throws IOException {
        ModelAndView mv = new ModelAndView("new-template", result.getModel());
        List<String> types = templateUtil.getTypes();
        templateUtil.setFile(templateProxy);
        mv.addObject("types", types);
        mv.addObject("action", "/usermgmt/templates");
        if (result.hasErrors()) {
            mv.setViewName("new-template");
            mv.addObject("template", templateProxy);
            templateUtil.populateErrorCss(result, mv, templateProxy.getTemplate().getTemplateFieldList().size());
            return mv;
        }
        templateProxy.getTemplate().getTemplateFieldList().add(new TemplateFieldDTO(0, generateNewId(templateProxy.getTemplate())));
        mv.addObject("template", templateProxy);
        return mv;
    }

    @PostMapping(value = "/delete-item/{id}")
    public ModelAndView deleteItem(@ModelAttribute("template") TemplateDTOFileProxy templateProxy, @PathVariable int id) throws IOException {
        ModelAndView mv = new ModelAndView("new-template");
        List<String> types = templateUtil.getTypes();
        templateUtil.setFile(templateProxy);
        removeField(templateProxy.getTemplate(), id);
        mv.addObject("template", templateProxy);
        mv.addObject("types", types);
        mv.addObject("action", "/usermgmt/templates");
        return mv;
    }

    @PostMapping(value = "/{id}/add-item")
    public ModelAndView addItem(@ModelAttribute("template") @Validated(TemplateFormAddFieldValidator.class) TemplateDTOFileProxy templateProxy, BindingResult result, @PathVariable Long id) throws IOException {
        ModelAndView mv = new ModelAndView("view-template",result.getModel());
        List<String> types = templateUtil.getTypes();
        mv.addObject("types", types);
        mv.addObject("action", "/usermgmt/templates/" + id);
        templateUtil.setFile(templateProxy);
        if (result.hasErrors()) {
            mv.addObject("template", templateProxy);
            templateUtil.populateErrorCss(result, mv, templateProxy.getTemplate().getTemplateFieldList().size());
            return mv;
        }
        templateFieldService.insert(templateProxy.getTemplate().getTemplateFieldList().get(templateProxy.getTemplate().getTemplateFieldList().size() - 1));
        templateProxy.getTemplate().getTemplateFieldList().add(new TemplateFieldDTO(id, templateUtil.generateUpdateId(templateProxy.getTemplate())));
        mv.addObject("template", templateProxy);
        return mv;
    }

    @PostMapping(value = "{id}/delete-item/{itemId}")
    public ModelAndView deleteItem(@ModelAttribute("template") TemplateDTOFileProxy templateProxy, @PathVariable Long id, @PathVariable int itemId) throws IOException {
        ModelAndView mv = new ModelAndView("new-template");
        List<String> types = templateUtil.getTypes();
        templateUtil.setFile(templateProxy);
        templateFieldService.delete(id, itemId);
        removeField(templateProxy.getTemplate(), itemId);
        mv.addObject("template", templateProxy);
        mv.addObject("types", types);
        mv.addObject("action", "/usermgmt/templates/" + id);
        return mv;
    }

    private void removeField(TemplateDTO template, int id) {
        for (int i = 0; i < template.getTemplateFieldList().size(); i++) {
            if (template.getTemplateFieldList().get(i).getTemplateFieldId() == id) {
                template.getTemplateFieldList().remove(i);
            }
        }
    }

    private int generateNewId(TemplateDTO template) {
        int i = 1;
        for (TemplateFieldDTO templateFieldDTO : template.getTemplateFieldList()) {
            templateFieldDTO.setTemplateFieldId(i++);
        }
        return i;
    }


}
