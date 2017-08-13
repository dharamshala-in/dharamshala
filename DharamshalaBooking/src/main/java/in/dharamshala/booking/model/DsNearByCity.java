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
@Table(name = "DS_NEAR_BY_CITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsNearByCity.findAll", query = "SELECT d FROM DsNearByCity d")
    , @NamedQuery(name = "DsNearByCity.findByCity", query = "SELECT d FROM DsNearByCity d WHERE d.city = :city")
    , @NamedQuery(name = "DsNearByCity.findByState", query = "SELECT d FROM DsNearByCity d WHERE d.state = :state")
    , @NamedQuery(name = "DsNearByCity.findByCountry", query = "SELECT d FROM DsNearByCity d WHERE d.country = :country")
    , @NamedQuery(name = "DsNearByCity.findByDistance", query = "SELECT d FROM DsNearByCity d WHERE d.distance = :distance")
    , @NamedQuery(name = "DsNearByCity.findByNoOfTemples", query = "SELECT d FROM DsNearByCity d WHERE d.noOfTemples = :noOfTemples")
    , @NamedQuery(name = "DsNearByCity.findByHasRailwayStation", query = "SELECT d FROM DsNearByCity d WHERE d.hasRailwayStation = :hasRailwayStation")
    , @NamedQuery(name = "DsNearByCity.findByHasBusStand", query = "SELECT d FROM DsNearByCity d WHERE d.hasBusStand = :hasBusStand")
    , @NamedQuery(name = "DsNearByCity.findByHasAirport", query = "SELECT d FROM DsNearByCity d WHERE d.hasAirport = :hasAirport")
    , @NamedQuery(name = "DsNearByCity.findByHasDharamshala", query = "SELECT d FROM DsNearByCity d WHERE d.hasDharamshala = :hasDharamshala")
    , @NamedQuery(name = "DsNearByCity.findByIsShetra", query = "SELECT d FROM DsNearByCity d WHERE d.isShetra = :isShetra")
    , @NamedQuery(name = "DsNearByCity.findByIsCity", query = "SELECT d FROM DsNearByCity d WHERE d.isCity = :isCity")
    , @NamedQuery(name = "DsNearByCity.findByDistrict", query = "SELECT d FROM DsNearByCity d WHERE d.district = :district")
    , @NamedQuery(name = "DsNearByCity.findByCityId", query = "SELECT d FROM DsNearByCity d WHERE d.cityId = :cityId")})
public class DsNearByCity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 40)
    @Column(name = "CITY")
    private String city;
    @Size(max = 50)
    @Column(name = "STATE")
    private String state;
    @Size(max = 20)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 40)
    @Column(name = "DISTANCE")
    private String distance;
    @Column(name = "NO_OF_TEMPLES")
    private Long noOfTemples;
    @Size(max = 1)
    @Column(name = "HAS_RAILWAY_STATION")
    private String hasRailwayStation;
    @Size(max = 1)
    @Column(name = "HAS_BUS_STAND")
    private String hasBusStand;
    @Size(max = 1)
    @Column(name = "HAS_AIRPORT")
    private String hasAirport;
    @Size(max = 1)
    @Column(name = "HAS_DHARAMSHALA")
    private String hasDharamshala;
    @Size(max = 1)
    @Column(name = "IS_SHETRA")
    private String isShetra;
    @Size(max = 1)
    @Column(name = "IS_CITY")
    private String isCity;
    @Size(max = 40)
    @Column(name = "DISTRICT")
    private String district;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CITY_ID")
    private Long cityId;
    @JoinColumn(name = "TIRTH_ID", referencedColumnName = "TIRTH_ID")
    @ManyToOne
    private Tirth tirthId;

    public DsNearByCity() {
    }

    public DsNearByCity(Long cityId) {
        this.cityId = cityId;
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Long getNoOfTemples() {
        return noOfTemples;
    }

    public void setNoOfTemples(Long noOfTemples) {
        this.noOfTemples = noOfTemples;
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

    public String getHasAirport() {
        return hasAirport;
    }

    public void setHasAirport(String hasAirport) {
        this.hasAirport = hasAirport;
    }

    public String getHasDharamshala() {
        return hasDharamshala;
    }

    public void setHasDharamshala(String hasDharamshala) {
        this.hasDharamshala = hasDharamshala;
    }

    public String getIsShetra() {
        return isShetra;
    }

    public void setIsShetra(String isShetra) {
        this.isShetra = isShetra;
    }

    public String getIsCity() {
        return isCity;
    }

    public void setIsCity(String isCity) {
        this.isCity = isCity;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Tirth getTirthId() {
        return tirthId;
    }

    public void setTirthId(Tirth tirthId) {
        this.tirthId = tirthId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DsNearByCity)) {
            return false;
        }
        DsNearByCity other = (DsNearByCity) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.smart.dsapp.model.DsNearByCity[ cityId=" + cityId + " ]";
    }
    
}
