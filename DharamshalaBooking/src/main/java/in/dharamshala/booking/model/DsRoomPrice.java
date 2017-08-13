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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DS_ROOM_PRICE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsRoomPrice.findAll", query = "SELECT d FROM DsRoomPrice d")
    , @NamedQuery(name = "DsRoomPrice.findByPrice", query = "SELECT d FROM DsRoomPrice d WHERE d.price = :price")
    , @NamedQuery(name = "DsRoomPrice.findByCreateDate", query = "SELECT d FROM DsRoomPrice d WHERE d.createDate = :createDate")
    , @NamedQuery(name = "DsRoomPrice.findByCreatedBy", query = "SELECT d FROM DsRoomPrice d WHERE d.createdBy = :createdBy")
    , @NamedQuery(name = "DsRoomPrice.findByRoomPriceId", query = "SELECT d FROM DsRoomPrice d WHERE d.roomPriceId = :roomPriceId")})
public class DsRoomPrice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "PRICE")
    private Long price;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 30)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROOM_PRICE_ID")
    private Long roomPriceId;
    @JoinColumn(name = "DS_ID", referencedColumnName = "DS_ID")
    @ManyToOne(optional = false)
    private DsMaster dsId;
    @JoinColumn(name = "ROOM_TYPE_ID", referencedColumnName = "ROOM_TYPE_ID")
    @ManyToOne
    private DsRoomType roomTypeId;

    public DsRoomPrice() {
    }

    public DsRoomPrice(Long roomPriceId) {
        this.roomPriceId = roomPriceId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getRoomPriceId() {
        return roomPriceId;
    }

    public void setRoomPriceId(Long roomPriceId) {
        this.roomPriceId = roomPriceId;
    }

    public DsMaster getDsId() {
        return dsId;
    }

    public void setDsId(DsMaster dsId) {
        this.dsId = dsId;
    }

    public DsRoomType getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(DsRoomType roomTypeId) {
        this.roomTypeId = roomTypeId;
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
        if (!(object instanceof DsRoomPrice)) {
            return false;
        }
        DsRoomPrice other = (DsRoomPrice) object;
        if ((this.roomPriceId == null && other.roomPriceId != null) || (this.roomPriceId != null && !this.roomPriceId.equals(other.roomPriceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.smart.dsapp.model.DsRoomPrice[ roomPriceId=" + roomPriceId + " ]";
    }
    
}
