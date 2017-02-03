package dao; 
 
import java.util.List; 
 
import bean.Ingredients; 
 
public class Test_Lister_Ing { 
 
   
  public static void main(String [] args) { 
     
    DAO dao = new DAO(); 
    dao.ouvrir(); 
     
    List<Ingredients> ings = dao.listerIngredients(); 
     
    System.out.println(); 
    System.out.println("nb ingredients = "+ings.size()); 
     
    for (Ingredients in : ings) { 
      System.out.println("Ingredient "+in.getId()+" nom = "+in.getNom()+", prix = "+ in.getPrix()+"€");
    } 
     
    dao.fermer(); 
  } 
   
}