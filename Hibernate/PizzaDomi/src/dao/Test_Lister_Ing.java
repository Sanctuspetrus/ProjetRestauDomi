package dao; 
 
import java.util.List; 
 
import bean.Ingredient;
import bean.Pizza; 
 
public class Test_Lister_Ing { 
 
   
  public static void main(String [] args) { 
     
    DAO dao = new DAO(); 
    dao.ouvrir(); 
     
    List<Ingredient> ings = dao.listerIngredients(); 
     
    System.out.println(); 
    System.out.println("nb ingredients = "+ings.size()); 
     
    for (Ingredient in : ings) { 
      System.out.println("Ingredient "+in.getId()+" nom = "+in.getNom()+", prix = "+ in.getPrix()+"€");
      for (Pizza pizz : in.getPizzas()) {
    	  System.out.println("- Pizza : "+ pizz.getNom());
      }
    } 
     
    dao.fermer(); 
  } 
   
}