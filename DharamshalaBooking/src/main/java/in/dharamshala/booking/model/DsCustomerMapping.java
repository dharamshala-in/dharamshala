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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anshujai
 */
@Entity
@Table(name = "DS_CUSTOMER_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsCustomerMapping.findAll", query = "SELECT d FROM DsCustomerMapping d")
    , @NamedQuery(name = "DsCustomerMapping.findById", query = "SELECT d FROM DsCustomerMapping d WHERE d.id = :id")
    , @NamedQuery(name = "DsCustomerMapping.findByUserId", query = "SELECT d FROM DsCustomerMapping d WHERE d.userId = :userId")})
public class DsCustomerMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "USER_ID")
    private Long userId;
    @JoinColumn(name = "DS_ID", referencedColumnName = "DS_ID")
    @ManyToOne
    private DsMaster dsId;

    public DsCustomerMapping() {
    }

    public DsCustomerMapping(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public DsMaster getDsId() {
        return dsId;
    }

    public void setDsId(DsMaster dsId) {
        this.dsId = dsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DsCustomerMapping)) {
            return false;
        }
        DsCustomerMapping other = (DsCustomerMapping) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.smart.dsapp.model.DsCustomerMapping[ id=" + id + " ]";
    }
    
}
