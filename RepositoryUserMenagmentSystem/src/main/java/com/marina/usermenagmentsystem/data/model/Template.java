/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.data.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "template")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Template.findAll", query = "SELECT t FROM Template t")
//    , @NamedQuery(name = "Template.findByTemplateId", query = "SELECT t FROM Template t WHERE t.templateId = :templateId")
//    , @NamedQuery(name = "Template.findByTemplateName", query = "SELECT t FROM Template t WHERE t.templateName = :templateName")
//    , @NamedQuery(name = "Template.findByTemplateType", query = "SELECT t FROM Template t WHERE t.templateType = :templateType")})
public class Template implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "template_id")
    private Long templateId;
    @Column(name = "template_name")
    private String templateName;
    @Column(name = "template_type")
    private String templateType;
    @Lob
    @Column(name = "template_stream")
    private byte[] templateStream;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "template")
    private List<TemplateField> templateFieldList;


    public Template() {
    }

    public Template(Long templateId) {
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

    @XmlTransient
    public List<TemplateField> getTemplateFieldList() {
        return templateFieldList;
    }

    public void setTemplateFieldList(List<TemplateField> templateFieldList) {
        this.templateFieldList = templateFieldList;
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
        if (!(object instanceof Template)) {
            return false;
        }
        Template other = (Template) object;
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
