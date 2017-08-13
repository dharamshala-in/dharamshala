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
@Table(name = "DS_TIRTH_MASTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsTirthMaster.findAll", query = "SELECT d FROM DsTirthMaster d")
    , @NamedQuery(name = "DsTirthMaster.findByTirthId", query = "SELECT d FROM DsTirthMaster d WHERE d.tirthId = :tirthId")
    , @NamedQuery(name = "DsTirthMaster.findByTirthName", query = "SELECT d FROM DsTirthMaster d WHERE d.tirthName = :tirthName")
    , @NamedQuery(name = "DsTirthMaster.findByAddress", query = "SELECT d FROM DsTirthMaster d WHERE d.address = :address")
    , @NamedQuery(name = "DsTirthMaster.findByCity", query = "SELECT d FROM DsTirthMaster d WHERE d.city = :city")
    , @NamedQuery(name = "DsTirthMaster.findByState", query = "SELECT d FROM DsTirthMaster d WHERE d.state = :state")
    , @NamedQuery(name = "DsTirthMaster.findByCountry", query = "SELECT d FROM DsTirthMaster d WHERE d.country = :country")
    , @NamedQuery(name = "DsTirthMaster.findByKshetra", query = "SELECT d FROM DsTirthMaster d WHERE d.kshetra = :kshetra")
    , @NamedQuery(name = "DsTirthMaster.findByContactPerson", query = "SELECT d FROM DsTirthMaster d WHERE d.contactPerson = :contactPerson")
    , @NamedQuery(name = "DsTirthMaster.findByPhoneNumber1", query = "SELECT d FROM DsTirthMaster d WHERE d.phoneNumber1 = :phoneNumber1")
    , @NamedQuery(name = "DsTirthMaster.findByPhoneNumber2", query = "SELECT d FROM DsTirthMaster d WHERE d.phoneNumber2 = :phoneNumber2")
    , @NamedQuery(name = "DsTirthMaster.findByHasHospital", query = "SELECT d FROM DsTirthMaster d WHERE d.hasHospital = :hasHospital")
    , @NamedQuery(name = "DsTirthMaster.findByHasSchool", query = "SELECT d FROM DsTirthMaster d WHERE d.hasSchool = :hasSchool")
    , @NamedQuery(name = "DsTirthMaster.findByHasLibrary", query = "SELECT d FROM DsTirthMaster d WHERE d.hasLibrary = :hasLibrary")
    , @NamedQuery(name = "DsTirthMaster.findByNoOfTemples", query = "SELECT d FROM DsTirthMaster d WHERE d.noOfTemples = :noOfTemples")
    , @NamedQuery(name = "DsTirthMaster.findByHillsMountains", query = "SELECT d FROM DsTirthMaster d WHERE d.hillsMountains = :hillsMountains")
    , @NamedQuery(name = "DsTirthMaster.findByTirthHistory", query = "SELECT d FROM DsTirthMaster d WHERE d.tirthHistory = :tirthHistory")
    , @NamedQuery(name = "DsTirthMaster.findByOtherInformation", query = "SELECT d FROM DsTirthMaster d WHERE d.otherInformation = :otherInformation")
    , @NamedQuery(name = "DsTirthMaster.findByHasRailwayStation", query = "SELECT d FROM DsTirthMaster d WHERE d.hasRailwayStation = :hasRailwayStation")
    , @NamedQuery(name = "DsTirthMaster.findByHasBusStand", query = "SELECT d FROM DsTirthMaster d WHERE d.hasBusStand = :hasBusStand")
    , @NamedQuery(name = "DsTirthMaster.findByCommunity", query = "SELECT d FROM DsTirthMaster d WHERE d.community = :community")
    , @NamedQuery(name = "DsTirthMaster.findByHasAirport", query = "SELECT d FROM DsTirthMaster d WHERE d.hasAirport = :hasAirport")
    , @NamedQuery(name = "DsTirthMaster.findByEasiestWay", query = "SELECT d FROM DsTirthMaster d WHERE d.easiestWay = :easiestWay")
    , @NamedQuery(name = "DsTirthMaster.findByVersion", query = "SELECT d FROM DsTirthMaster d WHERE d.version = :version")})
public class DsTirthMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIRTH_ID")
    private Long tirthId;
    @Size(max = 100)
    @Column(name = "TIRTH_NAME")
    private String tirthName;
    @Size(max = 1000)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50)
    @Column(name = "CITY")
    private String city;
    @Size(max = 50)
    @Column(name = "STATE")
    private String state;
    @Size(max = 50)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 50)
    @Column(name = "KSHETRA")
    private String kshetra;
    @Size(max = 30)
    @Column(name = "CONTACT_PERSON")
    private String contactPerson;
    @Size(max = 200)
    @Column(name = "PHONE_NUMBER1")
    private String phoneNumber1;
    @Size(max = 100)
    @Column(name = "PHONE_NUMBER2")
    private String phoneNumber2;
    @Size(max = 1)
    @Column(name = "HAS_HOSPITAL")
    private String hasHospital;
    @Size(max = 1)
    @Column(name = "HAS_SCHOOL")
    private String hasSchool;
    @Size(max = 1)
    @Column(name = "HAS_LIBRARY")
    private String hasLibrary;
    @Column(name = "NO_OF_TEMPLES")
    private Long noOfTemples;
    @Size(max = 500)
    @Column(name = "HILLS_MOUNTAINS")
    private String hillsMountains;
    @Size(max = 500)
    @Column(name = "TIRTH_HISTORY")
    private String tirthHistory;
    @Size(max = 500)
    @Column(name = "OTHER_INFORMATION")
    private String otherInformation;
    @Size(max = 1)
    @Column(name = "HAS_RAILWAY_STATION")
    private String hasRailwayStation;
    @Size(max = 1)
    @Column(name = "HAS_BUS_STAND")
    private String hasBusStand;
    @Size(max = 50)
    @Column(name = "COMMUNITY")
    private String community;
    @Size(max = 1)
    @Column(name = "HAS_AIRPORT")
    private String hasAirport;
    @Size(max = 500)
    @Column(name = "EASIEST_WAY")
    private String easiestWay;
    @Column(name = "VERSION")
    private Long version;
    @OneToMany(mappedBy = "tirthId")
    private Collection<DsMaster> dsMasterCollection;

    public DsTirthMaster() {
    }

    public DsTirthMaster(Long tirthId) {
        this.tirthId = tirthId;
    }

    public Long getTirthId() {
        return tirthId;
    }

    public void setTirthId(Long tirthId) {
        this.tirthId = tirthId;
    }

    public String getTirthName() {
        return tirthName;
    }

    public void setTirthName(String tirthName) {
        this.tirthName = tirthName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getKshetra() {
        return kshetra;
    }

    public void setKshetra(String kshetra) {
        this.kshetra = kshetra;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getHasHospital() {
        return hasHospital;
    }

    public void setHasHospital(String hasHospital) {
        this.hasHospital = hasHospital;
    }

    public String getHasSchool() {
        return hasSchool;
    }

    public void setHasSchool(String hasSchool) {
        this.hasSchool = hasSchool;
    }

    public String getHasLibrary() {
        return hasLibrary;
    }

    public void setHasLibrary(String hasLibrary) {
        this.hasLibrary = hasLibrary;
    }

    public Long getNoOfTemples() {
        return noOfTemples;
    }

    public void setNoOfTemples(Long noOfTemples) {
        this.noOfTemples = noOfTemples;
    }

    public String getHillsMountains() {
        return hillsMountains;
    }

    public void setHillsMountains(String hillsMountains) {
        this.hillsMountains = hillsMountains;
    }

    public String getTirthHistory() {
        return tirthHistory;
    }

    public void setTirthHistory(String tirthHistory) {
        this.tirthHistory = tirthHistory;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }

    public String getHasRailwayStation() {
        return hasRailwayStation;
    }

    public void setHasRailwayStation(String hasRailwayStation) {
        this.hasRailwayStation = hasRailwayStation;
    }

    public String getHasBusStand() {
        return hasBusStand;
    }

    public void setHasBusStand(String hasBusStand) {
        this.hasBusStand = hasBusStand;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getHasAirport() {
        return hasAirport;
    }

    public void setHasAirport(String hasAirport) {
        this.hasAirport = hasAirport;
    }

    public String getEasiestWay() {
        return easiestWay;
    }

    public void setEasiestWay(String easiestWay) {
        this.easiestWay = easiestWay;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @XmlTransient
    public Collection<DsMaster> getDsMasterCollection() {
        return dsMasterCollection;
    }

    public void setDsMasterCollection(Collection<DsMaster> dsMasterCollection) {
        this.dsMasterCollection = dsMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tirthId != null ? tirthId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DsTirthMaster)) {
            return false;
        }
        DsTirthMaster other = (DsTirthMaster) object;
        if ((this.tirthId == null && other.tirthId != null) || (this.tirthId != null && !this.tirthId.equals(other.tirthId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.dharamshala.booking.model.DsTirthMaster[ tirthId=" + tirthId + " ]";
    }
    
}
