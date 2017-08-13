/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.dharamshala.booking.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anshujai
 */
@Entity
@Table(name = "DS_USER_LOGIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsUserLogin.findAll", query = "SELECT d FROM DsUserLogin d")
    , @NamedQuery(name = "DsUserLogin.findByUserId", query = "SELECT d FROM DsUserLogin d WHERE d.userId = :userId")
    , @NamedQuery(name = "DsUserLogin.findByUserName", query = "SELECT d FROM DsUserLogin d WHERE d.userName = :userName")
    , @NamedQuery(name = "DsUserLogin.findByPassword", query = "SELECT d FROM DsUserLogin d WHERE d.password = :password")
    , @NamedQuery(name = "DsUserLogin.findByActive", query = "SELECT d FROM DsUserLogin d WHERE d.active = :active")
    , @NamedQuery(name = "DsUserLogin.findByUserType", query = "SELECT d FROM DsUserLogin d WHERE d.userType = :userType")
    , @NamedQuery(name = "DsUserLogin.findByRefId", query = "SELECT d FROM DsUserLogin d WHERE d.refId = :refId")
    , @NamedQuery(name = "DsUserLogin.findByPasswordHint", query = "SELECT d FROM DsUserLogin d WHERE d.passwordHint = :passwordHint")
    , @NamedQuery(name = "DsUserLogin.findByLastLogin", query = "SELECT d FROM DsUserLogin d WHERE d.lastLogin = :lastLogin")})
public class DsUserLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private BigDecimal userId;
    @Size(max = 20)
    @Column(name = "USER_NAME")
    private String userName;
    @Size(max = 100)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 1)
    @Column(name = "ACTIVE")
    private String active;
    @Size(max = 1)
    @Column(name = "USER_TYPE")
    private String userType;
    @Column(name = "REF_ID")
    private BigInteger refId;
    @Size(max = 100)
    @Column(name = "PASSWORD_HINT")
    private String passwordHint;
    @Column(name = "LAST_LOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    public DsUserLogin() {
    }

    public DsUserLogin(BigDecimal userId) {
        this.userId = userId;
    }

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public BigInteger getRefId() {
        return refId;
    }

    public void setRefId(BigInteger refId) {
        this.refId = refId;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DsUserLogin)) {
            return false;
        }
        DsUserLogin other = (DsUserLogin) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.smart.dsapp.model.DsUserLogin[ userId=" + userId + " ]";
    }
    
}
