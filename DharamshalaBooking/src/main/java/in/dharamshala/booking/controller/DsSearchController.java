package in.dharamshala.booking.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.dharamshala.booking.form.DharamshalaSearchForm;
import in.dharamshala.booking.form.RoomSearchForm;
import in.dharamshala.booking.model.DsMaster;
import in.dharamshala.booking.model.DsNearByCity;
import in.dharamshala.booking.model.Tirth;
import in.dharamshala.booking.service.DsSearchService;
import in.dharamshala.booking.service.RoomDetailsService;
/**
*
* @author ShwetaJain
*/
@Controller
public class DsSearchController {
	private static final Logger logger=LoggerFactory.getLogger(DsSearchController.class);

	@Autowired(required = true)
	protected DsSearchService dsSearchService;
	@Autowired(required = true)
	protected RoomDetailsService roomDetailsService;
	
	@GetMapping(value = "/dsSearch")
	public ModelAndView dsSearchHomePage(@ModelAttribute("dharamshala") DsMaster dharamshala) {
		
		logger.info("inside ds search get tirthId===================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("dharamshalaSearchScreen");
		return modelAndView;
	}

	@PostMapping(value = "/dsSearch")
	public ModelAndView dsSearchPage(@ModelAttribute("dharamshala") DharamshalaSearchForm dharamshala,BindingResult result) {
		
		String dharamshalaName=dharamshala.getDsName();
		Map<String, String> roomTypeMap = new HashMap<String, String>();
		List roomTypeList=new ArrayList<>();
		logger.info("inside ds search post tirthId===================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("dharamshalaSearchScreen");
		if (result.hasErrors()) {
			return modelAndView;
		}
		//To list dharamshalas
		List<DsMaster> dsList= dsSearchService.searchDharamShala(dharamshalaName);
		
		
		for (DsMaster dharamshalaObj : dsList) {			
			roomTypeMap = roomDetailsService.getUniqueRoomTypes(dharamshalaObj.getDsId());
			DharamshalaSearchForm dharamshalaForm=new DharamshalaSearchForm();
			dharamshalaForm.setDsId(dharamshalaObj.getDsId());
			dharamshalaForm.setDsName(dharamshalaObj.getDsName());
			dharamshalaForm.setDsAddress(dharamshalaObj.getDsAddress());
			dharamshalaForm.setDsCity(dharamshalaObj.getDsCity());
			dharamshalaForm.setPhoneNo(dharamshalaObj.getPhoneNo());
			dharamshalaForm.setHasBhojanShala(dharamshalaObj.getHasBhojanShala());
			roomTypeMap.forEach((k,v)->{
				dharamshalaForm.getRoomTypes().put(new Long(k),v);
				
				});
			roomTypeList.add(dharamshalaForm);
			
		}
		modelAndView.addObject("dharamshalaList", roomTypeList);
				
		modelAndView.addObject("roomSearchForm",new RoomSearchForm());
		return modelAndView;
	}

	@PostMapping(value = "/dstirthDetails")
	public ModelAndView tirthDetailsPage(@ModelAttribute("tirth") Tirth teerth,BindingResult result) {
		long tirthId=teerth.getTirthId();
		logger.info("inside ds search post tirthId==================="+tirthId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("TirthDetailsScreen");
		if (result.hasErrors()) {
			return modelAndView;
		}
		
		//To list DsMaster details
		List dsList= dsSearchService.searchDharamShala(tirthId);
		DsMaster oDs =new DsMaster();		
		modelAndView.addObject("dharamshalaObj",oDs);
		modelAndView.addObject("dharamshalaList",dsList);
		
		//To list Tirth Details
		
		List tirthDetailsLst =dsSearchService.getTirthDeatils(tirthId);
		Tirth oTirth =new Tirth();		
		modelAndView.addObject("tirthObj",oTirth);
		modelAndView.addObject("tirthDetailsList",tirthDetailsLst);
		
		//To list near by city details
		
		List nearByCityLst =dsSearchService.getNearByCityDetails(tirthId);
		DsNearByCity oNearByCity= new DsNearByCity();
		modelAndView.addObject("nearByObj",oNearByCity);
		modelAndView.addObject("nearByCityList",nearByCityLst);
				
		modelAndView.addObject("roomSearchForm",new RoomSearchForm());
		return modelAndView;
	}

}
