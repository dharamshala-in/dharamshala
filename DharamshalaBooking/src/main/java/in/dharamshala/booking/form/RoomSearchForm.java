package in.dharamshala.booking.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
*
* @author ShwetaJain
*/
public class RoomSearchForm {
	private long roomTypeId;
	private String roomType;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date checkIn;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date checkOut;
	private long dsId;
	private String [] roomNumbers;
	private String price;
	private Short noOfAdults;
	private Short noOfChilds;
	private long noOfRooms;
	private long convinenceFee;
	private long noOfDays;
	private long totalAmount;
	private String bookingForSelf;
	private String email;
	private String guestName;
	private String dob;
	private String idType;
	private long mobileNo;
	private String idCardNo;
	private String city;
	private String country;
	
	/**
	 * @return the roomTypeId
	 */
	public long getRoomTypeId() {
		return roomTypeId;
	}
	/**
	 * @param roomTypeId the roomTypeId to set
	 */
	public void setRoomTypeId(long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	/**
	 * @return the checkIn
	 */
	public Date getCheckIn() {
		return checkIn;
	}
	/**
	 * @param checkIn the checkIn to set
	 */
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	/**
	 * @return the checkOut
	 */
	public Date getCheckOut() {
		return checkOut;
	}
	/**
	 * @param checkOut the checkOut to set
	 */
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public long getDsId() {
		return dsId;
	}
	public void setDsId(long dsId) {
		this.dsId = dsId;
	}
	public String [] getRoomNumbers() {
		return roomNumbers;
	}
	public void setRoomNumbers(String [] roomNumbers) {
		this.roomNumbers = roomNumbers;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Short getNoOfChilds() {
		return noOfChilds;
	}
	public void setNoOfChilds(Short noOfChilds) {
		this.noOfChilds = noOfChilds;
	}
	public Short getNoOfAdults() {
		return noOfAdults;
	}
	public void setNoOfAdults(Short noOfAdults) {
		this.noOfAdults = noOfAdults;
	}
	/**
	 * @return the noOfRooms
	 */
	public long getNoOfRooms() {
		return noOfRooms;
	}
	/**
	 * @param noOfRooms the noOfRooms to set
	 */
	public void setNoOfRooms(long noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	/**
	 * @return the convinenceFee
	 */
	public long getConvinenceFee() {
		return convinenceFee;
	}
	/**
	 * @param convinenceFee the convinenceFee to set
	 */
	public void setConvinenceFee(long convinenceFee) {
		this.convinenceFee = convinenceFee;
	}
	/**
	 * @return the noOfDays
	 */
	public long getNoOfDays() {
		return noOfDays;
	}
	/**
	 * @param noOfDays the noOfDays to set
	 */
	public void setNoOfDays(long noOfDays) {
		this.noOfDays = noOfDays;
	}
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * @return the bookingForSelf
	 */
	public String getBookingForSelf() {
		return bookingForSelf;
	}
	/**
	 * @param bookingForSelf the bookingForSelf to set
	 */
	public void setBookingForSelf(String bookingForSelf) {
		this.bookingForSelf = bookingForSelf;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the guestName
	 */
	public String getGuestName() {
		return guestName;
	}
	/**
	 * @param guestName the guestName to set
	 */
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the idType
	 */
	public String getIdType() {
		return idType;
	}
	/**
	 * @param idType the idType to set
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}
	/**
	 * @return the mobileNo
	 */
	public long getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	/**
	 * @return the idCardNo
	 */
	public String getIdCardNo() {
		return idCardNo;
	}
	/**
	 * @param idCardNo the idCardNo to set
	 */
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
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
	

}
