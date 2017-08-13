package in.dharamshala.booking.dao;

import java.util.List;

import in.dharamshala.booking.model.DsMaster;
import in.dharamshala.booking.model.DsNearByCity;
import in.dharamshala.booking.model.Tirth;
/**
*
* @author ShwetaJain
*/
public interface DsSearchDao {
	public List<DsMaster> searchByTirthId(long TirthId );

	public List<Tirth> getTirthDetailsById(long tirthId);

	public List<DsNearByCity> getNearByCityByTirthId(long tirthId);

	public List<DsMaster> getDharamshalaMthd(String dharamshala);
	
}
