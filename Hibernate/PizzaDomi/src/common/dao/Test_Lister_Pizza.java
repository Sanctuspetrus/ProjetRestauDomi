package common.dao;

import java.util.List;

import common.bean.Ingredients;
import common.bean.Pizza;

public class Test_Lister_Pizza {
 
	   
	  public static void main(String [] args) { 
	     
	    DAO dao = new DAO(); 
	    dao.ouvrir(); 
	     
	    List<Pizza> pizs = dao.getPizzas(); 
	     
	    System.out.println(); 
	    System.out.println("nb Pizzas = "+pizs.size()); 
	     
	    for (Pizza piz : pizs) { 
	      System.out.println("Pizza "+piz.getId()+" nom = "+piz.getNom());
	      for(Ingredients in : piz.getIngredients()){
	    	  System.out.println("- ingredient : "+in.getNom());
	      }
	    } 
	     
	    dao.fermer(); 
	  } 
	   
	
}
