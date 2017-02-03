package dao; 
 
import javax.persistence.EntityTransaction;

import bean.Pate; 
 
public class Test_Add_Pate {
 
  public static void main(String [] args) { 
     
    DAO dao = new DAO(); 
    dao.ouvrir(); 
     
    EntityTransaction tx = dao.em.getTransaction(); 
    tx.begin(); 
     
    Pate pat = new Pate("Epaisse", 25.2); 
    dao.enregistrerPate(pat); 
     
    tx.commit(); 
     
    dao.em.refresh(pat); 
     
    System.out.println("id = "+pat.getId()); 
     
     
    dao.fermer(); 
  } 
}