/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.model;

import java.util.List;
import java.util.Objects;

public class TemplateFieldDTO {

    protected long templateId;
    protected int templateFieldId;
    private String templateFieldName;
    private String templateFieldType;
    private TemplateDTO template;

    public TemplateFieldDTO() {
    }

    public TemplateFieldDTO(Long templateId, int templateFieldId, String templateFieldName, String templateFieldType, TemplateDTO template) {
        this.templateId = templateId;
        this.templateFieldId = templateFieldId;
        this.templateFieldName = templateFieldName;
        this.templateFieldType = templateFieldType;
        this.template = template;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public int getTemplateFieldId() {
        return templateFieldId;
    }

    public void setTemplateFieldId(int templateFieldId) {
        this.templateFieldId = templateFieldId;
    }



    public TemplateFieldDTO(long templateIdFk, int templateFieldId) {
        this.templateFieldId = templateFieldId;
        this.templateId = templateIdFk;
    }

    
    public String getTemplateFieldName() {
        return templateFieldName;
    }

    public void setTemplateFieldName(String templateFieldName) {
        this.templateFieldName = templateFieldName;
    }

    public String getTemplateFieldType() {
        return templateFieldType;
    }

    public void setTemplateFieldType(String templateFieldType) {
        this.templateFieldType = templateFieldType;
    }

    public TemplateDTO getTemplate() {
        return template;
    }

    public void setTemplate(TemplateDTO template) {
        this.template = template;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.templateId);
        hash = 97 * hash + Objects.hashCode(this.templateFieldId);
        hash = 97 * hash + Objects.hashCode(this.templateFieldName);
        hash = 97 * hash + Objects.hashCode(this.templateFieldType);
        hash = 97 * hash + Objects.hashCode(this.template);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TemplateFieldDTO other = (TemplateFieldDTO) obj;
        if (!Objects.equals(this.templateId, other.templateId)) {
            return false;
        }
        if (!Objects.equals(this.templateFieldId, other.templateFieldId)) {
            return false;
        }
        return true;
    }






    
}
