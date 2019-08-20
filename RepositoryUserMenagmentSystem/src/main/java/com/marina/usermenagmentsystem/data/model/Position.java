/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.data.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.envers.Audited;

/**
 *
 * @author MARINA
 */
@Entity
@Audited
@Table(name = "position")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Position.findAll", query = "SELECT p FROM Position p")
//    , @NamedQuery(name = "Position.findByPositionId", query = "SELECT p FROM Position p WHERE p.positionId = :positionId")
//    , @NamedQuery(name = "Position.findByPositionName", query = "SELECT p FROM Position p WHERE p.positionName = :positionName")})
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "position_id")
    private Long positionId;
    @Column(name = "position_name")
    private String positionName;
//    @OneToMany(mappedBy = "position",fetch = FetchType.LAZY)
//    private List<Person> userList;
    @JoinColumn(name = "company_id_fk", referencedColumnName = "company_id")
    @ManyToOne
    private Company companyIdFk;

    public Position() {
    }

    public Position(Long positionId) {
        this.positionId = positionId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (positionId != null ? positionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Position)) {
            return false;
        }
        Position other = (Position) object;
        if ((this.positionId == null && other.positionId != null) || (this.positionId != null && !this.positionId.equals(other.positionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marina.repositoryusermenagmentsystem.data.model.Position[ positionId=" + positionId + " ]";
    }


    public Company getCompanyIdFk() {
        return companyIdFk;
    }

    public void setCompanyIdFk(Company companyIdFk) {
        this.companyIdFk = companyIdFk;
    }

}
