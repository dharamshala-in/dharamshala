package in.dharamshala.booking.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dharamshala.booking.dao.DsSearchDao;
import in.dharamshala.booking.model.DsMaster;
import in.dharamshala.booking.model.DsNearByCity;
import in.dharamshala.booking.model.Tirth;
import in.dharamshala.booking.service.DsSearchService;
/**
*
* @author ShwetaJain
*/
@Service
public class DsSearchServiceImpl implements DsSearchService {
	
	private static final Logger logger=LoggerFactory.getLogger(TirthSearchServiceImpl.class);
	
	@Autowired(required=true)
	protected DsSearchDao dsSearchDao;
	
	@Override
	public List<DsMaster> searchDharamShala(long tirthId) {
		List<DsMaster>listOfDs= dsSearchDao.searchByTirthId(tirthId);
		return listOfDs;
	}

	@Override
	public List<Tirth> getTirthDeatils(long tirthId) {
		List<Tirth> tirthDetailsList=dsSearchDao.getTirthDetailsById(tirthId);
		
		return tirthDetailsList;
	}

	@Override
	public List<DsNearByCity> getNearByCityDetails(long tirthId) {
		List<DsNearByCity> nearByCityList=dsSearchDao.getNearByCityByTirthId(tirthId);
		
		return nearByCityList;
	}

	@Override
	public List<DsMaster> searchDharamShala(String dharamshala) {
		List<DsMaster>listOfDs= dsSearchDao.getDharamshalaMthd(dharamshala);
		return listOfDs;
	}

	

}
