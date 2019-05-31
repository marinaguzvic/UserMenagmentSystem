/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.model;

import java.util.Objects;


public class DocumentFieldDTO {

    
    protected Long documentId;
    protected int documentFieldId;
    private String fieldValue;
    private TemplateFieldDTO templateField;

    public DocumentFieldDTO() {
    }

    public DocumentFieldDTO(Long documentID, int documetnFIeldID) {
        this.documentId = documentID;
        this.documentFieldId = documetnFIeldID;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public int getDocumentFieldId() {
        return documentFieldId;
    }

    public void setDocumentFieldId(int documentFieldId) {
        this.documentFieldId = documentFieldId;
    }

    


    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }


    public TemplateFieldDTO getTemplateField() {
        return templateField;
    }

    public void setTemplateField(TemplateFieldDTO templateField) {
        this.templateField = templateField;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.documentId);
        hash = 59 * hash + Objects.hashCode(this.documentFieldId);
        hash = 59 * hash + Objects.hashCode(this.fieldValue);
        hash = 59 * hash + Objects.hashCode(this.templateField);
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
        final DocumentFieldDTO other = (DocumentFieldDTO) obj;
        if (!Objects.equals(this.documentId, other.documentId)) {
            return false;
        }
        if (!Objects.equals(this.documentFieldId, other.documentFieldId)) {
            return false;
        }
        return true;
    }

   

    
}
