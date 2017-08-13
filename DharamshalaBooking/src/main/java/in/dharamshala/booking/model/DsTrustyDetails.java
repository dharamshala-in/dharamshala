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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "DS_TRUSTY_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsTrustyDetails.findAll", query = "SELECT d FROM DsTrustyDetails d")
    , @NamedQuery(name = "DsTrustyDetails.findByTrustyId", query = "SELECT d FROM DsTrustyDetails d WHERE d.trustyId = :trustyId")
    , @NamedQuery(name = "DsTrustyDetails.findByTruestyName", query = "SELECT d FROM DsTrustyDetails d WHERE d.truestyName = :truestyName")
    , @NamedQuery(name = "DsTrustyDetails.findByAddressLine1", query = "SELECT d FROM DsTrustyDetails d WHERE d.addressLine1 = :addressLine1")
    , @NamedQuery(name = "DsTrustyDetails.findByAddressLine2", query = "SELECT d FROM DsTrustyDetails d WHERE d.addressLine2 = :addressLine2")
    , @NamedQuery(name = "DsTrustyDetails.findByPincode", query = "SELECT d FROM DsTrustyDetails d WHERE d.pincode = :pincode")
    , @NamedQuery(name = "DsTrustyDetails.findByState", query = "SELECT d FROM DsTrustyDetails d WHERE d.state = :state")
    , @NamedQuery(name = "DsTrustyDetails.findByCountry", query = "SELECT d FROM DsTrustyDetails d WHERE d.country = :country")
    , @NamedQuery(name = "DsTrustyDetails.findByCreatedDate", query = "SELECT d FROM DsTrustyDetails d WHERE d.createdDate = :createdDate")
    , @NamedQuery(name = "DsTrustyDetails.findByCreatedTime", query = "SELECT d FROM DsTrustyDetails d WHERE d.createdTime = :createdTime")
    , @NamedQuery(name = "DsTrustyDetails.findByCity", query = "SELECT d FROM DsTrustyDetails d WHERE d.city = :city")
    , @NamedQuery(name = "DsTrustyDetails.findByMobileNo", query = "SELECT d FROM DsTrustyDetails d WHERE d.mobileNo = :mobileNo")
    , @NamedQuery(name = "DsTrustyDetails.findByPhoneNo", query = "SELECT d FROM DsTrustyDetails d WHERE d.phoneNo = :phoneNo")
    , @NamedQuery(name = "DsTrustyDetails.findByTrustyTypeId", query = "SELECT d FROM DsTrustyDetails d WHERE d.trustyTypeId = :trustyTypeId")})
public class DsTrustyDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRUSTY_ID")
    private Long trustyId;
    @Size(max = 20)
    @Column(name = "TRUESTY_NAME")
    private String truestyName;
    @Size(max = 50)
    @Column(name = "ADDRESS_LINE1")
    private String addressLine1;
    @Size(max = 50)
    @Column(name = "ADDRESS_LINE2")
    private String addressLine2;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PINCODE")
    private BigDecimal pincode;
    @Size(max = 30)
    @Column(name = "STATE")
    private String state;
    @Size(max = 30)
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "CREATED_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Size(max = 20)
    @Column(name = "CITY")
    private String city;
    @Column(name = "MOBILE_NO")
    private BigInteger mobileNo;
    @Column(name = "PHONE_NO")
    private BigInteger phoneNo;
    @Column(name = "TRUSTY_TYPE_ID")
    private Short trustyTypeId;
    @JoinColumn(name = "DS_ID", referencedColumnName = "DS_ID")
    @ManyToOne
    private DsMaster dsId;
    @JoinColumn(name = "TRUSTY_ID", referencedColumnName = "TRUSTY_TYPE", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private DsTrustyTypeMaster dsTrustyTypeMaster;

    public DsTrustyDetails() {
    }

    public DsTrustyDetails(Long trustyId) {
        this.trustyId = trustyId;
    }

    public Long getTrustyId() {
        return trustyId;
    }

    public void setTrustyId(Long trustyId) {
        this.trustyId = trustyId;
    }

    public String getTruestyName() {
        return truestyName;
    }

    public void setTruestyName(String truestyName) {
        this.truestyName = truestyName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public BigDecimal getPincode() {
        return pincode;
    }

    public void setPincode(BigDecimal pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigInteger getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(BigInteger mobileNo) {
        this.mobileNo = mobileNo;
    }

    public BigInteger getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(BigInteger phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Short getTrustyTypeId() {
        return trustyTypeId;
    }

    public void setTrustyTypeId(Short trustyTypeId) {
        this.trustyTypeId = trustyTypeId;
    }

    public DsMaster getDsId() {
        return dsId;
    }

    public void setDsId(DsMaster dsId) {
        this.dsId = dsId;
    }

    public DsTrustyTypeMaster getDsTrustyTypeMaster() {
        return dsTrustyTypeMaster;
    }

    public void setDsTrustyTypeMaster(DsTrustyTypeMaster dsTrustyTypeMaster) {
        this.dsTrustyTypeMaster = dsTrustyTypeMaster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trustyId != null ? trustyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DsTrustyDetails)) {
            return false;
        }
        DsTrustyDetails other = (DsTrustyDetails) object;
        if ((this.trustyId == null && other.trustyId != null) || (this.trustyId != null && !this.trustyId.equals(other.trustyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.smart.dsapp.model.DsTrustyDetails[ trustyId=" + trustyId + " ]";
    }
    
}
