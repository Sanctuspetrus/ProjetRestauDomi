package dao;

 
import java.util.List;

import bean.Pate; 

 
public class Test_Lister_Pate { 
 
   
  public static void main(String [] args) { 
     
    DAO dao = new DAO(); 
    dao.ouvrir(); 
     
    List<Pate> pates = dao.listerPates(); 
     
    System.out.println(); 
    System.out.println("nb ingredients = "+pates.size()); 
     
    for (Pate in : pates) { 
      System.out.println("Ingredient "+in.getId()+" nom = "+in.getNom()+", prix = "+ in.getPrix()+"€");
    } 
     
    dao.fermer(); 
  } 
   
}