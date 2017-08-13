/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.dharamshala.booking.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author anshujai
 */
@Embeddable
public class DsRoomBookingDetailsHistPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOKING_ID")
    private long bookingId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ROOM_NUMBER")
    private String roomNumber;

    public DsRoomBookingDetailsHistPK() {
    }

    public DsRoomBookingDetailsHistPK(long bookingId, String roomNumber) {
        this.bookingId = bookingId;
        this.roomNumber = roomNumber;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) bookingId;
        hash += (roomNumber != null ? roomNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DsRoomBookingDetailsHistPK)) {
            return false;
        }
        DsRoomBookingDetailsHistPK other = (DsRoomBookingDetailsHistPK) object;
        if (this.bookingId != other.bookingId) {
            return false;
        }
        if ((this.roomNumber == null && other.roomNumber != null) || (this.roomNumber != null && !this.roomNumber.equals(other.roomNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.smart.dsapp.model.DsRoomBookingDetailsHistPK[ bookingId=" + bookingId + ", roomNumber=" + roomNumber + " ]";
    }
    
}
