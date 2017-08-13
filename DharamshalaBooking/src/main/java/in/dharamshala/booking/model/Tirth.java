package in.dharamshala.booking.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="DS_TIRTH_MASTER")
public class Tirth implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
	@Column(name="TIRTH_ID")
	private Long tirthId;
	
	@NotEmpty
	@Column(name="TIRTH_NAME")
	private String tirthName;
	
	@Size(max = 255)
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
    @Size(max = 20)
    @Column(name = "KSHETRA")
    private String kshetra;
    @Size(max = 30)
    @Column(name = "CONTACT_PERSON")
    private String contactPerson;
    @Column(name = "PHONE_NUMBER1")
    private Long phoneNumber1;
    @Column(name = "PHONE_NUMBER2")
    private Long phoneNumber2;
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
    
    
    
    /**
	 * @return the hasAirport
	 */
	public String getHasAirport() {
		return hasAirport;
	}

	/**
	 * @param hasAirport the hasAirport to set
	 */
	public void setHasAirport(String hasAirport) {
		this.hasAirport = hasAirport;
	}

	/**
	 * @return the easiestWay
	 */
	public String getEasiestWay() {
		return easiestWay;
	}

	/**
	 * @param easiestWay the easiestWay to set
	 */
	public void setEasiestWay(String easiestWay) {
		this.easiestWay = easiestWay;
	}

	/**
	 * @return the tirthId
	 */
	public Long getTirthId() {
		return tirthId;
	}
	@OneToMany(mappedBy = "tirthId")
    private Collection<DsNearByCity> dsNearByCityCollection;
    @OneToMany(mappedBy = "tirthId")
    private Collection<DsMaster> DharamshalaCollection;

    public Tirth() {
    }

    public Tirth(Long tirthId) {
        this.tirthId = tirthId;
    }

    

    public void setTirthId(Long tirthId) {
        this.tirthId = tirthId;
    }

    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

 
    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Long getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(Long phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public Long getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(Long phoneNumber2) {
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

    @XmlTransient
    public Collection<DsNearByCity> getDsNearByCityCollection() {
        return dsNearByCityCollection;
    }

    public void setDsNearByCityCollection(Collection<DsNearByCity> dsNearByCityCollection) {
        this.dsNearByCityCollection = dsNearByCityCollection;
    }

    @XmlTransient
    public Collection<DsMaster> getDharamshalaCollection() {
        return DharamshalaCollection;
    }

    public void setDharamshalaCollection(Collection<DsMaster> DharamshalaCollection) {
        this.DharamshalaCollection = DharamshalaCollection;
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
        if (!(object instanceof Tirth)) {
            return false;
        }
        Tirth other = (Tirth) object;
        if ((this.tirthId == null && other.tirthId != null) || (this.tirthId != null && !this.tirthId.equals(other.tirthId))) {
            return false;
        }
        return true;
    }
	
	/**
	 * @return the tirthName
	 */
	public String getTirthName() {
		return tirthName;
	}
	/**
	 * @param tirthName the tirthName to set
	 */
	public void setTirthName(String tirthName) {
		this.tirthName = tirthName;
	}
	/**
	 * @return the kshetra
	 */
	public String getKshetra() {
		return kshetra;
	}
	/**
	 * @param kshetra the kshetra to set
	 */
	public void setKshetra(String kshetra) {
		this.kshetra = kshetra;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
}
