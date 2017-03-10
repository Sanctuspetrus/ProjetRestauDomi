package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dao.DAO;

	  
	@RestController  
	public class Controller {  
	   
	 @Autowired  
	 DAO dao;  
	   
	 @RequestMapping(value = "/getAllCountries", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public List<Country> getCountries() {  
	    
	  List<Country> listOfCountries = dao.getAllCountries();  
	  return listOfCountries;  
	 }  
	  
	 @RequestMapping(value = "/getCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public Country getCountryById(@PathVariable int id) {  
	  return dao.getCountry(id);  
	 }  
	  
	 @RequestMapping(value = "/addCountry", method = RequestMethod.POST, headers = "Accept=application/json")  
	 public void addCountry(@RequestBody Country country) {   
		 service.addCountry(country);  
	    
	 }  
	  
	 @RequestMapping(value = "/updateCountry", method = RequestMethod.PUT, headers = "Accept=application/json")  
	 public void updateCountry(@RequestBody Country country) {  
		 service.updateCountry(country);  
	 }  
	  
	 @RequestMapping(value = "/deleteCountry/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
	 public void deleteCountry(@PathVariable("id") int id) {  
		 service.deleteCountry(id);    
	 }   
	}  

