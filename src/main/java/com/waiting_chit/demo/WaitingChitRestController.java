package com.waiting_chit.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WaitingChitRestController {
	
	@Autowired
	private WaitListService waitListService;
	
	@Autowired
	private mailService mailService;
	
//	@RequestMapping(value="/addtwotoone", method={RequestMethod.GET})
//	public List addtwotoone(){
//		 List a1 = new ArrayList();
//	      a1.add("addtwotoone response");
//		return a1;
//	}
//	
//	@RequestMapping(value="/addfourabove", method={RequestMethod.GET})
//	public List addfourabove(){
//		 List a1 = new ArrayList();
//	      a1.add("addfourabove response");
//		return a1;
//	}
	
	
	@RequestMapping(value="/getWaitList", method={RequestMethod.GET})
	public List<Customer> getWaitList(){
		return waitListService.getWaitList();
		
	}
	
	@RequestMapping(value="/addonetotwo", method={RequestMethod.POST})
	public void addonetotwo(@RequestBody String mail){
		waitListService.addCustomer(mail);
		mailService.sendEmailToNewCustomer(waitListService.getLastCustomerInWaitList());
		
	}
	
	@RequestMapping(value="/dequeueWaitList", method={RequestMethod.GET})
	public void dequeueWaitList(){
		waitListService.dequeueWaitList();
		if(!waitListService.isWaitListEmpty()){
			mailService.sendEmailToCurrentCustomer(waitListService.getCurrentCustomerInWaitList());
		}
		if(waitListService.isWaitListHaveNext()){
			mailService.sendEmailToNextCustomer(waitListService.getNextCustomerInWaitList());
		}
		
	}
	
	
	
}
