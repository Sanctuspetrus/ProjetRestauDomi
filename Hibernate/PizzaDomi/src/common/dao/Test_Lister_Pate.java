package common.dao;

 
import java.util.List;

import common.bean.Pate; 

 
public class Test_Lister_Pate { 
 
   
  public static void main(String [] args) { 
     
    DAO dao = new DAO(); 
    dao.ouvrir(); 
     
    List<Pate> pates = dao.listerPates(); 
     
    System.out.println(); 
    System.out.println("nb Pates = "+pates.size()); 
     
    for (Pate in : pates) { 
      System.out.println("Pate "+in.getId()+" nom = "+in.getNom()+", prix = "+ in.getPrix()+"€");
    } 
     
    dao.fermer(); 
  } 
   
}