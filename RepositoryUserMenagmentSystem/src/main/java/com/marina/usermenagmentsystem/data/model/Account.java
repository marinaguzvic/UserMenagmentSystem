/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.data.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARINA
 */
@Entity
@Table(name = "account")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
//    , @NamedQuery(name = "Account.findByAccountId", query = "SELECT a FROM Account a WHERE a.accountId = :accountId")
//    , @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password")
//    , @NamedQuery(name = "Account.findByAccessToken", query = "SELECT a FROM Account a WHERE a.accessToken = :accessToken")
//    , @NamedQuery(name = "Account.findByPasswordResetToken", query = "SELECT a FROM Account a WHERE a.passwordResetToken = :passwordResetToken")
//    , @NamedQuery(name = "Account.findByEmailConfirmationToken", query = "SELECT a FROM Account a WHERE a.emailConfirmationToken = :emailConfirmationToken")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "password")
    private String password;
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "password_reset_token")
    private String passwordResetToken;
    @Column(name = "email_confirmation_token")
    private String emailConfirmationToken;
    @JoinColumn(name = "account_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Account() {
    }

    public Account(Long accountId) {
        this.accountId = accountId;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marina.repositoryusermenagmentsystem.data.model.Account[ accountId=" + accountId + " ]";
    }
    
}
