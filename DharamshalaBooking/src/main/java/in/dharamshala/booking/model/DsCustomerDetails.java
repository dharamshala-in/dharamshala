/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.dharamshala.booking.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anshujai
 */
@Entity
@Table(name = "DS_CUSTOMER_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsCustomerDetails.findAll", query = "SELECT d FROM DsCustomerDetails d")
    , @NamedQuery(name = "DsCustomerDetails.findByCustId", query = "SELECT d FROM DsCustomerDetails d WHERE d.custId = :custId")
    , @NamedQuery(name = "DsCustomerDetails.findByUserFirstName", query = "SELECT d FROM DsCustomerDetails d WHERE d.userFirstName = :userFirstName")
    , @NamedQuery(name = "DsCustomerDetails.findByUserLastName", query = "SELECT d FROM DsCustomerDetails d WHERE d.userLastName = :userLastName")
    , @NamedQuery(name = "DsCustomerDetails.findByEmailId", query = "SELECT d FROM DsCustomerDetails d WHERE d.emailId = :emailId")
    , @NamedQuery(name = "DsCustomerDetails.findByMobileNo", query = "SELECT d FROM DsCustomerDetails d WHERE d.mobileNo = :mobileNo")
    , @NamedQuery(name = "DsCustomerDetails.findByPhoneNo", query = "SELECT d FROM DsCustomerDetails d WHERE d.phoneNo = :phoneNo")
    , @NamedQuery(name = "DsCustomerDetails.findByIdType", query = "SELECT d FROM DsCustomerDetails d WHERE d.idType = :idType")
    , @NamedQuery(name = "DsCustomerDetails.findByIdNumber", query = "SELECT d FROM DsCustomerDetails d WHERE d.idNumber = :idNumber")
    , @NamedQuery(name = "DsCustomerDetails.findByDob", query = "SELECT d FROM DsCustomerDetails d WHERE d.dob = :dob")
    , @NamedQuery(name = "DsCustomerDetails.findByAddressLine1", query = "SELECT d FROM DsCustomerDetails d WHERE d.addressLine1 = :addressLine1")
    , @NamedQuery(name = "DsCustomerDetails.findByAddressLine2", query = "SELECT d FROM DsCustomerDetails d WHERE d.addressLine2 = :addressLine2")
    , @NamedQuery(name = "DsCustomerDetails.findByPincode", query = "SELECT d FROM DsCustomerDetails d WHERE d.pincode = :pincode")
    , @NamedQuery(name = "DsCustomerDetails.findByState", query = "SELECT d FROM DsCustomerDetails d WHERE d.state = :state")
    , @NamedQuery(name = "DsCustomerDetails.findByCountry", query = "SELECT d FROM DsCustomerDetails d WHERE d.country = :country")
    , @NamedQuery(name = "DsCustomerDetails.findByCreatedDate", query = "SELECT d FROM DsCustomerDetails d WHERE d.createdDate = :createdDate")
    , @NamedQuery(name = "DsCustomerDetails.findByCreatedBy", query = "SELECT d FROM DsCustomerDetails d WHERE d.createdBy = :createdBy")
    , @NamedQuery(name = "DsCustomerDetails.findByCity", query = "SELECT d FROM DsCustomerDetails d WHERE d.city = :city")})
public class DsCustomerDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUST_ID")
    private Long custId;
    @Size(max = 50)
    @Column(name = "USER_FIRST_NAME")
    private String userFirstName;
    @Size(max = 50)
    @Column(name = "USER_LAST_NAME")
    private String userLastName;
    @Size(max = 100)
    @Column(name = "EMAIL_ID")
    private String emailId;
    @Column(name = "MOBILE_NO")
    private Long mobileNo;
    @Column(name = "PHONE_NO")
    private Long phoneNo;
    @Column(name = "ID_TYPE")
    private Long idType;
    @Size(max = 25)
    @Column(name = "ID_NUMBER")
    private String idNumber;
    @Column(name = "DOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Size(max = 100)
    @Column(name = "ADDRESS_LINE1")
    private String addressLine1;
    @Size(max = 100)
    @Column(name = "ADDRESS_LINE2")
    private String addressLine2;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PINCODE")
    private BigDecimal pincode;
    @Size(max = 40)
    @Column(name = "STATE")
    private String state;
    @Size(max = 30)
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 30)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Size(max = 30)
    @Column(name = "CITY")
    private String city;
    

    @Size(max = 30)
    @Column(name = "USER_NAME")
    private String userName;
    
    public DsCustomerDetails() {
    }

    public DsCustomerDetails(Long custId) {
        this.custId = custId;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custId != null ? custId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DsCustomerDetails)) {
            return false;
        }
        DsCustomerDetails other = (DsCustomerDetails) object;
        if ((this.custId == null && other.custId != null) || (this.custId != null && !this.custId.equals(other.custId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.dharamshala.booking.model.DsCustomerDetails[ custId=" + custId + " ]";
    }

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
    
}
