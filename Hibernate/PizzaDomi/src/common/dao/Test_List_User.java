package common.dao;

import java.util.List;

import common.bean.Pizza;
import common.bean.Users;

public class Test_List_User {
	  public static void main(String [] args) { 
		     
		    DAO dao = new DAO(); 
		    dao.ouvrir(); 
		     
		    List<Users> usrs = dao.listerUser(); 
		     
		    System.out.println(); 
		    System.out.println("nb Users = "+usrs.size()); 
		     
		    for (Users usr : usrs) { 
		      System.out.println("User nom = "+usr.getId()+" : nom "+usr.getNom());
		      for (Pizza pizz : usr.getFavoris()) {
		    	  System.out.println("- Pizza : "+ pizz.getNom());
		      }
		    } 
		     
		    dao.fermer(); 
		  } 
}
