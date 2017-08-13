package in.dharamshala.booking.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import in.dharamshala.booking.model.DsCustomerDetails;
import in.dharamshala.booking.model.DsMaster;
import in.dharamshala.booking.model.DsRoomBookingDetails;
import in.dharamshala.booking.model.DsRoomMapping;
import in.dharamshala.booking.model.DsRoomType;
/**
*
* @author ShwetaJain
*/
public interface RoomDetailsService {

	List<DsRoomType> getRoomDetails(long dharamshalaId);

	Map<String, String> getUniqueRoomTypes(long dharamshalaId);

	List<DsRoomMapping> getRoomReservationStatus(long dharamshalaId, long roomTypeId,Date checkIn,Date checkOut);

	List<DsRoomType> getRoomTypePrice(long dharamshalaId,long roomTypeId);

	Map<String, String> getAllIdTypes();

	List<DsCustomerDetails> getUserDetails(String userName);

	List<DsMaster> getDharamshalaDetails(long dharamshalaId);

//	DsGuestDetails addGuestDetails(String guestName, String dob, String idType, long idCardNo, long mobileNo,
//			String email, String city, String country,long bookingId);

	List<DsRoomBookingDetails> addBookRoom(String[] roomNumbers, long dsId, long roomTypeId, Date checkIn,
			Date checkOut, String price, String bookingForSelf, Short noOfAdults, Short noOfChilds, String username,String guestName, String dob, String idType, String idCardNo, long mobileNo,
			String email, String city, String country);

}
