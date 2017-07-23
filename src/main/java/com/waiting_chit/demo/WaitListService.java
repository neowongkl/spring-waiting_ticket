package com.waiting_chit.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WaitListService {
	
	private int count = 2;
	
	private List<Customer> waitList = new ArrayList<>(Arrays.asList(
			new Customer(1,"11@11.com"),
			new Customer(2,"neo.wongkl@gmail.com")
			));
	
	public List<Customer> getWaitList(){
		return waitList;
	}
	
	public void addCustomer(String mail){
		waitList.add(new Customer(++count, mail));
	}
	
	public void dequeueWaitList(){
		waitList.remove(0);
	}
	
	public Customer getLastCustomerInWaitList(){
		return waitList.get(waitList.size()-1);
	}
	
	public Customer getCurrentCustomerInWaitList(){
		return waitList.get(0);
	}
	
	public Customer getNextCustomerInWaitList(){
		return waitList.get(1);
	}
	
	public boolean isWaitListEmpty(){
		return waitList.isEmpty();
	}
	
	public boolean isWaitListHaveNext(){
		if( waitList.size() == 2){
			return true;
		}else{
			return false;
		}
	}
	
}
