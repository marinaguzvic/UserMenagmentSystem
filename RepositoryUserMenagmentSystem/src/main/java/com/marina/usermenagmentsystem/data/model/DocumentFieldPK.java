/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.data.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author MARINA
 */
@Embeddable
public class DocumentFieldPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "document_id_fk")
    private long documentIdFk;
    @Basic(optional = false)
    @Column(name = "field_id")
    private int fieldId;

    public DocumentFieldPK() {
    }

    public DocumentFieldPK(long documentIdFk, int fieldId) {
        this.documentIdFk = documentIdFk;
        this.fieldId = fieldId;
    }

    public long getDocumentIdFk() {
        return documentIdFk;
    }

    public void setDocumentIdFk(long documentIdFk) {
        this.documentIdFk = documentIdFk;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) documentIdFk;
        hash += (int) fieldId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentFieldPK)) {
            return false;
        }
        DocumentFieldPK other = (DocumentFieldPK) object;
        if (this.documentIdFk != other.documentIdFk) {
            return false;
        }
        if (this.fieldId != other.fieldId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marina.repositoryusermenagmentsystem.data.model.DocumentFieldPK[ documentIdFk=" + documentIdFk + ", fieldId=" + fieldId + " ]";
    }
    
}
