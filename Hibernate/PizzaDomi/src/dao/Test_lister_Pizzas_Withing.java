package dao;

import java.util.List;

import bean.Ingredients;
import bean.Pizza;

public class Test_lister_Pizzas_Withing {

	public static void main(String[] args) {
	     
	    DAO dao = new DAO(); 
	    dao.ouvrir(); 
	    List<Ingredients> lst = dao.getIngredients();
	    List<Pizza> pizs = dao.getPizzasByIngredients(lst, lst); 
	     
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