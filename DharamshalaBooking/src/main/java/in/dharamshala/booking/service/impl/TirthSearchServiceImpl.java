package in.dharamshala.booking.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dharamshala.booking.dao.TirthSearchDao;
import in.dharamshala.booking.model.Tirth;
import in.dharamshala.booking.service.TirthSearchService;
/**
*
* @author ShwetaJain
*/
@Service
public class TirthSearchServiceImpl implements TirthSearchService{

	private static final Logger logger=LoggerFactory.getLogger(TirthSearchServiceImpl.class);
	
	@Autowired(required=true)
	protected TirthSearchDao tirthSearch;
	
	@Override
	public List<Tirth> searchTirth(String tirthName, String kshetra,String city) {
		
		List returnList=new ArrayList<Tirth>();
		List<Object[]> list=tirthSearch.searchByKshetra(tirthName, kshetra,city);
		
		if(list!=null && list.size()>0){
			for (Object[] tirthData : list) {
				Tirth tirth = new Tirth();
				tirth.setTirthId(Long.parseLong(tirthData[0].toString()));
				tirth.setTirthName((String)tirthData[1]);
				tirth.setKshetra((String)tirthData[2]);
				tirth.setCity((String)tirthData[3]);
				returnList.add(tirth);
			}			
		}
		logger.info(" tirth list after search is ::"+returnList.size());
		
		 return returnList;
	}

	@Override
	public Map<String, String> getKshetraList() {
		List<Tirth> kshetraTypeList=tirthSearch.getKshetraMhtd();
		Map<String, String> kshetraTypeMp=new HashMap<String, String>();
		for (Object obj : kshetraTypeList) {
			kshetraTypeMp.put(obj.toString(),obj.toString());

		}
		return kshetraTypeMp;
	}
	
}
