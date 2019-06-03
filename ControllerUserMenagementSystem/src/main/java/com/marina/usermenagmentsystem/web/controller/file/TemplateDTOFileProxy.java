/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.controller.file;

import com.marina.usermenagmentsystem.service.model.TemplateDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author MARINA
 */
public class TemplateDTOFileProxy {
    private TemplateDTO template;
    private MultipartFile file;

    public TemplateDTOFileProxy() {
    }

    public TemplateDTOFileProxy(TemplateDTO template) {
        this.template = template;
    }
    
    public TemplateDTO getTemplate() {
        return template;
    }

    public void setTemplate(TemplateDTO template) {
        this.template = template;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
    
}
