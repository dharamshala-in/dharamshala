package in.dharamshala.booking.dao;

import org.springframework.data.repository.CrudRepository;

import in.dharamshala.booking.model.DsRoomBookingDetails;

public interface DsRoomBookingDao extends CrudRepository<DsRoomBookingDetails, Long> {
	

}
