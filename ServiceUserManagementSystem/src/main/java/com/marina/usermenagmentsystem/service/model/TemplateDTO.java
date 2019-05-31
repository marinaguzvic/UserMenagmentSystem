/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.model;

import java.util.List;

public class TemplateDTO {

    private Long templateId;
    private String templateName;
    private String templateType;
    private byte[] templateStream;
    private List<TemplateFieldDTO> templateFieldList;
    private List<DocumentDTO> documentList;

    public TemplateDTO() {
    }

    public TemplateDTO(Long templateId) {
        this.templateId = templateId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public byte[] getTemplateStream() {
        return templateStream;
    }

    public void setTemplateStream(byte[] templateStream) {
        this.templateStream = templateStream;
    }

    public List<TemplateFieldDTO> getTemplateFieldList() {
        return templateFieldList;
    }

    public void setTemplateFieldList(List<TemplateFieldDTO> templateFieldList) {
        this.templateFieldList = templateFieldList;
    }

    public List<DocumentDTO> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<DocumentDTO> documentList) {
        this.documentList = documentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (templateId != null ? templateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemplateDTO)) {
            return false;
        }
        TemplateDTO other = (TemplateDTO) object;
        if ((this.templateId == null && other.templateId != null) || (this.templateId != null && !this.templateId.equals(other.templateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marina.repositoryusermenagmentsystem.data.model.Template[ templateId=" + templateId + " ]";
    }
    
}
