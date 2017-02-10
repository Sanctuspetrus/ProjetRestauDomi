package dao; 
 
import javax.persistence.EntityTransaction; 
 
import bean.Ingredients; 
 
public class Test_Add_Ing { 
 
  public static void main(String [] args) { 
     
    DAO dao = new DAO(); 
    dao.ouvrir(); 
     
    EntityTransaction tx = dao.em.getTransaction(); 
    tx.begin(); 
     
    Ingredients ing = new Ingredients("Patate", 10.5); 
    dao.enregistrerIngredient(ing); 
     
    tx.commit(); 
     
    dao.em.refresh(ing); 
     
    System.out.println("id = "+ing.getId()); 
     
     
    dao.fermer(); 
  } 
}