/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.service.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author MARINA
 */
public class AccountDTO {

    private Long accountId;
    private String password;
    private String accessToken;
    private String passwordResetToken;
    private String emailConfirmationToken;
    private PersonDTO person;

    public AccountDTO(Long accountId, String password, String accessToken, String passwordResetToken, String emailConfirmationToken, PersonDTO user) {
        this.accountId = accountId;
        this.password = password;
        this.accessToken = accessToken;
        this.passwordResetToken = passwordResetToken;
        this.emailConfirmationToken = emailConfirmationToken;
        this.person = user;
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }
    
    

    public AccountDTO() {
    }


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    public String getEmailConfirmationToken() {
        return emailConfirmationToken;
    }

    public void setEmailConfirmationToken(String emailConfirmationToken) {
        this.emailConfirmationToken = emailConfirmationToken;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.accountId);
        hash = 67 * hash + Objects.hashCode(this.password);
        hash = 67 * hash + Objects.hashCode(this.accessToken);
        hash = 67 * hash + Objects.hashCode(this.passwordResetToken);
        hash = 67 * hash + Objects.hashCode(this.emailConfirmationToken);
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
        final AccountDTO other = (AccountDTO) obj;
        if (!Objects.equals(this.accountId, other.accountId)) {
            return false;
        }
        return true;
    }

}
