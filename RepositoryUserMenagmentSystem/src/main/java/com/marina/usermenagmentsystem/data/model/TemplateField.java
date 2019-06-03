/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.data.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
//@Embeddable
public class TemplateField implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected TemplateFieldPK templateFieldPK;
    @Column(name = "template_field_name")
    private String templateFieldName;
    @Enumerated(EnumType.STRING)
    @Column(name = "template_field_type")
    private EnumFieldType templateFieldType;
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
//
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

    public EnumFieldType getTemplateFieldType() {
        return templateFieldType;
    }

    public void setTemplateFieldType(EnumFieldType templateFieldType) {
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
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.templateFieldPK);
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
        final TemplateField other = (TemplateField) obj;
        if (!Objects.equals(this.templateFieldPK, other.templateFieldPK)) {
            return false;
        }
        return true;
    }





}
