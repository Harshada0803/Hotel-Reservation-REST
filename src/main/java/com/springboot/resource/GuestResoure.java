package com.springboot.resource;

import java.sql.Date;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.Guest;
import com.springboot.model.GuestReservationDetails;
import com.springboot.service.GuestService;


@RestController
public class GuestResoure {
	@Autowired
	GuestService guestService;
	
	@GetMapping("login")
	public ModelAndView goToLoginPage()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		 mv.addObject("msg",null);
		return mv;
	}
	
	@GetMapping("register")
	public ModelAndView registerUser()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("register");
		return mv;
	}

	/*@RequestMapping("add")
	public  ModelAndView addNewGuest(@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,@RequestParam("emailid") String emailid,@RequestParam("password") String password, 
	@RequestParam("dateofbirth") Date dateofbirth,@RequestParam("cityname") String cityname)
	@PostMapping("register")
	public  Guest addNewGuest(@RequestBody Guest guest)
	{
	
		return guestService.registerNewGuest(guest);
	}*/
	
	@PostMapping("register")
	public   ModelAndView addNewGuest(@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,@RequestParam("emailid") String emailid,@RequestParam("password") String password, 
			@RequestParam("dateofbirth") Date dateofbirth,@RequestParam("cityname") String cityname)
	{
	
		ModelAndView mv=new ModelAndView();
		 Guest guest=new Guest();
		 guest.setGuestFirstName(firstname);
		 guest.setGuestLastName(lastname);
		 guest.setGuestEmailId(emailid);
		 guest.setGuestPassword(password);
		 guest.setDateOfBirth(dateofbirth);
		 guest.setCityOfGuest(cityname); 
		 guest=guestService.registerNewGuest(guest);
		 mv.setViewName("login");
		 mv.addObject("msg","You are Successfully Registered!! Please login for reservation ");
		return mv;
	}

	
	
	@GetMapping("check")
	public ModelAndView ckeckUser(@RequestParam("emailid") String email,@RequestParam("password") String password)
	{
		ModelAndView mv=new ModelAndView();
		Guest guest=guestService.checkGuest(email, password);
		System.out.print(guest);
		if(guest!=null)
		{
		  	mv.setViewName("afterLogin");
		  	mv.addObject("email", email);
		  	mv.addObject("password", password);
			return mv;
		}
		else
		{
			mv.setViewName("login");
			mv.addObject("msg", "Username or Password is wrong!!");
			return mv;

		}
	}
	
	@PostMapping("storedates")
	public ModelAndView guestDoReservation(@RequestParam("email") String email,@RequestParam("start") Date startDate,@RequestParam("end") Date endDate)
	{
		ModelAndView mv=new ModelAndView();
		Guest guest=guestService.getGuestByEmail(email);
		System.out.println(guest);
		 int age=Integer.parseInt(startDate.toString().substring(0, 4))-Integer.parseInt(guest.getDateOfBirth().toString().substring(0, 4));
		 long days = ChronoUnit.DAYS.between(startDate.toLocalDate(), endDate.toLocalDate());
		 long cost=4000*days;
		 GuestReservationDetails guestReservationDetails=new GuestReservationDetails();
		 guestReservationDetails.setGuest(guest);
		 guestReservationDetails.setEndDate(endDate);
		 guestReservationDetails.setStartDate(startDate);
		 guestReservationDetails.setGuestAge(age);
		 guestReservationDetails.setTotalAmount(cost);
		 guestReservationDetails.setTotalDays(days);
		 System.out.println(guestReservationDetails);
		 guestReservationDetails=guestService.addReservationInfo(guestReservationDetails);
		 System.out.println(guestReservationDetails);

		 mv.addObject("firstname",guest.getGuestFirstName());
		 mv.addObject("lastname",guest.getGuestLastName());
		 mv.addObject("age",age);
		 mv.addObject("cost",cost);
		 mv.addObject("days",days);
		 mv.setViewName("afterReservation");
		 return mv;
	}
	
	@GetMapping("accept")
	public ModelAndView acceptButton()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("afterAccept");
		return mv;
	}
	
	
	@GetMapping("history")
	public ModelAndView showAllHistory(@RequestParam("email") String email)
	{
		ModelAndView mv=new ModelAndView();
		List<GuestReservationDetails> list=guestService.getAllHistory(email);
		mv.setViewName("history");
		mv.addObject("list",list );
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("get")
	public List<Guest> getall()
	{
		return guestService.getAllGuest();
	}
	
	
	
	
	
	
	
	
	
	
}
