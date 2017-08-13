/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.dharamshala.booking.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anshujai
 */
@Entity
@Table(name = "DS_TRUSTY_TYPE_MASTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsTrustyTypeMaster.findAll", query = "SELECT d FROM DsTrustyTypeMaster d")
    , @NamedQuery(name = "DsTrustyTypeMaster.findByTrustyType", query = "SELECT d FROM DsTrustyTypeMaster d WHERE d.trustyType = :trustyType")
    , @NamedQuery(name = "DsTrustyTypeMaster.findByTrustyTypeName", query = "SELECT d FROM DsTrustyTypeMaster d WHERE d.trustyTypeName = :trustyTypeName")})
public class DsTrustyTypeMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRUSTY_TYPE")
    private Short trustyType;
    @Size(max = 20)
    @Column(name = "TRUSTY_TYPE_NAME")
    private String trustyTypeName;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "dsTrustyTypeMaster")
    private DsTrustyDetails dsTrustyDetails;

    public DsTrustyTypeMaster() {
    }

    public DsTrustyTypeMaster(Short trustyType) {
        this.trustyType = trustyType;
    }

    public Short getTrustyType() {
        return trustyType;
    }

    public void setTrustyType(Short trustyType) {
        this.trustyType = trustyType;
    }

    public String getTrustyTypeName() {
        return trustyTypeName;
    }

    public void setTrustyTypeName(String trustyTypeName) {
        this.trustyTypeName = trustyTypeName;
    }

    public DsTrustyDetails getDsTrustyDetails() {
        return dsTrustyDetails;
    }

    public void setDsTrustyDetails(DsTrustyDetails dsTrustyDetails) {
        this.dsTrustyDetails = dsTrustyDetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trustyType != null ? trustyType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DsTrustyTypeMaster)) {
            return false;
        }
        DsTrustyTypeMaster other = (DsTrustyTypeMaster) object;
        if ((this.trustyType == null && other.trustyType != null) || (this.trustyType != null && !this.trustyType.equals(other.trustyType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.smart.dsapp.model.DsTrustyTypeMaster[ trustyType=" + trustyType + " ]";
    }
    
}
