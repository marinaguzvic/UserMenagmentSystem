/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.controller;

import com.marina.usermenagmentsystem.data.model.EnumFieldType;
import com.marina.usermenagmentsystem.service.TemplateFieldService;
import com.marina.usermenagmentsystem.service.TemplateService;
import com.marina.usermenagmentsystem.service.model.CompanyDTO;
import com.marina.usermenagmentsystem.service.model.PersonDTO;
import com.marina.usermenagmentsystem.service.model.TemplateDTO;
import com.marina.usermenagmentsystem.service.model.TemplateFieldDTO;
import com.marina.usermenagmentsystem.web.controller.file.TemplateDTOFileProxy;
import com.marina.usermenagmentsystem.web.controller.util.TemplateUtil;
import com.marina.usermenagmentsystem.web.validator.TemplateFormAddFieldValidator;
import com.marina.usermenagmentsystem.web.validator.TemplateFormSaveValidator;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MARINA
 */
@Controller
@RequestMapping(value = "/templates")
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @Autowired
    TemplateFormSaveValidator templateFormSaveValidator;

    @Autowired
    TemplateUtil templateUtil;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(templateFormSaveValidator);
    }

    @GetMapping
    public ModelAndView all() {
        List<TemplateDTO> templates = templateService.getAll();
        ModelAndView mv = new ModelAndView("templates");
        mv.addObject("templates", templates);
        return mv;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView get(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("view-template");
        List<String> types = templateUtil.getTypes();
        TemplateDTO template = templateService.get(id);
        TemplateDTOFileProxy templateProxy = new TemplateDTOFileProxy(template);
        templateProxy.getTemplate().getTemplateFieldList().add(new TemplateFieldDTO(id, templateUtil.generateUpdateId(template)));
        mv.addObject("template", templateProxy);
        mv.addObject("types", types);
        mv.addObject("action", "/usermgmt/templates/" + template.getTemplateId());
        return mv;
    }

    @GetMapping(value = "/add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView("new-template");
        List<String> types = templateUtil.getTypes();
        TemplateDTOFileProxy template = new TemplateDTOFileProxy(new TemplateDTO());
        template.getTemplate().getTemplateFieldList().add(new TemplateFieldDTO(0, 1));
        mv.addObject("template", template);
        mv.addObject("types", types);
        mv.addObject("action", "/usermgmt/templates");
        return mv;
    }

    @PostMapping
    public ModelAndView insert(@ModelAttribute("template") @Validated TemplateDTOFileProxy templateProxy, BindingResult result) throws IOException {
        ModelAndView mv = new ModelAndView("view-template", result.getModel());

//        templateUtil.setFile(templateProxy);
        List<String> types = templateUtil.getTypes();
        mv.addObject("types", types);
        if (result.hasErrors()) {
            mv.setViewName("new-template");
            mv.addObject("template", templateProxy);
            mv.addObject("action", "/usermgmt/templates");
            templateUtil.populateErrorCss(result, mv, templateProxy.getTemplate().getTemplateFieldList().size() - 1);
            return mv;
        } else {
            mv.addObject("css", "success");
            mv.addObject("msg", "Template added successfully!");
        }
        templateProxy.getTemplate().getTemplateFieldList().remove(templateProxy.getTemplate().getTemplateFieldList().size() - 1);
        templateProxy.setTemplate(templateService.insert(templateProxy.getTemplate()));
        templateProxy.getTemplate().getTemplateFieldList().add(new TemplateFieldDTO(templateProxy.getTemplate().getTemplateId(), templateUtil.generateUpdateId(templateProxy.getTemplate())));
        mv.addObject("template", templateProxy);
        mv.addObject("action", "/usermgmt/templates/" + templateProxy.getTemplate().getTemplateId());
        return mv;
    }

    @PostMapping(value = "/{id}")
    public ModelAndView update(@ModelAttribute("template") @Validated TemplateDTOFileProxy templateProxy, BindingResult result, @PathVariable Long id) throws IOException {
        ModelAndView mv = new ModelAndView("view-template", result.getModel());
//        templateUtil.setFile(templateProxy);
        List<String> types = templateUtil.getTypes();
        mv.addObject("types", types);
        mv.addObject("action", "/usermgmt/templates/" + templateProxy.getTemplate().getTemplateId());
        if (result.hasErrors()) {
            mv.setViewName("view-template");
            mv.addObject("template", templateProxy);
            mv.addObject("action", "/usermgmt/templates");
            templateUtil.populateErrorCss(result, mv, templateProxy.getTemplate().getTemplateFieldList().size() - 1);
            return mv;
        } else {
            mv.addObject("css", "success");
            mv.addObject("msg", "Template updated successfully!");
        }
        templateProxy.getTemplate().getTemplateFieldList().remove(templateProxy.getTemplate().getTemplateFieldList().size() - 1);
        templateProxy.setTemplate(templateService.update(templateProxy.getTemplate()));
        templateProxy.getTemplate().getTemplateFieldList().add(new TemplateFieldDTO(id,templateUtil. generateUpdateId(templateProxy.getTemplate())));
        mv.addObject("template", templateProxy);

        return mv;
    }

   @PostMapping(value = "/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        templateService.delete(id);
        List<TemplateDTO> persons = templateService.getAll();
        ModelAndView mv = new ModelAndView("templates");
        mv.addObject("templates", persons);
        return mv;
    }

}
