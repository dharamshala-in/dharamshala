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
@Table(name = "DS_ID_MASTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsIdMaster.findAll", query = "SELECT d FROM DsIdMaster d")
    , @NamedQuery(name = "DsIdMaster.findByIdType", query = "SELECT d FROM DsIdMaster d WHERE d.idType = :idType")
    , @NamedQuery(name = "DsIdMaster.findByIdName", query = "SELECT d FROM DsIdMaster d WHERE d.idName = :idName")})
public class DsIdMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TYPE")
    private Short idType;
    @Size(max = 20)
    @Column(name = "ID_NAME")
    private String idName;

    public DsIdMaster() {
    }

    public DsIdMaster(Short idType) {
        this.idType = idType;
    }

    public Short getIdType() {
        return idType;
    }

    public void setIdType(Short idType) {
        this.idType = idType;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idType != null ? idType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DsIdMaster)) {
            return false;
        }
        DsIdMaster other = (DsIdMaster) object;
        if ((this.idType == null && other.idType != null) || (this.idType != null && !this.idType.equals(other.idType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.smart.dsapp.model.DsIdMaster[ idType=" + idType + " ]";
    }
    
}
