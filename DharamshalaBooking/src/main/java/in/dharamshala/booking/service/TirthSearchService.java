package in.dharamshala.booking.service;

import java.util.List;
import java.util.Map;

import in.dharamshala.booking.model.Tirth;
/**
*
* @author ShwetaJain
*/
public interface TirthSearchService {
	public List<Tirth> searchTirth(String tirthName,String kshetra, String lcity);

	public Map<String, String> getKshetraList();
	
}
