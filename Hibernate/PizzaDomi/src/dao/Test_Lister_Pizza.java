package dao;

import java.util.List;

import bean.Ingredient;
import bean.Pizza;

public class Test_Lister_Pizza {
 
	   
	  public static void main(String [] args) { 
	     
	    DAO dao = new DAO(); 
	    dao.ouvrir(); 
	     
	    List<Pizza> pizs = dao.listerPizza(); 
	     
	    System.out.println(); 
	    System.out.println("nb Pizzas = "+pizs.size()); 
	     
	    for (Pizza piz : pizs) { 
	      System.out.println("Pizza "+piz.getId()+" nom = "+piz.getNom());
	      for(Ingredient in : piz.getIngredients()){
	    	  System.out.println("- ingredient : "+in.getNom());
	      }
	    } 
	     
	    dao.fermer(); 
	  } 
	   
	
}
