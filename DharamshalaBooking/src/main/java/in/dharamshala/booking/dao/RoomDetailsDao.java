package in.dharamshala.booking.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import in.dharamshala.booking.model.DsCustomerDetails;
import in.dharamshala.booking.model.DsGuestDetails;
import in.dharamshala.booking.model.DsIdMaster;
import in.dharamshala.booking.model.DsMaster;
import in.dharamshala.booking.model.DsRoomBookingDetails;
import in.dharamshala.booking.model.DsRoomMapping;
import in.dharamshala.booking.model.DsRoomType;
/**
*
* @author ShwetaJain
*/
public interface RoomDetailsDao {
	public List<DsRoomType> getRoomDetails(long dharamshalaId);

	public List<Object[]> getRoomTypeMhtd(long dharamshalaId);

	public List<DsRoomMapping> getRoomReservationStatusMthd(long dharamshalaId, long roomType, Date checkInDate,
			Date checkOutDate);

	public List<DsRoomType> getRoomTypePriceMhtd(long dharamshalaId, long roomTypeId);

	public List<DsIdMaster> getAllIdTypeMhtd();

	public List<DsCustomerDetails> getUserDetailsMhtd(String userName);

	public List<DsMaster> getDharamshalaDetailsMhtd(long dharamshalaId);

//	public DsGuestDetails addGuestDetailsMhtd(DsGuestDetails dsGuestDetails);

	public DsRoomBookingDetails addBookRoomMhtd(DsRoomBookingDetails dsRoomBookingDetails);

	
}
