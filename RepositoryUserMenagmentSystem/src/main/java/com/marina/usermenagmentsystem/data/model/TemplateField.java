/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.data.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MARINA
 */
@Entity
@Table(name = "template_field")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "TemplateField.findAll", query = "SELECT t FROM TemplateField t")
//    , @NamedQuery(name = "TemplateField.findByTemplateIdFk", query = "SELECT t FROM TemplateField t WHERE t.templateFieldPK.templateIdFk = :templateIdFk")
//    , @NamedQuery(name = "TemplateField.findByTemplateFieldId", query = "SELECT t FROM TemplateField t WHERE t.templateFieldPK.templateFieldId = :templateFieldId")
//    , @NamedQuery(name = "TemplateField.findByTemplateFieldName", query = "SELECT t FROM TemplateField t WHERE t.templateFieldName = :templateFieldName")
//    , @NamedQuery(name = "TemplateField.findByTemplateFieldType", query = "SELECT t FROM TemplateField t WHERE t.templateFieldType = :templateFieldType")})
public class TemplateField implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TemplateFieldPK templateFieldPK;
    @Column(name = "template_field_name")
    private String templateFieldName;
    @Column(name = "template_field_type")
    private String templateFieldType;
    @JoinColumn(name = "template_id_fk", referencedColumnName = "template_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Template template;

    public TemplateField() {
        this.templateFieldPK = new TemplateFieldPK();
    }

    public TemplateField(TemplateFieldPK templateFieldPK) {
        this.templateFieldPK = templateFieldPK;
    }

    public TemplateField(long templateIdFk, int templateFieldId) {
        this.templateFieldPK = new TemplateFieldPK(templateIdFk, templateFieldId);
    }

    public TemplateFieldPK getTemplateFieldPK() {
        return templateFieldPK;
    }

    public void setTemplateFieldPK(TemplateFieldPK templateFieldPK) {
        this.templateFieldPK = templateFieldPK;
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

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (templateFieldPK != null ? templateFieldPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemplateField)) {
            return false;
        }
        TemplateField other = (TemplateField) object;
        if ((this.templateFieldPK == null && other.templateFieldPK != null) || (this.templateFieldPK != null && !this.templateFieldPK.equals(other.templateFieldPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marina.repositoryusermenagmentsystem.data.model.TemplateField[ templateFieldPK=" + templateFieldPK + " ]";
    }
    
}
