/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.model;

import java.util.List;


public class DocumentDTO {

    private Long documentId;
    private String documentName;
    private List<DocumentFieldDTO> documentFieldList;

    public DocumentDTO() {
    }

    public DocumentDTO(Long documentId) {
        this.documentId = documentId;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public List<DocumentFieldDTO> getDocumentFieldList() {
        return documentFieldList;
    }

    public void setDocumentFieldList(List<DocumentFieldDTO> documentFieldList) {
        this.documentFieldList = documentFieldList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentId != null ? documentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentDTO)) {
            return false;
        }
        DocumentDTO other = (DocumentDTO) object;
        if ((this.documentId == null && other.documentId != null) || (this.documentId != null && !this.documentId.equals(other.documentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marina.repositoryusermenagmentsystem.data.model.Document[ documentId=" + documentId + " ]";
    }
    
}
