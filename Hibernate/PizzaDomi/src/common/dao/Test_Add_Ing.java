package common.dao; 
 
import common.bean.Ingredients; 
 
public class Test_Add_Ing { 
 
  public static void main(String [] args) { 
     
    DAO dao = new DAO(); 
     
     
    Ingredients ing = new Ingredients("Patate", 10.5); 
    dao.enregistrerIngredient(ing); 
     
     
     
    System.out.println("id = "+ing.getId()); 
     
     
  } 
}