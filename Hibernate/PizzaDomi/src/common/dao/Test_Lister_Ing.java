package common.dao; 
 
import java.util.List;

import common.bean.Ingredients;
import common.bean.Pizza; 
 
public class Test_Lister_Ing { 
 
   
  public static void main(String [] args) { 
     
    DAO dao = new DAO(); 
     
    List<Ingredients> ings = dao.getIngredients(); 
     
    System.out.println(); 
    System.out.println("nb ingredients = "+ings.size()); 
     
    for (Ingredients in : ings) { 
      System.out.println("Ingredient "+in.getId()+" nom = "+in.getNom()+", prix = "+ in.getPrix()+"�");
      for (Pizza pizz : in.getPizzas()) {
    	  System.out.println("- Pizza : "+ pizz.getNom());
      }
    } 
  } 
   
}