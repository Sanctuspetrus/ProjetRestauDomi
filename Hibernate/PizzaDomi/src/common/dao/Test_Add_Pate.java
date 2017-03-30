package common.dao; 
 
import javax.persistence.EntityTransaction;

import common.bean.Pate; 
 
public class Test_Add_Pate {
 
  public static void main(String [] args) { 
     
    DAO dao = new DAO(); 
    Pate pat = new Pate("Epaisse", 25.2); 
    dao.enregistrerPate(pat); 
     
     
    System.out.println("id = "+pat.getId()); 
     
     
  } 
}