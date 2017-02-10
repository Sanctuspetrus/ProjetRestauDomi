package dao;

import java.util.List;

import bean.Pizza;
import bean.User;

public class Test_List_User {
	  public static void main(String [] args) { 
		     
		    DAO dao = new DAO(); 
		    dao.ouvrir(); 
		     
		    List<User> usrs = dao.listerUser(); 
		     
		    System.out.println(); 
		    System.out.println("nb Users = "+usrs.size()); 
		     
		    for (User usr : usrs) { 
		      System.out.println("User nom = "+usr.getId());
		      for (Pizza pizz : usr.getFavoris()) {
		    	  System.out.println("- Pizza : "+ pizz.getNom());
		      }
		    } 
		     
		    dao.fermer(); 
		  } 
}
