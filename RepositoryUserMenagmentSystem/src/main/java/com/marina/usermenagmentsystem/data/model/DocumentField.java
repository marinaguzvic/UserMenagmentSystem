/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.data.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARINA
 */
@Entity
@Table(name = "document_field")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "DocumentField.findAll", query = "SELECT d FROM DocumentField d")
//    , @NamedQuery(name = "DocumentField.findByDocumentIdFk", query = "SELECT d FROM DocumentField d WHERE d.documentFieldPK.documentIdFk = :documentIdFk")
//    , @NamedQuery(name = "DocumentField.findByFieldId", query = "SELECT d FROM DocumentField d WHERE d.documentFieldPK.fieldId = :fieldId")
//    , @NamedQuery(name = "DocumentField.findByFieldValue", query = "SELECT d FROM DocumentField d WHERE d.fieldValue = :fieldValue")})
public class DocumentField implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentFieldPK documentFieldPK;
    @Column(name = "field_value")
    private String fieldValue;
    @JoinColumn(name = "document_id_fk", referencedColumnName = "document_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Document document;
    @JoinColumns({
        @JoinColumn(name = "template_id_fk", referencedColumnName = "template_id_fk")
        , @JoinColumn(name = "template_field_id_fk", referencedColumnName = "template_field_id")})
    @ManyToOne
    private TemplateField templateField;

    public DocumentField() {
        this.documentFieldPK = new DocumentFieldPK();
    }

    public DocumentField(DocumentFieldPK documentFieldPK) {
        this.documentFieldPK = documentFieldPK;
    }

    public DocumentField(long documentIdFk, int fieldId) {
        this.documentFieldPK = new DocumentFieldPK(documentIdFk, fieldId);
    }

    public DocumentFieldPK getDocumentFieldPK() {
        return documentFieldPK;
    }

    public void setDocumentFieldPK(DocumentFieldPK documentFieldPK) {
        this.documentFieldPK = documentFieldPK;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public TemplateField getTemplateField() {
        return templateField;
    }

    public void setTemplateField(TemplateField templateField) {
        this.templateField = templateField;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentFieldPK != null ? documentFieldPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentField)) {
            return false;
        }
        DocumentField other = (DocumentField) object;
        if ((this.documentFieldPK == null && other.documentFieldPK != null) || (this.documentFieldPK != null && !this.documentFieldPK.equals(other.documentFieldPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marina.repositoryusermenagmentsystem.data.model.DocumentField[ documentFieldPK=" + documentFieldPK + " ]";
    }
    
}
