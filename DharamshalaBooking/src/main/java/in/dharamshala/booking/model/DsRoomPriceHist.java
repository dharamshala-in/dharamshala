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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anshujai
 */
@Entity
@Table(name = "DS_ROOM_PRICE_HIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsRoomPriceHist.findAll", query = "SELECT d FROM DsRoomPriceHist d")
    , @NamedQuery(name = "DsRoomPriceHist.findByDsId", query = "SELECT d FROM DsRoomPriceHist d WHERE d.dsId = :dsId")
    , @NamedQuery(name = "DsRoomPriceHist.findByRoomTypeId", query = "SELECT d FROM DsRoomPriceHist d WHERE d.roomTypeId = :roomTypeId")
    , @NamedQuery(name = "DsRoomPriceHist.findByPrice", query = "SELECT d FROM DsRoomPriceHist d WHERE d.price = :price")
    , @NamedQuery(name = "DsRoomPriceHist.findByStartDate", query = "SELECT d FROM DsRoomPriceHist d WHERE d.startDate = :startDate")
    , @NamedQuery(name = "DsRoomPriceHist.findByEndDate", query = "SELECT d FROM DsRoomPriceHist d WHERE d.endDate = :endDate")
    , @NamedQuery(name = "DsRoomPriceHist.findByRoomPriceId", query = "SELECT d FROM DsRoomPriceHist d WHERE d.roomPriceId = :roomPriceId")})
public class DsRoomPriceHist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "DS_ID")
    private Long dsId;
    @Column(name = "ROOM_TYPE_ID")
    private Long roomTypeId;
    @Column(name = "PRICE")
    private Long price;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROOM_PRICE_ID")
    private Long roomPriceId;

    public DsRoomPriceHist() {
    }

    public DsRoomPriceHist(Long roomPriceId) {
        this.roomPriceId = roomPriceId;
    }

    public Long getDsId() {
        return dsId;
    }

    public void setDsId(Long dsId) {
        this.dsId = dsId;
    }

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getRoomPriceId() {
        return roomPriceId;
    }

    public void setRoomPriceId(Long roomPriceId) {
        this.roomPriceId = roomPriceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomPriceId != null ? roomPriceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DsRoomPriceHist)) {
            return false;
        }
        DsRoomPriceHist other = (DsRoomPriceHist) object;
        if ((this.roomPriceId == null && other.roomPriceId != null) || (this.roomPriceId != null && !this.roomPriceId.equals(other.roomPriceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.smart.dsapp.model.DsRoomPriceHist[ roomPriceId=" + roomPriceId + " ]";
    }
    
}
