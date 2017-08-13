/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.dharamshala.booking.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anshujai
 */
@Entity
@Table(name = "DS_ROOM_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsRoomType.findAll", query = "SELECT d FROM DsRoomType d")
    , @NamedQuery(name = "DsRoomType.findByRoomTypeId", query = "SELECT d FROM DsRoomType d WHERE d.roomTypeId = :roomTypeId")
    , @NamedQuery(name = "DsRoomType.findByRoomCategory", query = "SELECT d FROM DsRoomType d WHERE d.roomCategory = :roomCategory")
    , @NamedQuery(name = "DsRoomType.findByMaxCapacity", query = "SELECT d FROM DsRoomType d WHERE d.maxCapacity = :maxCapacity")
    , @NamedQuery(name = "DsRoomType.findByNoOfRooms", query = "SELECT d FROM DsRoomType d WHERE d.noOfRooms = :noOfRooms")
    , @NamedQuery(name = "DsRoomType.findByFacility", query = "SELECT d FROM DsRoomType d WHERE d.facility = :facility")})
public class DsRoomType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROOM_TYPE_ID")
    private Long roomTypeId;
    @Size(max = 100)
    @Column(name = "ROOM_CATEGORY")
    private String roomCategory;
    @Column(name = "MAX_CAPACITY")
    private Long maxCapacity;
    @Column(name = "NO_OF_ROOMS")
    private Long noOfRooms;
    @Size(max = 50)
    @Column(name = "FACILITY")
    private String facility;
    @OneToMany(mappedBy = "roomTypeId")
    private Collection<DsRoomMapping> dsRoomMappingCollection;
    @OneToMany(mappedBy = "roomTypeId")
    private Collection<DsRoomPrice> dsRoomPriceCollection;
    @JoinColumn(name = "DS_ID", referencedColumnName = "DS_ID")
    @ManyToOne
    private DsMaster dsId;
    @OneToMany(mappedBy = "roomTypeId")
    private Collection<DsRoomBookingDetails> dsRoomBookingDetailsCollection;

    public DsRoomType() {
    }

    public DsRoomType(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public Long getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Long maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Long getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Long noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    @XmlTransient
    public Collection<DsRoomMapping> getDsRoomMappingCollection() {
        return dsRoomMappingCollection;
    }

    public void setDsRoomMappingCollection(Collection<DsRoomMapping> dsRoomMappingCollection) {
        this.dsRoomMappingCollection = dsRoomMappingCollection;
    }

    @XmlTransient
    public Collection<DsRoomPrice> getDsRoomPriceCollection() {
        return dsRoomPriceCollection;
    }

    public void setDsRoomPriceCollection(Collection<DsRoomPrice> dsRoomPriceCollection) {
        this.dsRoomPriceCollection = dsRoomPriceCollection;
    }

    public DsMaster getDsId() {
        return dsId;
    }

    public void setDsId(DsMaster dsId) {
        this.dsId = dsId;
    }

    @XmlTransient
    public Collection<DsRoomBookingDetails> getDsRoomBookingDetailsCollection() {
        return dsRoomBookingDetailsCollection;
    }

    public void setDsRoomBookingDetailsCollection(Collection<DsRoomBookingDetails> dsRoomBookingDetailsCollection) {
        this.dsRoomBookingDetailsCollection = dsRoomBookingDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomTypeId != null ? roomTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DsRoomType)) {
            return false;
        }
        DsRoomType other = (DsRoomType) object;
        if ((this.roomTypeId == null && other.roomTypeId != null) || (this.roomTypeId != null && !this.roomTypeId.equals(other.roomTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.restapp.model.DsRoomType[ roomTypeId=" + roomTypeId + " ]";
    }
    
}
