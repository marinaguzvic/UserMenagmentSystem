/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.controller;

import com.marina.usermenagmentsystem.service.DocumentService;
import com.marina.usermenagmentsystem.service.TemplateService;
import com.marina.usermenagmentsystem.service.model.DocumentDTO;
import com.marina.usermenagmentsystem.web.validator.DocumentFormValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MARINA
 */
@Controller
public class DocumentAllController {

    @Autowired
    DocumentService documentService;

    @RequestMapping(value = "/documents")
    public ModelAndView all() {
        List<DocumentDTO> documents = documentService.getAll();
        ModelAndView mv = new ModelAndView("documents");
        mv.addObject("documents", documents);
        return mv;
    }
}
