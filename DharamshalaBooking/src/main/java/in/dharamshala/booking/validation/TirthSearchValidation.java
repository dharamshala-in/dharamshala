package in.dharamshala.booking.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import in.dharamshala.booking.generic.GenericValidator;
import in.dharamshala.booking.model.Tirth;
/**
*
* @author ShwetaJain
*/
@Component
public class TirthSearchValidation extends GenericValidator  implements Validator  {
	protected final Logger log = LoggerFactory.getLogger(TirthSearchValidation.class);
	@Override
	public boolean supports(Class<?> classType) {
		
		return Tirth.class.isAssignableFrom(classType);
		
	}

	@Override
	public void validate(Object target, Errors bindingError) {
		Tirth tirth=(Tirth)target;
		GenericValidator genericValidator =new GenericValidator();
		log.debug("Tirth::"+tirth.getTirthName()+"City::"+tirth.getCity());
		if((tirth.getCity()==null && tirth.getTirthName()==null)||(tirth.getCity().equals("") && tirth.getTirthName().equals(""))) {
			
			bindingError.reject("namecity");
		}
		
		if(!genericValidator.checkPattern(tirth.getCity(), ALPHA_WITH_SPACE)){
			bindingError.reject("city");
		}
		if(!genericValidator.checkPattern(tirth.getTirthName(), ALPHA_WITH_SPACE)){
			bindingError.reject("tirthName");
		}
	}
	

}
