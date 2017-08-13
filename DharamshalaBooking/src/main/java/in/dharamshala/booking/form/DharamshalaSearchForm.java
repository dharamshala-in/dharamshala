package in.dharamshala.booking.form;

import java.util.HashMap;
import java.util.Map;
/**
*
* @author ShwetaJain
*/
public class DharamshalaSearchForm {
		private long dsId;
		private String dsName;
	    
	    private String dsAddress;
	   
	    private String dsCity;
	   
	    private String pincode;
	   
	    private Long phoneNo;
	    
	    private String state;
	   
	    private String country;
	    
	    private String district;
	    
	    private String hasBhojanShala;
	    private String roomTypeId;
	    private String roomType;
	    private Map<Long,String> roomTypes=new HashMap<>();
		/**
		 * @return the dsId
		 */
		public long getDsId() {
			return dsId;
		}
		/**
		 * @param dsId the dsId to set
		 */
		public void setDsId(long dsId) {
			this.dsId = dsId;
		}
		/**
		 * @return the dsName
		 */
		public String getDsName() {
			return dsName;
		}
		/**
		 * @param dsName the dsName to set
		 */
		public void setDsName(String dsName) {
			this.dsName = dsName;
		}
		/**
		 * @return the dsAddress
		 */
		public String getDsAddress() {
			return dsAddress;
		}
		/**
		 * @param dsAddress the dsAddress to set
		 */
		public void setDsAddress(String dsAddress) {
			this.dsAddress = dsAddress;
		}
		/**
		 * @return the dsCity
		 */
		public String getDsCity() {
			return dsCity;
		}
		/**
		 * @param dsCity the dsCity to set
		 */
		public void setDsCity(String dsCity) {
			this.dsCity = dsCity;
		}
		/**
		 * @return the pincode
		 */
		public String getPincode() {
			return pincode;
		}
		/**
		 * @param pincode the pincode to set
		 */
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		/**
		 * @return the phoneNo
		 */
		public Long getPhoneNo() {
			return phoneNo;
		}
		/**
		 * @param phoneNo the phoneNo to set
		 */
		public void setPhoneNo(Long phoneNo) {
			this.phoneNo = phoneNo;
		}
		/**
		 * @return the state
		 */
		public String getState() {
			return state;
		}
		/**
		 * @param state the state to set
		 */
		public void setState(String state) {
			this.state = state;
		}
		/**
		 * @return the country
		 */
		public String getCountry() {
			return country;
		}
		/**
		 * @param country the country to set
		 */
		public void setCountry(String country) {
			this.country = country;
		}
		/**
		 * @return the district
		 */
		public String getDistrict() {
			return district;
		}
		/**
		 * @param district the district to set
		 */
		public void setDistrict(String district) {
			this.district = district;
		}
		/**
		 * @return the hasBhojanShala
		 */
		public String getHasBhojanShala() {
			return hasBhojanShala;
		}
		/**
		 * @param hasBhojanShala the hasBhojanShala to set
		 */
		public void setHasBhojanShala(String hasBhojanShala) {
			this.hasBhojanShala = hasBhojanShala;
		}
		/**
		 * @return the roomTypeId
		 */
		public String getRoomTypeId() {
			return roomTypeId;
		}
		/**
		 * @param roomTypeId the roomTypeId to set
		 */
		public void setRoomTypeId(String roomTypeId) {
			this.roomTypeId = roomTypeId;
		}
		/**
		 * @return the roomType
		 */
		public String getRoomType() {
			return roomType;
		}
		/**
		 * @param roomType the roomType to set
		 */
		public void setRoomType(String roomType) {
			this.roomType = roomType;
		}
		public Map<Long,String> getRoomTypes() {
			return roomTypes;
		}
		public void setRoomTypes(Map<Long,String> roomTypes) {
			this.roomTypes = roomTypes;
		}
	    
}
