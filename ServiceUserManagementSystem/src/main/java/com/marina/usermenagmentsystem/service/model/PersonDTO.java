/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.model;

import com.marina.usermenagmentsystem.service.model.util.ModelConstants;
import java.util.Date;
import java.util.Objects;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author MARINA
 */
public class PersonDTO {
     private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String gender;
    private Date dateOfBirth;
    private PositionDTO position;

    public PositionDTO getPosition() {
        return position;
    }

    public void setPosition(PositionDTO position) {
        this.position = position;
    }
    private AccountDTO account;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String email, String firstName, String lastName, String mobileNumber, String gender, Date dateOfBirth, PositionDTO positionIdFk, AccountDTO account) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.position = positionIdFk;
        this.account = account;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.email);
        hash = 41 * hash + Objects.hashCode(this.firstName);
        hash = 41 * hash + Objects.hashCode(this.lastName);
        hash = 41 * hash + Objects.hashCode(this.mobileNumber);
        hash = 41 * hash + Objects.hashCode(this.gender);
        hash = 41 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 41 * hash + Objects.hashCode(this.account);
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
        final PersonDTO other = (PersonDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


    public String[] getColumns() {
        return new String[]
        {ModelConstants.User.ID,
        ModelConstants.User.EMAIL,
        ModelConstants.User.FIRST_NAME,
        ModelConstants.User.LAST_NAME,
        ModelConstants.User.MOBILE_NUMBER,
        ModelConstants.User.GENDER,
        ModelConstants.User.DATE_OF_BIRTH};
    }
    
    
}

