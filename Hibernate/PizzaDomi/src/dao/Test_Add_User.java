package dao;

import javax.persistence.EntityTransaction;

import bean.Users;

public class Test_Add_User {
	 
	  public static void main(String [] args) { 
	     
	    DAO dao = new DAO(); 
	    dao.ouvrir(); 
	     
	    EntityTransaction tx = dao.em.getTransaction(); 
	    tx.begin(); 
	     
	    Users usr = new Users("Jean-Claud", "Platipus"); 
	    
	    //usr.setFavoris(dao.listerPizza());
	    dao.enregistrerUser(usr); 
	     
	    tx.commit(); 
	     
	     
	    System.out.println("id = "+usr.getId()); 
	     
	     
	    dao.fermer(); 
	  } 
}
