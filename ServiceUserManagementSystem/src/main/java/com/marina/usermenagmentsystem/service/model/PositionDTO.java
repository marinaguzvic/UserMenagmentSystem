/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.model;

import java.util.List;


public class PositionDTO {

    private Long positionId;
    private String positionName;
//    private List<PersonDTO> userList;
    private CompanyDTO companyIdFk;

    public PositionDTO() {
    }

    public PositionDTO(Long positionId) {
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

//    public List<PersonDTO> getUserList() {
//        return userList;
//    }
//
//    public void setUserList(List<PersonDTO> userList) {
//        this.userList = userList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (positionId != null ? positionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PositionDTO)) {
            return false;
        }
        PositionDTO other = (PositionDTO) object;
        if ((this.positionId == null && other.positionId != null) || (this.positionId != null && !this.positionId.equals(other.positionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.positionName + " [ " + this.companyIdFk.getCompanyName() + " ]";
    }

    public CompanyDTO getCompanyIdFk() {
        return companyIdFk;
    }

    public void setCompanyIdFk(CompanyDTO companyIdFk) {
        this.companyIdFk = companyIdFk;
    }
    
}
