package in.dharamshala.booking.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import in.dharamshala.booking.dao.DsSearchDao;
import in.dharamshala.booking.generic.BaseAbstractDao;
import in.dharamshala.booking.model.DsMaster;
import in.dharamshala.booking.model.DsNearByCity;
import in.dharamshala.booking.model.Tirth;
/**
*
* @author ShwetaJain
*/
@Repository
public class DsSearchDaoImpl extends BaseAbstractDao<Integer, DsMaster> implements DsSearchDao {
	private static final Logger logger=LoggerFactory.getLogger(DsSearchDaoImpl.class);
	
	EntityManager entityManager;
	 
	 @PersistenceContext
	 public void setEntityManager(EntityManager entityManager) {
	      this.entityManager = entityManager;
	      System.out.println("This entity manager is **"+entityManager);
	 }
	 
	@Override
	public List<DsMaster> searchByTirthId(long TirthId) {
//		StringBuilder strb= new StringBuilder("select obj.DS_ID,obj.DS_NAME,obj.DS_ADDRESS,obj.DS_CITY,obj.PINCODE,obj.PHONE_NO,obj.STATE,obj.COUNTRY,obj.DISTRICT from ds_master obj where obj.tirth_id=:tirthId");
		
		StringBuilder strb= new StringBuilder("select obj from DsMaster obj where obj.tirthId.tirthId=:tirthId");
		
		Query qry=entityManager.createQuery(strb.toString());
		qry.setParameter("tirthId", TirthId);
		return qry.getResultList();
	}

	@Override
	public List<Tirth> getTirthDetailsById(long tirthId) {
		
		StringBuilder strb= new StringBuilder("select obj from Tirth obj where obj.tirthId=:tirthId");
		
		Query qry=entityManager.createQuery(strb.toString());
		qry.setParameter("tirthId", tirthId);
		return qry.getResultList();
		
	}

	@Override
	public List<DsNearByCity> getNearByCityByTirthId(long tirthId) {
		
		StringBuilder strb= new StringBuilder("select obj from DsNearByCity obj where obj.tirthId.tirthId=:tirthId");
		
		Query qry=entityManager.createQuery(strb.toString());
		qry.setParameter("tirthId", tirthId);
		return qry.getResultList();
		
	}

	@Override
	public List<DsMaster> getDharamshalaMthd(String dharamshala) {
		
		StringBuilder strb= new StringBuilder("select obj from DsMaster obj where upper(obj.dsName) like upper(:dharamshala) or upper(obj.dsCity) like upper(:city)");
		
		Query qry=entityManager.createQuery(strb.toString());
		qry.setParameter("dharamshala", dharamshala+ "%" );
		qry.setParameter("city", dharamshala+ "%");
		return qry.getResultList();
	}

}
