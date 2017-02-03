package dao;

 
import java.util.List;

import bean.Pate; 

 
public class Test_Lister_Pate { 
 
   
  public static void main(String [] args) { 
     
    DAO dao = new DAO(); 
    dao.ouvrir(); 
     
    List<Pate> ings = dao.listerPates(); 
     
    System.out.println(); 
    System.out.println("nb ingredients = "+ings.size()); 
     
    for (Pate in : ings) { 
      System.out.println("Ingredient "+in.getId()+" nom = "+in.getNom()+", prix = "+ in.getPrix()+"€");
    } 
     
    dao.fermer(); 
  } 
   
}