/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.dharamshala.booking.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anshujai
 */
@Entity
@Table(name = "DS_ROOM_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsRoomMapping.findAll", query = "SELECT d FROM DsRoomMapping d")
    , @NamedQuery(name = "DsRoomMapping.findByRoomId", query = "SELECT d FROM DsRoomMapping d WHERE d.roomId = :roomId")
    , @NamedQuery(name = "DsRoomMapping.findByRoomNumber", query = "SELECT d FROM DsRoomMapping d WHERE d.roomNumber = :roomNumber")})
public class DsRoomMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROOM_ID")
    private Long roomId;
    @Size(max = 10)
    @Column(name = "ROOM_NUMBER")
    private String roomNumber;
    @JoinColumn(name = "DS_ID", referencedColumnName = "DS_ID")
    @ManyToOne
    private DsMaster dsId;
    @JoinColumn(name = "ROOM_TYPE_ID", referencedColumnName = "ROOM_TYPE_ID")
    @ManyToOne
    private DsRoomType roomTypeId;

    public DsRoomMapping() {
    }

    public DsRoomMapping(Long roomId) {
        this.roomId = roomId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
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
        hash += (roomId != null ? roomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DsRoomMapping)) {
            return false;
        }
        DsRoomMapping other = (DsRoomMapping) object;
        if ((this.roomId == null && other.roomId != null) || (this.roomId != null && !this.roomId.equals(other.roomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.smart.dsapp.model.DsRoomMapping[ roomId=" + roomId + " ]";
    }
    
}
