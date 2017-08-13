/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.dharamshala.booking.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "DS_GUEST_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsGuestDetails.findAll", query = "SELECT d FROM DsGuestDetails d")
    , @NamedQuery(name = "DsGuestDetails.findByGuestId", query = "SELECT d FROM DsGuestDetails d WHERE d.guestId = :guestId")
    , @NamedQuery(name = "DsGuestDetails.findByEmailId", query = "SELECT d FROM DsGuestDetails d WHERE d.emailId = :emailId")
    , @NamedQuery(name = "DsGuestDetails.findByMobileNo", query = "SELECT d FROM DsGuestDetails d WHERE d.mobileNo = :mobileNo")
    , @NamedQuery(name = "DsGuestDetails.findByPhoneNo", query = "SELECT d FROM DsGuestDetails d WHERE d.phoneNo = :phoneNo")
    , @NamedQuery(name = "DsGuestDetails.findByIdType", query = "SELECT d FROM DsGuestDetails d WHERE d.idType = :idType")
    , @NamedQuery(name = "DsGuestDetails.findByIdNumber", query = "SELECT d FROM DsGuestDetails d WHERE d.idNumber = :idNumber")
    , @NamedQuery(name = "DsGuestDetails.findByDob", query = "SELECT d FROM DsGuestDetails d WHERE d.dob = :dob")
    , @NamedQuery(name = "DsGuestDetails.findByCountry", query = "SELECT d FROM DsGuestDetails d WHERE d.country = :country")
    , @NamedQuery(name = "DsGuestDetails.findByCreatedDate", query = "SELECT d FROM DsGuestDetails d WHERE d.createdDate = :createdDate")
    , @NamedQuery(name = "DsGuestDetails.findByCreatedBy", query = "SELECT d FROM DsGuestDetails d WHERE d.createdBy = :createdBy")
    , @NamedQuery(name = "DsGuestDetails.findByCity", query = "SELECT d FROM DsGuestDetails d WHERE d.city = :city")})
public class DsGuestDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GuestIdGenerator")
	@SequenceGenerator(name="GuestIdGenerator",allocationSize=1, sequenceName="GUEST_SEQ")
    @Column(name = "GUEST_ID")
    private Long guestId;
    @Size(max = 100)
    @Column(name = "GUEST_NAME")
    private String guestName;
    @Size(max = 100)
    @Column(name = "EMAIL_ID")
    private String emailId;
    @Column(name = "MOBILE_NO")
    private Long mobileNo;
    @Column(name = "PHONE_NO")
    private Long phoneNo;
    @Size(max = 30)
    @Column(name = "ID_TYPE")
    private String idType;
    @Size(max = 50)
    @Column(name = "ID_NUMBER")
    private String idNumber;
    @Size(max = 3)
    @Column(name = "DOB")
    private String dob;
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
    
    @JoinColumn(name = "BOOKING_ID",nullable=false)
    @ManyToOne(optional = false)
    private DsRoomBookingDetails dsRoomBookingDetails;

    

    public DsGuestDetails() {
    }

    public DsGuestDetails(Long guestId) {
        this.guestId = guestId;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
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

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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

    /**
	 * @return the dsRoomBookingDetails
	 */
	public DsRoomBookingDetails getDsRoomBookingDetails() {
		return dsRoomBookingDetails;
	}

	/**
	 * @param dsRoomBookingDetails the dsRoomBookingDetails to set
	 */
	public void setDsRoomBookingDetails(DsRoomBookingDetails dsRoomBookingDetails) {
		this.dsRoomBookingDetails = dsRoomBookingDetails;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guestId != null ? guestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DsGuestDetails)) {
            return false;
        }
        DsGuestDetails other = (DsGuestDetails) object;
        if ((this.guestId == null && other.guestId != null) || (this.guestId != null && !this.guestId.equals(other.guestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.dharamshala.booking.model.DsGuestDetails[ guestId=" + guestId + " ]";
    }

	/**
	 * @return the guestName
	 */
	public String getGuestName() {
		return guestName;
	}

	/**
	 * @param guestName the guestName to set
	 */
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
    
}
