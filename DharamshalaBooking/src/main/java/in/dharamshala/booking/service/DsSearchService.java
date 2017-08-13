package in.dharamshala.booking.service;

import java.util.List;

import in.dharamshala.booking.model.DsMaster;
import in.dharamshala.booking.model.Tirth;
/**
*
* @author ShwetaJain
*/
public interface DsSearchService {
	public List<DsMaster> searchDharamShala(long tirthId);

	public List<Tirth> getTirthDeatils(long tirthId);

	public List getNearByCityDetails(long tirthId);

	public List searchDharamShala(String dharamshala);

}
