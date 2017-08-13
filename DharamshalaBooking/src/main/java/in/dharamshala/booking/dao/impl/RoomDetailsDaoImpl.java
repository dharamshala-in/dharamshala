package in.dharamshala.booking.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import in.dharamshala.booking.dao.RoomDetailsDao;
import in.dharamshala.booking.generic.BaseAbstractDao;
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
@Repository
public class RoomDetailsDaoImpl extends BaseAbstractDao<Integer,DsRoomBookingDetails> implements RoomDetailsDao {
	private static final Logger logger=LoggerFactory.getLogger(RoomDetailsDaoImpl.class);

	EntityManager entityManager;
	 
	 @PersistenceContext
	 public void setEntityManager(EntityManager entityManager) {
	      this.entityManager = entityManager;
	      System.out.println("This entity manager is **"+entityManager);
	 }
	public List<DsRoomType> getRoomDetails(long dharamshalaId) {

			StringBuilder strb= new StringBuilder("select obj from DsRoomType obj left join fetch obj.dsRoomPriceCollection");
			strb.append(" where obj.dsId.dsId=:dharamShalaId");
		
		Query qry=entityManager.createQuery(strb.toString());
		qry.setParameter("dharamShalaId", dharamshalaId);
		List<DsRoomType> lRoomdtls = qry.getResultList();
		
		return lRoomdtls;
	}
	@Override
	public List<Object[]> getRoomTypeMhtd(long dharamshalaId) {
		StringBuilder strb= new StringBuilder("select distinct obj.roomTypeId,obj.roomCategory from DsRoomType obj ");
		strb.append(" where obj.dsId.dsId=:dharamShalaId");
	
		Query qry=entityManager.createQuery(strb.toString());
		qry.setParameter("dharamShalaId", dharamshalaId);
		
		return qry.getResultList();
	}
	@Override
	public List<DsRoomMapping> getRoomReservationStatusMthd(long dharamshalaId, long roomType,Date checkInDate,Date checkOutDate) {
		logger.info("parameters are dharamshalaId+"+dharamshalaId+"roomType>>"+roomType+"checkIn>>"+checkInDate+"checkOutDate"+checkOutDate);
		
//		StringBuilder strb1= new StringBuilder("select * from DS_ROOM_MAPPING obj WHERE ")
//		.append(" DS_ID=:dharamShalaId AND ROOM_TYPE_ID=:roomTypeId")
//		.append(" and ROOM_NUMBER NOT IN(select ROOM_NUMBER from DS_ROOM_BOOKING_DETAILS ")
//		.append(" WHERE  DS_ID=:dharamShalaId and not (:qryCheckOutDate < CHECK_IN or")
//		.append(" :qryCheckInDate > check_out ))");
//		Query qry=entityManager.createNativeQuery(strb.toString());
		
		StringBuilder strb= new StringBuilder("select obj from DsRoomMapping obj WHERE ")
				.append(" obj.dsId.dsId=:dharamShalaId AND obj.roomTypeId.roomTypeId=:roomTypeId")
				.append(" and obj.roomNumber NOT IN(select objDetail.roomNumber from DsRoomBookingDetails objDetail")
				.append(" WHERE  objDetail.dsId.dsId=:dharamShalaId and not (:qryCheckOutDate < objDetail.checkIn or")
				.append(" :qryCheckInDate > objDetail.checkOut ))");
		
		Query qry=entityManager.createQuery(strb.toString());
		qry.setParameter("dharamShalaId", dharamshalaId);
		qry.setParameter("roomTypeId", roomType);
		qry.setParameter("dharamShalaId", dharamshalaId);
		qry.setParameter("qryCheckOutDate", checkOutDate);
		qry.setParameter("qryCheckInDate", checkInDate);
		List<DsRoomMapping> lst = qry.getResultList();
		
		logger.info("*********list size******************"+ lst.size());
		return lst;
	}
	
	@Override
	public List<DsRoomType> getRoomTypePriceMhtd(long dharamshalaId, long roomTypeId) {
		StringBuilder strb= new StringBuilder("select obj from DsRoomType obj left join fetch obj.dsRoomPriceCollection");
		strb.append(" where obj.dsId.dsId=:dharamShalaId and obj.roomTypeId=:roomtypeId");
	
		Query qry=entityManager.createQuery(strb.toString());
		qry.setParameter("dharamShalaId", dharamshalaId);
		qry.setParameter("roomtypeId", roomTypeId);
		return qry.getResultList();
	}
	
	@Override
	public List<DsIdMaster> getAllIdTypeMhtd() {
		
		StringBuilder strb= new StringBuilder(" select distinct obj from DsIdMaster obj");
		Query qry=entityManager.createQuery(strb.toString());
		List<DsIdMaster> Idlst = qry.getResultList();
		
		return Idlst;
	}
	@Override
	public List<DsCustomerDetails> getUserDetailsMhtd(String userName) {
		StringBuilder strb= new StringBuilder(" select distinct obj from DsCustomerDetails obj where obj.userName=:username");
		Query qry=entityManager.createQuery(strb.toString());
		qry.setParameter("username", userName);
		List<DsCustomerDetails> usrdtls = qry.getResultList();
		
		return usrdtls;
	}
	@Override
	public List<DsMaster> getDharamshalaDetailsMhtd(long dharamshalaId) {
		StringBuilder strb= new StringBuilder(" select distinct obj from DsMaster obj where obj.dsId=:dharamShalaId");
		Query qry=entityManager.createQuery(strb.toString());
		qry.setParameter("dharamShalaId", dharamshalaId);
		List<DsMaster> dsDtls = qry.getResultList();
		
		return dsDtls;
	}

	@Override
	public DsRoomBookingDetails addBookRoomMhtd(DsRoomBookingDetails dsRoomBookingDetails) {
		return super.persist(dsRoomBookingDetails);
	}

}
