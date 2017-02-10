package dao;

import javax.persistence.EntityTransaction;

import bean.User;

public class Test_Add_User {
	 
	  public static void main(String [] args) { 
	     
	    DAO dao = new DAO(); 
	    dao.ouvrir(); 
	     
	    EntityTransaction tx = dao.em.getTransaction(); 
	    tx.begin(); 
	     
	    User usr = new User("Jean-Claude Van Dam", "Platipus"); 
	    
	    dao.enregistrerUser(usr); 
	     
	    tx.commit(); 
	     
	    dao.em.refresh(usr); 
	     
	    System.out.println("id = "+usr.getId()); 
	     
	     
	    dao.fermer(); 
	  } 
}
