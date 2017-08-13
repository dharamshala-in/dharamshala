package in.dharamshala.booking.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import in.dharamshala.booking.dao.TirthSearchDao;
import in.dharamshala.booking.generic.BaseAbstractDao;
import in.dharamshala.booking.model.Tirth;
/**
*
* @author ShwetaJain
*/
@Repository("tirthSearch")
public class TirthSerachDaoImpl extends BaseAbstractDao<Integer, Tirth> implements TirthSearchDao {

	EntityManager entityManager;
	 
	 @PersistenceContext
	 public void setEntityManager(EntityManager entityManager) {
	      this.entityManager = entityManager;
	      System.out.println("This entity manager is **"+entityManager);
	 }
	 
	@Override
	public List<Object[]> searchByKshetra(String tirthName,String kshetra,String city) {
		StringBuilder strb= new StringBuilder("select obj.tirthId,obj.tirthName,obj.kshetra,obj.city from Tirth obj where upper(obj.tirthName) like upper(:tirthName)");
		if(!kshetra.equals("BOTH")){
			strb.append(" and upper(obj.kshetra)=upper(:kshetra)");
		}
		if((city!=null)&&(!city.equals("")) ){
			strb.append(" and upper(obj.city)=upper(:city)");
			
		}
		strb.append(" order by obj.tirthName");
		Query qry=entityManager.createQuery(strb.toString());
		qry.setParameter("tirthName", "%"+ tirthName + "%");
		if(!kshetra.equals("BOTH")){
			qry.setParameter("kshetra", kshetra);
		}
		if((city!=null)&&(!city.equals("")) ){
			qry.setParameter("city", city);			
		}
		return qry.getResultList();
	}

	@Override
	public List<Tirth> getKshetraMhtd() {
		StringBuilder strb= new StringBuilder("select distinct upper(obj.kshetra) from Tirth obj ");
		
	
		Query qry=entityManager.createQuery(strb.toString());
				
		return qry.getResultList();
	}

}
