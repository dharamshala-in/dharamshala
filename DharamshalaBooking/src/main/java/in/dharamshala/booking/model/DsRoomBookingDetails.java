/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.dharamshala.booking.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author anshujai
 */
@Entity
@Table(name = "DS_ROOM_BOOKING_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsRoomBookingDetails.findAll", query = "SELECT d FROM DsRoomBookingDetails d")
    , @NamedQuery(name = "DsRoomBookingDetails.findByBookingId", query = "SELECT d FROM DsRoomBookingDetails d WHERE d.bookingId = :bookingId")
    , @NamedQuery(name = "DsRoomBookingDetails.findByRoomNumber", query = "SELECT d FROM DsRoomBookingDetails d WHERE d.roomNumber = :roomNumber")
    , @NamedQuery(name = "DsRoomBookingDetails.findByStatus", query = "SELECT d FROM DsRoomBookingDetails d WHERE d.status = :status")
    , @NamedQuery(name = "DsRoomBookingDetails.findByCheckIn", query = "SELECT d FROM DsRoomBookingDetails d WHERE d.checkIn = :checkIn")
    , @NamedQuery(name = "DsRoomBookingDetails.findByCheckOut", query = "SELECT d FROM DsRoomBookingDetails d WHERE d.checkOut = :checkOut")
    , @NamedQuery(name = "DsRoomBookingDetails.findByPrice", query = "SELECT d FROM DsRoomBookingDetails d WHERE d.price = :price")
    , @NamedQuery(name = "DsRoomBookingDetails.findByUserId", query = "SELECT d FROM DsRoomBookingDetails d WHERE d.ssoId = :ssoId")
    , @NamedQuery(name = "DsRoomBookingDetails.findByBookingDate", query = "SELECT d FROM DsRoomBookingDetails d WHERE d.bookingDate = :bookingDate")
    , @NamedQuery(name = "DsRoomBookingDetails.findByBookingForSelf", query = "SELECT d FROM DsRoomBookingDetails d WHERE d.bookingForSelf = :bookingForSelf")
    , @NamedQuery(name = "DsRoomBookingDetails.findByNoOfAdults", query = "SELECT d FROM DsRoomBookingDetails d WHERE d.noOfAdults = :noOfAdults")
    , @NamedQuery(name = "DsRoomBookingDetails.findByNoOfChilds", query = "SELECT d FROM DsRoomBookingDetails d WHERE d.noOfChilds = :noOfChilds")})
public class DsRoomBookingDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BookingIdGenerator")
	@SequenceGenerator(name="BookingIdGenerator",allocationSize=20, sequenceName="booking_seq")
    @Column(name = "BOOKING_ID")
    private Long bookingId; 
    
    @Size(max = 10)
    @Column(name = "STATUS")
    private String status;
    
    @Column(name = "CHECK_IN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkIn;
    
    @Column(name = "CHECK_OUT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;
    
    @Column(name = "PRICE")
    private Long price;
    
    @Size(max = 20)
    @Column(name = "SSO_ID")
    private String ssoId;
    
    @Column(name = "BOOKING_DATE")
    @Temporal(TemporalType.DATE)
    private Date bookingDate;
    
    @Size(max = 1)
    @Column(name = "BOOKING_FOR_SELF")
    private String bookingForSelf;
    
    @Column(name = "NO_OF_ADULTS")
    private Short noOfAdults;
    
    @Column(name = "NO_OF_CHILDS")
    private Short noOfChilds;
    
    @Column(name = "ROOM_NUMBER")
    private String roomNumber;
        
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dsRoomBookingDetails")
    private Collection<DsGuestDetails> dsGuestDetailsCollection = new ArrayList<>();
    
//    @JoinColumn(name = "DS_ID", referencedColumnName = "DS_ID")
//    @ManyToOne
//    private DsMaster dsId;
//    
//    @JoinColumn(name = "ROOM_TYPE_ID", referencedColumnName = "ROOM_TYPE_ID")
//    @ManyToOne
//    private DsRoomType roomTypeId;

    @Column(name = "DS_ID")
    private Long dsId;
    
    @Column(name = "ROOM_TYPE_ID")
    private Long roomTypeId;
    
    @Version
    @Column(name="VER_NO")
    private Long version;
    
    public DsRoomBookingDetails() {
    }
    
    public DsRoomBookingDetails(Long bookingId) {
        this.bookingId = bookingId;
    }

    public DsRoomBookingDetails(Long bookingId, String roomNumber) {
        this.bookingId = bookingId;
        this.roomNumber = roomNumber;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingForSelf() {
        return bookingForSelf;
    }

    public void setBookingForSelf(String bookingForSelf) {
        this.bookingForSelf = bookingForSelf;
    }

    public Short getNoOfAdults() {
        return noOfAdults;
    }

    public void setNoOfAdults(Short noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public Short getNoOfChilds() {
        return noOfChilds;
    }

    public void setNoOfChilds(Short noOfChilds) {
        this.noOfChilds = noOfChilds;
    }

    
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingId == null) ? 0 : bookingId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DsRoomBookingDetails other = (DsRoomBookingDetails) obj;
		if (bookingId == null) {
			if (other.bookingId != null)
				return false;
		} else if (!bookingId.equals(other.bookingId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DsRoomBookingDetails [bookingId=" + bookingId + "roomNumber=" +roomNumber + ", status=" + status + ", checkIn=" + checkIn
				+ ", checkOut=" + checkOut + ", price=" + price + ", ssoId=" + ssoId + ", bookingDate=" + bookingDate
				+ ", bookingForSelf=" + bookingForSelf + ", noOfAdults=" + noOfAdults + ", noOfChilds=" + noOfChilds
				+ ", dsGuestDetails=" + dsGuestDetailsCollection + ", dsId=" + dsId + ", roomTypeId="
				+ roomTypeId + "]";
	}

	/**
	 * @return the bookingId
	 */
	public Long getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	 @XmlTransient
	    public Collection<DsGuestDetails> getDsGuestDetailsCollection() {
	        return dsGuestDetailsCollection;
	    }

	    public void setDsGuestDetailsCollection(Collection<DsGuestDetails> dsGuestDetailsCollection) {
	        this.dsGuestDetailsCollection = dsGuestDetailsCollection;
	    }

	/**
	 * @return the dsId
	 */
	public Long getDsId() {
		return dsId;
	}

	/**
	 * @param dsId the dsId to set
	 */
	public void setDsId(Long dsId) {
		this.dsId = dsId;
	}

	/**
	 * @return the roomTypeId
	 */
	public Long getRoomTypeId() {
		return roomTypeId;
	}

	/**
	 * @param roomTypeId the roomTypeId to set
	 */
	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	/**
	 * @return the ssoId
	 */
	public String getSsoId() {
		return ssoId;
	}

	/**
	 * @param ssoId the ssoId to set
	 */
	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	/**
	 * @return the roomNumber
	 */
	public String getRoomNumber() {
		return roomNumber;
	}

	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
    
	public void addGuestDetails(DsGuestDetails guestDetails){
		this.dsGuestDetailsCollection.add(guestDetails);
	}
    
    
}
