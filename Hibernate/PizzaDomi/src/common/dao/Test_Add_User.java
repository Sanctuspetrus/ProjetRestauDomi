package common.dao;

import javax.persistence.EntityTransaction;

import common.bean.Users;

public class Test_Add_User {
	 
	  public static void main(String [] args) { 
	     
	    DAO dao = new DAO(); 
	    Users usr = new Users("Bertrant", "Platipus"); 
	    
	    usr.setFavoris(dao.getPizzas());
	    dao.createUser(usr); 
	     
	     
	     
	    System.out.println("id = "+usr.getId()); 
	     
	  } 
}
