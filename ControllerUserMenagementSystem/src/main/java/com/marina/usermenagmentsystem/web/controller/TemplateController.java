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
    TemplateFieldService templateFieldService;

    @Autowired
    TemplateFormSaveValidator templateFormSaveValidator;

    @Autowired
    TemplateFormAddFieldValidator templateFormAddFieldValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(templateFormSaveValidator, templateFormAddFieldValidator);
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
        List<String> types = getTypes();
        TemplateDTO template = templateService.get(id);
        TemplateDTOFileProxy templateProxy = new TemplateDTOFileProxy(template);
        templateProxy.getTemplate().getTemplateFieldList().add(new TemplateFieldDTO(id, generateUpdateId(template)));
        mv.addObject("template", templateProxy);
        mv.addObject("types", types);
        mv.addObject("action", "/usermgmt/templates/" + template.getTemplateId());
        return mv;
    }

    @GetMapping(value = "/add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView("new-template");
        List<String> types = getTypes();
        TemplateDTOFileProxy template = new TemplateDTOFileProxy(new TemplateDTO());
        template.getTemplate().getTemplateFieldList().add(new TemplateFieldDTO(0, 1));
        mv.addObject("template", template);
        mv.addObject("types", types);
        mv.addObject("action", "/usermgmt/templates");
        return mv;
    }

    @PostMapping
    public ModelAndView insert(@ModelAttribute("template") @Validated(TemplateFormSaveValidator.class) TemplateDTOFileProxy templateProxy, BindingResult result) throws IOException {
        ModelAndView mv = new ModelAndView("view-template", result.getModel());
        templateProxy.getTemplate().getTemplateFieldList().remove(templateProxy.getTemplate().getTemplateFieldList().size() - 1);
        setFile(templateProxy);
        List<String> types = getTypes();
        mv.addObject("types", types);
        if (result.hasErrors()) {
            mv.setViewName("new-template");
            mv.addObject("template", templateProxy);
            mv.addObject("action", "/usermgmt/templates");
            populateErrorCss(result, mv, templateProxy.getTemplate().getTemplateFieldList());
            return mv;
        } else {
            mv.addObject("css", "success");
            mv.addObject("msg", "Person added successfully!");
        }

        templateProxy.setTemplate(templateService.insert(templateProxy.getTemplate()));
        templateProxy.getTemplate().getTemplateFieldList().add(new TemplateFieldDTO(templateProxy.getTemplate().getTemplateId(), generateUpdateId(templateProxy.getTemplate())));
        mv.addObject("template", templateProxy);
        mv.addObject("action", "/usermgmt/templates/" + templateProxy.getTemplate().getTemplateId());
        return mv;
    }

    @PostMapping(value = "/{id}")
    public ModelAndView update(@ModelAttribute("template") @Validated(TemplateFormSaveValidator.class) TemplateDTOFileProxy templateProxy, BindingResult result, @PathVariable Long id) throws IOException {
        ModelAndView mv = new ModelAndView("view-template");
        setFile(templateProxy);
        List<String> types = getTypes();
        mv.addObject("types", types);
        mv.addObject("action", "/usermgmt/templates/" + templateProxy.getTemplate().getTemplateId());
        if (result.hasErrors()) {
            mv.setViewName("new-template");
            mv.addObject("template", templateProxy);
            mv.addObject("action", "/usermgmt/templates");
            populateErrorCss(result, mv, templateProxy.getTemplate().getTemplateFieldList());
            return mv;
        } else {
            mv.addObject("css", "success");
            mv.addObject("msg", "Person updated successfully!");
        }
        templateProxy.getTemplate().getTemplateFieldList().remove(templateProxy.getTemplate().getTemplateFieldList().size() - 1);
        templateProxy.setTemplate(templateService.update(templateProxy.getTemplate()));
        templateProxy.getTemplate().getTemplateFieldList().add(new TemplateFieldDTO(id, generateUpdateId(templateProxy.getTemplate())));
        mv.addObject("template", templateProxy);

        return mv;
    }

    private void setFile(TemplateDTOFileProxy templateProxy) throws IOException {
        if (!templateProxy.getFile().isEmpty()) {
            templateProxy.getTemplate().setTemplateFile(templateProxy.getFile().getBytes());
            templateProxy.getTemplate().setTemplateFileType(templateProxy.getFile().getContentType());
            templateProxy.getTemplate().setTemplateFileName(templateProxy.getFile().getOriginalFilename());
        }
    }

    @PostMapping(value = "/add-item")
    public ModelAndView addItem(@ModelAttribute("template") @Validated(TemplateFormAddFieldValidator.class) TemplateDTOFileProxy templateProxy, BindingResult result) throws IOException {
        ModelAndView mv = new ModelAndView("new-template");
        List<String> types = getTypes();
        setFile(templateProxy);
        mv.addObject("types", types);
        mv.addObject("action", "/usermgmt/templates");
        if (result.hasErrors()) {
            mv.setViewName("new-template");
            mv.addObject("template", templateProxy);
            populateErrorCss(result, mv, templateProxy.getTemplate().getTemplateFieldList());
            return mv;
        }
        templateProxy.getTemplate().getTemplateFieldList().add(new TemplateFieldDTO(0, generateNewId(templateProxy.getTemplate())));
        mv.addObject("template", templateProxy);
        return mv;
    }

    @PostMapping(value = "/delete-item/{id}")
    public ModelAndView deleteItem(@ModelAttribute("template") TemplateDTOFileProxy templateProxy, @PathVariable int id) throws IOException {
        ModelAndView mv = new ModelAndView("new-template");
        List<String> types = getTypes();
        setFile(templateProxy);
        removeField(templateProxy.getTemplate(), id);
        mv.addObject("template", templateProxy);
        mv.addObject("types", types);
        mv.addObject("action", "/usermgmt/templates");
        return mv;
    }

    @PostMapping(value = "/{id}/add-item")
    public ModelAndView addItem(@ModelAttribute("template") @Validated(TemplateFormAddFieldValidator.class) TemplateDTOFileProxy templateProxy, BindingResult result, @PathVariable Long id) throws IOException {
        ModelAndView mv = new ModelAndView("view-template");
        List<String> types = getTypes();
        mv.addObject("types", types);
        mv.addObject("action", "/usermgmt/templates/" + id);
        setFile(templateProxy);
        if (result.hasErrors()) {
            mv.addObject("template", templateProxy);
            populateErrorCss(result, mv, templateProxy.getTemplate().getTemplateFieldList());
            return mv;
        }
        templateFieldService.insert(templateProxy.getTemplate().getTemplateFieldList().get(templateProxy.getTemplate().getTemplateFieldList().size() - 1));
        templateProxy.getTemplate().getTemplateFieldList().add(new TemplateFieldDTO(id, generateUpdateId(templateProxy.getTemplate())));
        mv.addObject("template", templateProxy);
        return mv;
    }

    @PostMapping(value = "{id}/delete-item/{itemId}")
    public ModelAndView deleteItem(@ModelAttribute("template") TemplateDTOFileProxy templateProxy, @PathVariable Long id, @PathVariable int itemId) throws IOException {
        ModelAndView mv = new ModelAndView("new-template");
        List<String> types = getTypes();
        setFile(templateProxy);
        templateFieldService.delete(id, itemId);
        removeField(templateProxy.getTemplate(), itemId);
        mv.addObject("template", templateProxy);
        mv.addObject("types", types);
        mv.addObject("action", "/usermgmt/templates/" + id);
        return mv;
    }

    public List<String> getTypes() {
        List<String> types = new ArrayList<>();
        for (EnumFieldType value : EnumFieldType.values()) {
            types.add(value.name());
        }
        return types;
    }

    private int generateNewId(TemplateDTO template) {
        int i = 1;
        for (TemplateFieldDTO templateFieldDTO : template.getTemplateFieldList()) {
            templateFieldDTO.setTemplateFieldId(i++);
        }
        return i;
    }

    private int generateUpdateId(TemplateDTO template) {
        int max = 0;
        for (TemplateFieldDTO templateFieldDTO : template.getTemplateFieldList()) {
            if (templateFieldDTO.getTemplateFieldId() > max) {
                max = templateFieldDTO.getTemplateFieldId();
            }
        }
        return max + 1;
    }

    private void removeField(TemplateDTO template, int id) {
        for (int i = 0; i < template.getTemplateFieldList().size(); i++) {
            if (template.getTemplateFieldList().get(i).getTemplateFieldId() == id) {
                template.getTemplateFieldList().remove(i);
            }
        }
    }

    List<String> getListOfAttributes() {
        List<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add("templateName");
        listOfAttributes.add("templateFile");
        listOfAttributes.add("templateFileName");
        listOfAttributes.add("templateFileType");
        return listOfAttributes;
    }

    List<String> getListOfFieldAttributes() {
        List<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add("templateFieldName");
        return listOfAttributes;
    }

    private void populateErrorCss(BindingResult result, ModelAndView mv, List<TemplateFieldDTO> fields) {
        for (String attribute : getListOfAttributes()) {
            if (result.hasFieldErrors("template." + attribute)) {
                mv.addObject(attribute + "Vld", "is-invalid");
            } else {
                mv.addObject(attribute + "Vld", "is-valid");
            }
        }

        for (String attribute : getListOfFieldAttributes()) {
            List<String> attributes = new ArrayList<>();
            for (int i = 0; i < fields.size() - 1; i++) {

                if (result.hasFieldErrors("template.templateFieldList[" + i + "]." + attribute)) {
                    attributes.add("is-invalid");
                } else {
                    attributes.add("is-valid");
                }
            }
            mv.addObject(attribute + "Vld", attributes);
        }
    }
}
