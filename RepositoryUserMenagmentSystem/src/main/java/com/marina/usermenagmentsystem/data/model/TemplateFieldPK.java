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
public class TemplateFieldPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "template_id_fk")
    private long templateIdFk;
    @Basic(optional = false)
    @Column(name = "template_field_id")
    private int templateFieldId;

    public TemplateFieldPK() {
    }

    public TemplateFieldPK(long templateIdFk, int templateFieldId) {
        this.templateIdFk = templateIdFk;
        this.templateFieldId = templateFieldId;
    }

    public Long getTemplateIdFk() {
        return templateIdFk;
    }

    public void setTemplateIdFk(Long templateIdFk) {
        this.templateIdFk = templateIdFk;
    }

    public int getTemplateFieldId() {
        return templateFieldId;
    }

    public void setTemplateFieldId(int templateFieldId) {
        this.templateFieldId = templateFieldId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Long) templateIdFk;
        hash += (int) templateFieldId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemplateFieldPK)) {
            return false;
        }
        TemplateFieldPK other = (TemplateFieldPK) object;
        if (this.templateIdFk != other.templateIdFk) {
            return false;
        }
        if (this.templateFieldId != other.templateFieldId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marina.repositoryusermenagmentsystem.data.model.TemplateFieldPK[ templateIdFk=" + templateIdFk + ", templateFieldId=" + templateFieldId + " ]";
    }
    
}
