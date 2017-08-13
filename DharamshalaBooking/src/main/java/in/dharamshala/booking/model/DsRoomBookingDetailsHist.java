/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.dharamshala.booking.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anshujai
 */
@Entity
@Table(name = "DS_ROOM_BOOKING_DETAILS_HIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsRoomBookingDetailsHist.findAll", query = "SELECT d FROM DsRoomBookingDetailsHist d")
    , @NamedQuery(name = "DsRoomBookingDetailsHist.findByBookingId", query = "SELECT d FROM DsRoomBookingDetailsHist d WHERE d.dsRoomBookingDetailsHistPK.bookingId = :bookingId")
    , @NamedQuery(name = "DsRoomBookingDetailsHist.findByRoomNumber", query = "SELECT d FROM DsRoomBookingDetailsHist d WHERE d.dsRoomBookingDetailsHistPK.roomNumber = :roomNumber")
    , @NamedQuery(name = "DsRoomBookingDetailsHist.findByCustId", query = "SELECT d FROM DsRoomBookingDetailsHist d WHERE d.custId = :custId")
    , @NamedQuery(name = "DsRoomBookingDetailsHist.findByDsId", query = "SELECT d FROM DsRoomBookingDetailsHist d WHERE d.dsId = :dsId")
    , @NamedQuery(name = "DsRoomBookingDetailsHist.findByStatus", query = "SELECT d FROM DsRoomBookingDetailsHist d WHERE d.status = :status")
    , @NamedQuery(name = "DsRoomBookingDetailsHist.findByRoomTypeId", query = "SELECT d FROM DsRoomBookingDetailsHist d WHERE d.roomTypeId = :roomTypeId")
    , @NamedQuery(name = "DsRoomBookingDetailsHist.findByCheckIn", query = "SELECT d FROM DsRoomBookingDetailsHist d WHERE d.checkIn = :checkIn")
    , @NamedQuery(name = "DsRoomBookingDetailsHist.findByCheckOut", query = "SELECT d FROM DsRoomBookingDetailsHist d WHERE d.checkOut = :checkOut")
    , @NamedQuery(name = "DsRoomBookingDetailsHist.findByPrice", query = "SELECT d FROM DsRoomBookingDetailsHist d WHERE d.price = :price")
    , @NamedQuery(name = "DsRoomBookingDetailsHist.findByUserId", query = "SELECT d FROM DsRoomBookingDetailsHist d WHERE d.userId = :userId")
    , @NamedQuery(name = "DsRoomBookingDetailsHist.findByBookingDate", query = "SELECT d FROM DsRoomBookingDetailsHist d WHERE d.bookingDate = :bookingDate")
    , @NamedQuery(name = "DsRoomBookingDetailsHist.findByHistorisationDate", query = "SELECT d FROM DsRoomBookingDetailsHist d WHERE d.historisationDate = :historisationDate")})
public class DsRoomBookingDetailsHist implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DsRoomBookingDetailsHistPK dsRoomBookingDetailsHistPK;
    @Column(name = "CUST_ID")
    private Long custId;
    @Column(name = "DS_ID")
    private Long dsId;
    @Size(max = 10)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "ROOM_TYPE_ID")
    private Long roomTypeId;
    @Column(name = "CHECK_IN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkIn;
    @Column(name = "CHECK_OUT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;
    @Column(name = "PRICE")
    private Long price;
    @Size(max = 20)
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "BOOKING_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate;
    @Column(name = "HISTORISATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date historisationDate;
    @Size(max=1)
    @Column(name="BOOKING_FOR_SELF")
    private String bookingForSelf;
    public DsRoomBookingDetailsHist() {
    }

    public DsRoomBookingDetailsHist(DsRoomBookingDetailsHistPK dsRoomBookingDetailsHistPK) {
        this.dsRoomBookingDetailsHistPK = dsRoomBookingDetailsHistPK;
    }

    public DsRoomBookingDetailsHist(long bookingId, String roomNumber) {
        this.dsRoomBookingDetailsHistPK = new DsRoomBookingDetailsHistPK(bookingId, roomNumber);
    }

    public DsRoomBookingDetailsHistPK getDsRoomBookingDetailsHistPK() {
        return dsRoomBookingDetailsHistPK;
    }

    public void setDsRoomBookingDetailsHistPK(DsRoomBookingDetailsHistPK dsRoomBookingDetailsHistPK) {
        this.dsRoomBookingDetailsHistPK = dsRoomBookingDetailsHistPK;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Long getDsId() {
        return dsId;
    }

    public void setDsId(Long dsId) {
        this.dsId = dsId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getHistorisationDate() {
        return historisationDate;
    }

    public void setHistorisationDate(Date historisationDate) {
        this.historisationDate = historisationDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dsRoomBookingDetailsHistPK != null ? dsRoomBookingDetailsHistPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DsRoomBookingDetailsHist)) {
            return false;
        }
        DsRoomBookingDetailsHist other = (DsRoomBookingDetailsHist) object;
        if ((this.dsRoomBookingDetailsHistPK == null && other.dsRoomBookingDetailsHistPK != null) || (this.dsRoomBookingDetailsHistPK != null && !this.dsRoomBookingDetailsHistPK.equals(other.dsRoomBookingDetailsHistPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.smart.dsapp.model.DsRoomBookingDetailsHist[ dsRoomBookingDetailsHistPK=" + dsRoomBookingDetailsHistPK + " ]";
    }
    /**
	 * @return the bookingForSelf
	 */
	public String getBookingForSelf() {
		return bookingForSelf;
	}

	/**
	 * @param bookingForSelf the bookingForSelf to set
	 */
	public void setBookingForSelf(String bookingForSelf) {
		this.bookingForSelf = bookingForSelf;
	}
}
