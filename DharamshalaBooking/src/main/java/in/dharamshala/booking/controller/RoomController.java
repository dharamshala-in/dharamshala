package in.dharamshala.booking.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.dharamshala.booking.form.RoomSearchForm;
import in.dharamshala.booking.model.DsCustomerDetails;
import in.dharamshala.booking.model.DsMaster;
import in.dharamshala.booking.model.DsRoomBookingDetails;
import in.dharamshala.booking.model.DsRoomMapping;
import in.dharamshala.booking.model.DsRoomPrice;
import in.dharamshala.booking.model.DsRoomType;
import in.dharamshala.booking.model.Mail;
import in.dharamshala.booking.service.DsSearchService;
import in.dharamshala.booking.service.EmailService;
import in.dharamshala.booking.service.RoomDetailsService;

@Controller
public class RoomController {
	private static final Logger logger=LoggerFactory.getLogger(RoomController.class);

	@Autowired(required = true)
	protected RoomDetailsService roomDetailsService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	DsSearchService dsSearchService;
	
	protected DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	//protected DateFormat dateFormat = new SimpleDateFormat("EEE,d MMM yyyy HH:mm:ss");
	@InitBinder
	public void bindingPreparation(WebDataBinder binder) {
	  
	  CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat, true);
	  binder.registerCustomEditor(Date.class, customDateEditor);
	}
	
	@PostMapping(value = "/dsRoomType")
	public ModelAndView dsSearchHomePage(@ModelAttribute("roomSearchForm") RoomSearchForm roomSearchForm ,BindingResult result
			  ) {
		
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			return modelAndView;
		}
		long dharamshalaId=roomSearchForm.getDsId();
		logger.info("inside room type get dsId==================="+dharamshalaId);
		modelAndView.setViewName("RoomTypeDetails");
		
		// to get room type and price
		List<DsRoomType> roomTypeDetails =roomDetailsService.getRoomDetails(dharamshalaId);
		modelAndView.addObject("roomTypeDtls",roomTypeDetails);
		 	
		roomSearchForm.setDsId(dharamshalaId);
		return modelAndView;		
	}
	
	
	@PostMapping(value = "/dsRoomList")
	public ModelAndView dsSearchRoom(@ModelAttribute("roomSearchForm") RoomSearchForm roomSearchForm, 
			BindingResult result) throws ParseException  {
		
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			return modelAndView;
		}
		modelAndView.setViewName("RoomTypeDetails");
		
		logger.info("inside ds room search post dsId is==================="+roomSearchForm.getDsId() +"room type id is " +roomSearchForm.getRoomTypeId());
		logger.info("inside ds room search post check in date==================="+roomSearchForm.getCheckIn() +"check out date is " +roomSearchForm.getCheckOut());
		
		long roomTypeId=roomSearchForm.getRoomTypeId();
		long dharamshalaId=roomSearchForm.getDsId();
		Date checkInDate = roomSearchForm.getCheckIn();
		Date checkOutDate = roomSearchForm.getCheckOut();			
				
		// to get room type and price
		List<DsRoomType> roomTypeDetails =roomDetailsService.getRoomDetails(dharamshalaId);
		modelAndView.addObject("roomTypeDtls",roomTypeDetails);
		
		// to get room reservation status -room number
		List<DsRoomMapping> roomNoList =roomDetailsService.getRoomReservationStatus(dharamshalaId,roomTypeId,checkInDate,checkOutDate);
		modelAndView.addObject("roomNoList",roomNoList);
		
		DsRoomMapping dsRoomMapping=new DsRoomMapping();
		
		modelAndView.addObject("roomMapping",dsRoomMapping);
		
		return modelAndView;
	}
	
	@PostMapping(value = "/dsGuestInfo")
	public ModelAndView dsGuestInfoPage(@ModelAttribute("roomSearchForm") RoomSearchForm roomSearchForm, 
			BindingResult result) throws ParseException  {
		
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			return modelAndView;
		}
		modelAndView.setViewName("guestInfoCaptureScreen");
		
		logger.info("inside dsGuestInfoPage post dsId is==================="+roomSearchForm.getDsId() +"room type id is " +roomSearchForm.getRoomTypeId());
		logger.info("inside dsGuestInfoPage post check in date==================="+roomSearchForm.getCheckIn() +"check out date is " +roomSearchForm.getCheckOut()+" roomSearchForm.getNoOfChilds():"+roomSearchForm.getNoOfChilds());
		
		long roomTypeId=roomSearchForm.getRoomTypeId();
		long dharamshalaId=roomSearchForm.getDsId();
		Date checkInDate = roomSearchForm.getCheckIn();
		Date checkOutDate = roomSearchForm.getCheckOut();			
				
		//get Id card Types
		Map<String, String> idTypeList =roomDetailsService.getAllIdTypes();
		
		modelAndView.addObject("idTypeLst", idTypeList);
//		roomSearchForm.setDsId(dharamshalaId);
//		roomSearchForm.setNoOfAdults(roomSearchForm.getNoOfAdults());
//		roomSearchForm.setNoOfChilds(roomSearchForm.getNoOfChilds());
		roomSearchForm.setNoOfRooms(roomSearchForm.getRoomNumbers().length);
//		roomSearchForm.setRoomNumbers(roomSearchForm.getRoomNumbers());
//		roomSearchForm.setRoomTypeId(roomTypeId);
		modelAndView.addObject("roomSearchForm",roomSearchForm);
		return modelAndView;
	}
	
	@PostMapping(value = "/dsShowBookSummary")
	public ModelAndView dsShowBookSummary(@ModelAttribute("roomSearchForm") RoomSearchForm roomSearchForm,BindingResult result
			  ) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			return modelAndView;
		}
		modelAndView.setViewName("showBookSummary");
		
		long dharamshalaId=roomSearchForm.getDsId();
		long roomTypeId=roomSearchForm.getRoomTypeId();
		long noOfRooms=roomSearchForm.getRoomNumbers().length;
		logger.info("checkout::" + roomSearchForm.getCheckOut()+" checkin::"+roomSearchForm.getCheckIn());
		
		long totalAmount=0;
		long days=0;		
		long diff = roomSearchForm.getCheckOut().getTime() - roomSearchForm.getCheckIn().getTime();
		List<DsCustomerDetails> selfDetails =new ArrayList<DsCustomerDetails>();
		List<DsMaster> dsDetails =new ArrayList<DsMaster>();
		
		
		logger.info("Booking for:: "+ roomSearchForm.getBookingForSelf());
		logger.info("inside dsShowBookSummary dsId==================="+dharamshalaId+" roomType Id::"+roomSearchForm.getRoomTypeId()+"no of rooms selected"+roomSearchForm.getRoomNumbers().length);
		
		//fetching data for self
		if(roomSearchForm.getBookingForSelf().equals("self")){
			logger.info("inside self:: username::"+Principal.class.getName());
			selfDetails=roomDetailsService.getUserDetails(Principal.class.getName());
		}
		//fetching Dharamshala details
		dsDetails=roomDetailsService.getDharamshalaDetails(dharamshalaId);
		
		// calculation for convenience fee and total amount to be paid
		days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);		
		logger.info("diff::"+diff+" Number of Days:: " + days);
		List<DsRoomType>roomTypeList=roomDetailsService.getRoomTypePrice(dharamshalaId,roomTypeId);
		modelAndView.addObject("roomTypeList",roomTypeList);
		for(DsRoomType roomprice : roomTypeList){
			Collection<DsRoomPrice> priceCollection = roomprice.getDsRoomPriceCollection();
			if(!priceCollection.isEmpty())
			{
				Long lprice = priceCollection.iterator().next().getPrice();
				lprice = lprice * noOfRooms * days;
				//System.out.println("roomprice::"+price);
				Long conFee = lprice/10;
				totalAmount=lprice+conFee;
				
				roomSearchForm.setPrice(lprice.toString());
				roomSearchForm.setConvinenceFee(conFee);
				logger.info("roomprice::"+lprice+"Fee::" + conFee+"totalAmount::"+totalAmount);
			}
			roomSearchForm.setRoomType(roomprice.getRoomCategory());
		}
		roomSearchForm.setNoOfDays(days);
//		roomSearchForm.setNoOfAdults(roomSearchForm.getNoOfAdults());
//		roomSearchForm.setNoOfChilds(roomSearchForm.getNoOfChilds());
		roomSearchForm.setNoOfRooms(noOfRooms);
//		roomSearchForm.setDsId(dharamshalaId);
		roomSearchForm.setTotalAmount(totalAmount);
		modelAndView.addObject("dsDetails",dsDetails);
		modelAndView.addObject("selfDetails", selfDetails);
		modelAndView.addObject("roomSearchForm",roomSearchForm);
		return modelAndView;		
	}
	
	@PostMapping(value = "/dsBookRoom")
	public ModelAndView dsBookRoom(@ModelAttribute("roomSearchForm") RoomSearchForm roomSearchForm,BindingResult result
			  ) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			return modelAndView;
		}
		modelAndView.setViewName("bookRoomConfirmation");
		String username;
		String dharamshalaName = "";
		String dsCity="";
		long dharamshalaId=roomSearchForm.getDsId();
		long roomTypeId=roomSearchForm.getRoomTypeId();
		long noOfRooms=roomSearchForm.getRoomNumbers().length;
		logger.info("checkout::" + roomSearchForm.getCheckOut()+" checkin::"+roomSearchForm.getCheckIn());
		
		long totalAmount=0;
		long days=0;		
		long diff = roomSearchForm.getCheckOut().getTime() - roomSearchForm.getCheckIn().getTime();
		
		List<DsRoomBookingDetails> dsBookDetails =new ArrayList<DsRoomBookingDetails>();
		List<DsMaster> dsDharamshalaList =new ArrayList<DsMaster>();
		
		logger.info("Booking for:: "+ roomSearchForm.getBookingForSelf());
		logger.info("inside dsShowBookSummary dsId==================="+dharamshalaId+" roomType::"+roomSearchForm.getRoomType()+"no of rooms selected"+roomSearchForm.getRoomNumbers().length);
		
		
		days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);		
		logger.info("diff::"+diff+" Number of Days:: " + days);
		if(days==roomSearchForm.getNoOfDays())
		{
			
			//username=Principal.class.getName();
			username="anonymous";
			dsBookDetails = roomDetailsService.addBookRoom(roomSearchForm.getRoomNumbers(), roomSearchForm.getDsId(),
					roomSearchForm.getRoomTypeId(), roomSearchForm.getCheckIn(), roomSearchForm.getCheckOut(),
					roomSearchForm.getPrice(), roomSearchForm.getBookingForSelf(), roomSearchForm.getNoOfAdults(),
					roomSearchForm.getNoOfChilds(), username, roomSearchForm.getGuestName(), roomSearchForm.getDob(),
					roomSearchForm.getIdType(), roomSearchForm.getIdCardNo(), roomSearchForm.getMobileNo(),
					roomSearchForm.getEmail(), roomSearchForm.getCity(), roomSearchForm.getCountry());
			logger.info("size of booking list id::"+dsBookDetails.size());
			if(dsBookDetails.size()>0){
				dsDharamshalaList=roomDetailsService.getDharamshalaDetails(dharamshalaId);
				for(DsMaster dsMaster:dsDharamshalaList){
					dharamshalaName=dsMaster.getDsName();
					dsCity=dsMaster.getDsCity();
				}
				for (DsRoomBookingDetails dsRoomBookingDetails : dsBookDetails) {
					
					Mail mail = new Mail();
			        mail.setMailFrom("shweta.silver06@gmail.com");
			        mail.setMailTo(roomSearchForm.getEmail());
			        mail.setMailSubject("Booking Confirmation on Dharamshala.in");
			        
			        Map < String, Object > model = new HashMap < String, Object > ();
			        model.put("bookingId", dsRoomBookingDetails.getBookingId());			        
			        model.put("dharamshalaName",dharamshalaName);
			        model.put("city",dsCity);
			        model.put("dateOfBooking",dsRoomBookingDetails.getBookingDate());
			          
			        model.put("checkIn", dsRoomBookingDetails.getCheckIn());
			        model.put("checkOut",dsRoomBookingDetails.getCheckOut());
			        model.put("roomType",roomSearchForm.getRoomType());
			        model.put("roomNumber",dsRoomBookingDetails.getRoomNumber());
			        model.put("noOfAdults",dsRoomBookingDetails.getNoOfAdults());
			        model.put("noOfChilds",dsRoomBookingDetails.getNoOfChilds());
			        model.put("price", dsRoomBookingDetails.getPrice());
			        mail.setModel(model);
			        emailService.sendEmail(mail,"invoice-template.html");
				}
			}
		
		}else{
			System.out.println("data manipulated");
			modelAndView.setViewName("error");
			return modelAndView;
		}
		
		
		roomSearchForm.setNoOfDays(days);
//		roomSearchForm.setNoOfAdults(roomSearchForm.getNoOfAdults());
//		roomSearchForm.setNoOfChilds(roomSearchForm.getNoOfChilds());
		roomSearchForm.setNoOfRooms(noOfRooms);
//		roomSearchForm.setDsId(dharamshalaId);
		roomSearchForm.setTotalAmount(totalAmount);
		
		modelAndView.addObject("roomSearchForm",roomSearchForm);
		return modelAndView;		
	}
	
	// method to populate dropdown list
	@ModelAttribute("roomTypeList")
	public Map<String, String> configureRoomTypeList(@ModelAttribute ("roomSearchForm") RoomSearchForm roomSearchForm) {
		Map<String, String> roomTypeDropDownList = new HashMap<String, String>();
		logger.info("inside room type list dsId==================="+roomSearchForm.getDsId());
		roomTypeDropDownList = roomDetailsService.getUniqueRoomTypes(roomSearchForm.getDsId());
		return roomTypeDropDownList;
	}
	@ModelAttribute("numOfAdultsList")
	public Map<String, String> configureAdultList() {
		Map<String, String> allowedAdultList = new HashMap<String, String>();
		//logger.info("inside room type get dsId==================="+roomSearchForm.getDsId());
		allowedAdultList.put("1", "1") ;
		allowedAdultList.put("2", "2") ;
		allowedAdultList.put("3", "3") ;
		return allowedAdultList;
	}
	@ModelAttribute("numOfChildsList")
	public Map<String, String> configureChildList() {
		Map<String, String> allowedChildList = new HashMap<String, String>();
		//logger.info("inside room type get dsId==================="+roomSearchForm.getDsId());
		allowedChildList.put("1", "1") ;
		allowedChildList.put("2", "2") ;
		return allowedChildList;
	}
}
