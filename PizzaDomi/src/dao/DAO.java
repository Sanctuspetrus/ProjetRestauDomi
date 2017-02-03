package dao; 
 
import java.util.List; 
 
import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory; 
import javax.persistence.Persistence; 
 
import bean.Ingredients; 
 
public class DAO { 
 
  EntityManagerFactory emf = null; 
  EntityManager em = null; 
   
  public void ouvrir() { 
    try { 
      emf = Persistence.createEntityManagerFactory("PizzaDomi"); 
      em = emf.createEntityManager();     
    } 
    catch (Exception e) { 
      System.out.println("Erreur DAO.ouvrir "+e.getMessage()); 
    } 
     
  } 
   
  public void fermer() { 
    try { 
      em.close(); 
      emf.close(); 
    } 
    catch (Exception e) { 
      System.out.println("Erreur DAO.fermer "+e.getMessage()); 
    } 
  } 
 
  public void enregistrerIngredient(Ingredients ing) { 
    em.persist(ing); 
     
  } 
 
  public List<Ingredients> listerIngredients() { 
    List <Ingredients> lst = em.createQuery("select i from Ingredients i").getResultList(); 
    return lst; 
  } 
}