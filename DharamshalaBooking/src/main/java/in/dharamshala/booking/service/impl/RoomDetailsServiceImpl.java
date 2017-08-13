package in.dharamshala.booking.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.dharamshala.booking.dao.DsRoomBookingDao;
import in.dharamshala.booking.dao.RoomDetailsDao;
import in.dharamshala.booking.model.DsCustomerDetails;
import in.dharamshala.booking.model.DsGuestDetails;
import in.dharamshala.booking.model.DsIdMaster;
import in.dharamshala.booking.model.DsMaster;
import in.dharamshala.booking.model.DsRoomBookingDetails;
import in.dharamshala.booking.model.DsRoomMapping;
import in.dharamshala.booking.model.DsRoomType;
import in.dharamshala.booking.service.RoomDetailsService;

/**
*
* @author ShwetaJain
*/
@Service
public class RoomDetailsServiceImpl implements RoomDetailsService {

private static final Logger logger=LoggerFactory.getLogger(RoomDetailsServiceImpl.class);
	
	@Autowired(required=true)
	protected RoomDetailsDao roomDetailsDao;
	
	@Autowired(required=true)
	protected DsRoomBookingDao roomBookingDao;
	
	@Override
	public List<DsRoomType> getRoomDetails(long dharamshalaId) {
		List<DsRoomType> roomDeatilsList=roomDetailsDao.getRoomDetails(dharamshalaId);
		return roomDeatilsList;
	}

	@Override
	public Map<String, String> getUniqueRoomTypes(long dharamshalaId) {
		
		List<Object[]> roomTypeList=roomDetailsDao.getRoomTypeMhtd(dharamshalaId);
		Map<String, String> roomTypeMp=new HashMap<String, String>();
		for (Object[] objects : roomTypeList) {
			roomTypeMp.put(objects[0].toString(),objects[1].toString());

		}
		return roomTypeMp;
	}

	@Override
	public List<DsRoomMapping> getRoomReservationStatus(long dharamshalaId,long roomType,Date checkInDate,Date checkOutDate) {
		List<DsRoomMapping> roomBookingStatusList=roomDetailsDao.getRoomReservationStatusMthd(dharamshalaId,roomType, checkInDate, checkOutDate);
		return roomBookingStatusList;
	}

	@Override
	public List<DsRoomType> getRoomTypePrice(long dharamshalaId, long roomTypeId) {
		
		List<DsRoomType> roomTypePricelst=roomDetailsDao.getRoomTypePriceMhtd(dharamshalaId,roomTypeId);
		
		return roomTypePricelst;
	}

	@Override
	public Map<String, String> getAllIdTypes() {
		
		List<DsIdMaster> idtypeLst=roomDetailsDao.getAllIdTypeMhtd();
		Map<String, String> idTypeMp=new HashMap<String, String>();
		for (DsIdMaster dsIdMaster : idtypeLst) {
			idTypeMp.put(dsIdMaster.getIdType().toString(),dsIdMaster.getIdName());
		}
		return idTypeMp;
	}

	@Override
	public List<DsCustomerDetails> getUserDetails(String userName) {
		
		List<DsCustomerDetails> userDetailsLst=roomDetailsDao.getUserDetailsMhtd(userName);
		
		return userDetailsLst;
	}

	@Override
	public List<DsMaster> getDharamshalaDetails(long dharamshalaId) {
		List<DsMaster> dsDetailsLst=roomDetailsDao.getDharamshalaDetailsMhtd(dharamshalaId);
		
		return dsDetailsLst;
	}

//	@Override
//	public DsGuestDetails addGuestDetails(String guestName, String dob, String idType, long idCardNo,
//			long mobileNo, String email, String city, String country,long bookingId) {
//		DsGuestDetails dsGuestDetails =new DsGuestDetails();
//		dsGuestDetails.setGuestName(guestName);
//		dsGuestDetails.setDob(dob);
//		dsGuestDetails.setIdType(idType);
//		dsGuestDetails.setIdNumber(idCardNo);
//		dsGuestDetails.setMobileNo(mobileNo);
//		dsGuestDetails.setEmailId(email);
//		dsGuestDetails.setCity(city);
//		dsGuestDetails.setCountry(country);
////		dsGuestDetails.getDsRoomBookingDetails().setBookingId(bookingId);
//		
//		dsGuestDetails = roomDetailsDao.addGuestDetailsMhtd(dsGuestDetails);
//		
//		return dsGuestDetails;
//	}

	@Override
	@Transactional
	public List<DsRoomBookingDetails> addBookRoom(String[] roomNumbers, long dsId, long roomTypeId, Date checkIn,
			Date checkOut, String price, String bookingForSelf, Short noOfAdults, Short noOfChilds,String userName,
			String guestName, String dob, String idType, String idCardNo, long mobileNo,
			String email, String city, String country) {
		
		List<DsRoomBookingDetails> lstDsRoomBookingDetails = new ArrayList<DsRoomBookingDetails>();
		List<DsGuestDetails> lstGuestDetails = new ArrayList<DsGuestDetails>();
		DsRoomBookingDetails dsRoomBookingDetailsDTO = new DsRoomBookingDetails();
		try{
				for (String roomNumber : roomNumbers) {
					
					DsRoomBookingDetails dsRoomBookingDetails = new DsRoomBookingDetails();
					dsRoomBookingDetails.setBookingDate(new Date());
					dsRoomBookingDetails.setBookingForSelf("self".equalsIgnoreCase(bookingForSelf)?"Y":"N");
					dsRoomBookingDetails.setCheckIn(checkIn);
					dsRoomBookingDetails.setCheckOut(checkOut);
					dsRoomBookingDetails.setDsId(dsId);
					dsRoomBookingDetails.setNoOfAdults(noOfAdults);
					dsRoomBookingDetails.setNoOfChilds(noOfChilds);
					dsRoomBookingDetails.setPrice(new Long(price));
					dsRoomBookingDetails.setRoomTypeId(roomTypeId);
					dsRoomBookingDetails.setStatus("P");// P-pending for approval, B- booked,C-cancelled
					dsRoomBookingDetails.setSsoId(userName);
					dsRoomBookingDetails.setRoomNumber(roomNumber);
					
		
					if(!"self".equalsIgnoreCase(bookingForSelf)){
						//for(DsGuestDetails dsGuestDetails:dsRoomBookingDetails.getDsGuestDetailsCollection()){
							DsGuestDetails dsGuestDetails =new DsGuestDetails();
							dsGuestDetails.setDsRoomBookingDetails(dsRoomBookingDetails);
							dsGuestDetails.setGuestName(guestName);
							dsGuestDetails.setDob(dob);
							dsGuestDetails.setIdType(idType);
							dsGuestDetails.setIdNumber(idCardNo);
							dsGuestDetails.setMobileNo(mobileNo);
							dsGuestDetails.setEmailId(email);
							dsGuestDetails.setCity(city);
							dsGuestDetails.setCountry(country);
							dsGuestDetails.setCreatedDate(new Date());
							lstGuestDetails.add(dsGuestDetails);
						//}
						dsRoomBookingDetails.setDsGuestDetailsCollection(lstGuestDetails);
					
					}
					
					//dsRoomBookingDetailsDTO = roomDetailsDao.addBookRoomMhtd(dsRoomBookingDetails);
					dsRoomBookingDetailsDTO=roomBookingDao.save(dsRoomBookingDetails);
					
					lstDsRoomBookingDetails.add(dsRoomBookingDetailsDTO);
					logger.error("dsRoomBookingDetails:::::: " + dsRoomBookingDetails.getBookingId());
				}		
		
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return lstDsRoomBookingDetails;
	}
	
/*	@Transactional
	public DsRoomBookingDetails doBookRoom(DsRoomBookingDetails roomBookingDetails){
		
		return roomDetailsDao.addBookRoomMhtd(roomBookingDetails);
		
	}
	@PersistenceContext
	EntityManager entityManager;
	
	public DsRoomBookingDetails doBookRoom(DsRoomBookingDetails roomBookingDetails){
		DsRoomBookingDetails dsRoomBookingDetailsDto = entityManager.merge(roomBookingDetails);
		
		return dsRoomBookingDetailsDto;
		
	}*/
}
