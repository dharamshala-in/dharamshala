/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.dharamshala.booking.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anshujai
 */
@Entity
@Table(name = "DS_MASTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsMaster.findAll", query = "SELECT d FROM DsMaster d")
    , @NamedQuery(name = "DsMaster.findByDsId", query = "SELECT d FROM DsMaster d WHERE d.dsId = :dsId")
    , @NamedQuery(name = "DsMaster.findByDsName", query = "SELECT d FROM DsMaster d WHERE d.dsName = :dsName")
    , @NamedQuery(name = "DsMaster.findByDsAddress", query = "SELECT d FROM DsMaster d WHERE d.dsAddress = :dsAddress")
    , @NamedQuery(name = "DsMaster.findByDsCity", query = "SELECT d FROM DsMaster d WHERE d.dsCity = :dsCity")
    , @NamedQuery(name = "DsMaster.findByPincode", query = "SELECT d FROM DsMaster d WHERE d.pincode = :pincode")
    , @NamedQuery(name = "DsMaster.findByPhoneNo", query = "SELECT d FROM DsMaster d WHERE d.phoneNo = :phoneNo")
    , @NamedQuery(name = "DsMaster.findByState", query = "SELECT d FROM DsMaster d WHERE d.state = :state")
    , @NamedQuery(name = "DsMaster.findByCountry", query = "SELECT d FROM DsMaster d WHERE d.country = :country")
    , @NamedQuery(name = "DsMaster.findByCreatedDate", query = "SELECT d FROM DsMaster d WHERE d.createdDate = :createdDate")
    , @NamedQuery(name = "DsMaster.findByCreatedBy", query = "SELECT d FROM DsMaster d WHERE d.createdBy = :createdBy")
    , @NamedQuery(name = "DsMaster.findByDistrict", query = "SELECT d FROM DsMaster d WHERE d.district = :district")
    , @NamedQuery(name = "DsMaster.findByHasBhojanShala", query = "SELECT d FROM DsMaster d WHERE d.hasBhojanShala = :hasBhojanShala")})
public class DsMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DS_ID")
    private Long dsId;
    @Size(max = 100)
    @Column(name = "DS_NAME")
    private String dsName;
    @Size(max = 200)
    @Column(name = "DS_ADDRESS")
    private String dsAddress;
    @Size(max = 40)
    @Column(name = "DS_CITY")
    private String dsCity;
    @Size(max = 15)
    @Column(name = "PINCODE")
    private String pincode;
    @Column(name = "PHONE_NO")
    private Long phoneNo;
    @Size(max = 50)
    @Column(name = "STATE")
    private String state;
    @Size(max = 40)
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "CREATED_BY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdBy;
    @Size(max = 50)
    @Column(name = "DISTRICT")
    private String district;
    @Size(max = 1)
    @Column(name = "HAS_BHOJAN_SHALA")
    private String hasBhojanShala;
    @OneToMany(mappedBy = "dsId")
    private Collection<DsRoomType> dsRoomTypeCollection;
    @JoinColumn(name = "TIRTH_ID", referencedColumnName = "TIRTH_ID")
    @ManyToOne
    private DsTirthMaster tirthId;
    @OneToMany(mappedBy = "dsId")
    private Collection<DsRoomBookingDetails> dsRoomBookingDetailsCollection;

    public DsMaster() {
    }

    public DsMaster(Long dsId) {
        this.dsId = dsId;
    }

    public Long getDsId() {
        return dsId;
    }

    public void setDsId(Long dsId) {
        this.dsId = dsId;
    }

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public String getDsAddress() {
        return dsAddress;
    }

    public void setDsAddress(String dsAddress) {
        this.dsAddress = dsAddress;
    }

    public String getDsCity() {
        return dsCity;
    }

    public void setDsCity(String dsCity) {
        this.dsCity = dsCity;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Date createdBy) {
        this.createdBy = createdBy;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getHasBhojanShala() {
        return hasBhojanShala;
    }

    public void setHasBhojanShala(String hasBhojanShala) {
        this.hasBhojanShala = hasBhojanShala;
    }

    @XmlTransient
    public Collection<DsRoomType> getDsRoomTypeCollection() {
        return dsRoomTypeCollection;
    }

    public void setDsRoomTypeCollection(Collection<DsRoomType> dsRoomTypeCollection) {
        this.dsRoomTypeCollection = dsRoomTypeCollection;
    }

    public DsTirthMaster getTirthId() {
        return tirthId;
    }

    public void setTirthId(DsTirthMaster tirthId) {
        this.tirthId = tirthId;
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
        hash += (dsId != null ? dsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DsMaster)) {
            return false;
        }
        DsMaster other = (DsMaster) object;
        if ((this.dsId == null && other.dsId != null) || (this.dsId != null && !this.dsId.equals(other.dsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.dharamshala.booking.model.DsMaster[ dsId=" + dsId + " ]";
    }
    
}
