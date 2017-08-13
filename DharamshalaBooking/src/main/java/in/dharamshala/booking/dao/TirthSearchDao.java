package in.dharamshala.booking.dao;

import java.util.List;

import in.dharamshala.booking.model.Tirth;
/**
*
* @author ShwetaJain
*/
public interface TirthSearchDao {
	List searchByKshetra(String name,String kshetra, String city);

	List<Tirth> getKshetraMhtd();

}
