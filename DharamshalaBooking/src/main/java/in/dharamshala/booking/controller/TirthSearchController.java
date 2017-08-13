package in.dharamshala.booking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.dharamshala.booking.model.Tirth;
import in.dharamshala.booking.service.TirthSearchService;
import in.dharamshala.booking.validation.TirthSearchValidation;
/**
*
* @author ShwetaJain
*/
@Controller
public class TirthSearchController {
	private static final Logger logger=LoggerFactory.getLogger(TirthSearchController.class);

	@Autowired(required = true)
	protected TirthSearchService TirthSearchService;
	@Autowired(required = true)
	protected TirthSearchValidation tirthSearchValidation;

	@GetMapping(value = {"/","/tirthSearch"})
	public ModelAndView tirthHomePage() {
		logger.info("inside tirth search get===================");
		ModelAndView modelAndView = new ModelAndView("TirthSearchPage", "tirth", new Tirth());
		return modelAndView;
	}

	@PostMapping(value ="/tirthSearch")
	public ModelAndView tirthSearch( @ModelAttribute("tirth") Tirth tirth,BindingResult result) {
		logger.info("inside tirth search post===================");
	
		tirthSearchValidation.validate(tirth, result);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("TirthSearchPage");
		if (result.hasErrors()) {
			return mv;
		}
		String ltirthName=tirth.getTirthName();
		String lKshetraName=tirth.getKshetra();
		String lcity=tirth.getCity();
		logger.info("inside tirth search post===================ltirthName"+ltirthName+"lKshetraName"+lKshetraName+"city"+lcity);
		
		mv.addObject("tirth", tirth);
		
		
		//if((ltirthName!=null && lKshetraName!=null)&&(!ltirthName.equals("") && !lKshetraName.equals(""))&&(ltirthName.length()>0 || lcity.length()>0)){
			List<Tirth> returnLst=TirthSearchService.searchTirth(ltirthName, lKshetraName,lcity);
			
			mv.addObject("kshetraList",returnLst);
		//}
		return mv;
	}

	@ModelAttribute("kshetraTypeList")
	public Map<String, String> configureKshetraTypeList() {
		Map<String, String> kshetraTypeList = new HashMap<String, String>();
		kshetraTypeList=TirthSearchService.getKshetraList();
//		kshetraTypeList.put("Siddha", "Siddha Kshetra");
//		kshetraTypeList.put("Atishay", "Atishay Kshetra");
		return kshetraTypeList;
	}

}
