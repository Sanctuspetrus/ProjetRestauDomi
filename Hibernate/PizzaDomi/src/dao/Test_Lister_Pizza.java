package dao;

import java.util.List;

import bean.Pizza;

public class Test_Lister_Pizza {
 
	   
	  public static void main(String [] args) { 
	     
	    DAO dao = new DAO(); 
	    dao.ouvrir(); 
	     
	    List<Pizza> pizs = dao.listerPizza(); 
	     
	    System.out.println(); 
	    System.out.println("nb Pizzas = "+pizs.size()); 
	     
	    for (Pizza in : pizs) { 
	      System.out.println("Pizza "+in.getId()+" nom = "+in.getNom());
	    } 
	     
	    dao.fermer(); 
	  } 
	   
	
}
