/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.controller;

import com.marina.usermenagmentsystem.service.DocumentService;
import com.marina.usermenagmentsystem.service.TemplateService;
import com.marina.usermenagmentsystem.service.model.DocumentDTO;
import com.marina.usermenagmentsystem.service.model.DocumentFieldDTO;
import com.marina.usermenagmentsystem.service.model.TemplateDTO;
import com.marina.usermenagmentsystem.service.model.TemplateFieldDTO;
import com.marina.usermenagmentsystem.web.controller.file.TemplateDTOFileProxy;
import com.marina.usermenagmentsystem.web.controller.util.TemplateUtil;
import com.marina.usermenagmentsystem.web.validator.DocumentFormValidator;
import com.marina.usermenagmentsystem.web.validator.TemplateFormSaveValidator;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MARINA
 */
@Controller
@RequestMapping(value = "/templates/{id}/documents")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @Autowired
    TemplateService templateService;

    @Autowired
    DocumentFormValidator documentFormValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(documentFormValidator);
    }

    @GetMapping
    public ModelAndView all() {
        List<DocumentDTO> documents = documentService.getAll();
        ModelAndView mv = new ModelAndView("documents");
        mv.addObject("documents", documents);
        return mv;
    }

    @GetMapping(value = "/{documentId}")
    public ModelAndView get(@PathVariable Long id, @PathVariable Long documentId) {
        ModelAndView mv = new ModelAndView("view-document");
        DocumentDTO document = documentService.get(documentId);

        //...
        mv.addObject("document", document);
        mv.addObject("action", "/usermgmt/templates/" + id + "/documents/" + documentId);
        return mv;
    }

    @GetMapping(value = "/add")
    public ModelAndView add(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("new-document");
        DocumentDTO document = new DocumentDTO();
        TemplateDTO template = templateService.get(id);
        document.setDocumentFieldList(new ArrayList<DocumentFieldDTO>());
        for (TemplateFieldDTO templateFieldDTO : template.getTemplateFieldList()) {
            DocumentFieldDTO documentFieldDTO = new DocumentFieldDTO(0L, templateFieldDTO.getTemplateFieldId());
            documentFieldDTO.setTemplateField(templateFieldDTO);
            document.getDocumentFieldList().add(documentFieldDTO);
        }
        //...
        mv.addObject("document", document);
        mv.addObject("action", "/usermgmt/templates/" + id + "/documents");
        return mv;
    }

    @PostMapping
    public ModelAndView insert(@ModelAttribute("document") @Validated DocumentDTO document, BindingResult result, @PathVariable Long id) throws IOException {
        ModelAndView mv = new ModelAndView("view-document", result.getModel());

        if (result.hasErrors()) {
            mv.setViewName("new-document");
            mv.addObject("document", document);
            mv.addObject("action", "/usermgmt/templates/" + id + "/documents");
            populateErrorCss(result, mv, document.getDocumentFieldList().size());
            return mv;
        } else {
            mv.addObject("css", "success");
            mv.addObject("msg", "Document added successfully!");
        }
        document = documentService.insert(document);
        mv.addObject("document", document);
        mv.addObject("action", "/usermgmt/templates/" + id + "/documents/" + document.getDocumentId());
        return mv;
    }

    @PostMapping(value = "/{documentId}")
    public ModelAndView update(@ModelAttribute("document") @Validated DocumentDTO document, BindingResult result, @PathVariable Long id, @PathVariable Long documentId) throws IOException {
        ModelAndView mv = new ModelAndView("view-document", result.getModel());
        mv.addObject("action", "/usermgmt/templates/" + id + "/documents/" + documentId);
        if (result.hasErrors()) {
            mv.setViewName("view-document");
            mv.addObject("document", document);
            populateErrorCss(result, mv, document.getDocumentFieldList().size());
            return mv;
        } else {
            mv.addObject("css", "success");
            mv.addObject("msg", "Document updated successfully!");
        }
        document = documentService.update(document);
        mv.addObject("document", document);

        return mv;
    }

    @PostMapping(value = "/{documentId}/delete")
    public ModelAndView delete(@PathVariable Long documentId) {
        documentService.delete(documentId);
        List<DocumentDTO> documents = documentService.getAll();
        ModelAndView mv = new ModelAndView("documents");
        mv.addObject("documents", documents);
        return mv;
    }

    public void populateErrorCss(BindingResult result, ModelAndView mv, int size) {
        for (String attribute : getListOfAttributes()) {
            if (result.hasFieldErrors(attribute)) {
                mv.addObject(attribute + "Vld", "is-invalid");
            } else {
                mv.addObject(attribute + "Vld", "is-valid");
            }
        }

        for (String attribute : getListOfFieldAttributes()) {
            List<String> validations = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (result.hasFieldErrors("documentFieldList[" + i + "]." + attribute)) {
                    validations.add("is-invalid");
                } else {
                    validations.add("is-valid");
                }
            }
            mv.addObject(attribute + "Vld", validations);
        }
    }

    List<String> getListOfAttributes() {
        List<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add("documentName");
        return listOfAttributes;
    }

    List<String> getListOfFieldAttributes() {
        List<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add("fieldValue");
        return listOfAttributes;
    }
}
