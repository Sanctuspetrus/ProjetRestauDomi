package dao;

import java.util.List;

import bean.Pizza;

public class Test_Lister_Pizza {
 
	   
	  public static void main(String [] args) { 
	     
	    DAO dao = new DAO(); 
	    dao.ouvrir(); 
	     
	    List<Pizza> pizs = dao.listerPizza(); 
	     
	    System.out.println(); 
	    System.out.println("nb ingredients = "+pizs.size()); 
	     
	    for (Pizza in : pizs) { 
	      System.out.println("Ingredient "+in.getId()+" nom = "+in.getNom());
	    } 
	     
	    dao.fermer(); 
	  } 
	   
	
}
