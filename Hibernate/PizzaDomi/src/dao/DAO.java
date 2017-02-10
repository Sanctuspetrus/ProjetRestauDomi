package dao; 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.Ingredient;
import bean.Pate;
import bean.Pizza;
import bean.User; 

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

	public void enregistrerIngredient(Ingredient ing) { 
		em.persist(ing); 

	} 

	public List<Ingredient> listerIngredients() { 
		List <Ingredient> lst = em.createQuery("select i from Ingredients i").getResultList(); 
		return lst; 
	} 

	public void enregistrerPate(Pate pate) { 
		em.persist(pate); 

	} 

	public List<Pate> listerPates() { 
		List <Pate> lst = em.createQuery("select p from Pate p").getResultList(); 
		return lst; 
	} 

	public void enregistrerPizza(Pizza piz) { 
		em.persist(piz); 

	} 

	public List<Pizza> listerPizza() { 
		List <Pizza> lst = em.createQuery("select p from Pizza p").getResultList(); 
		return lst; 
	} 


	public void enregistrerUser(User usr) { 
		em.persist(usr); 

	} 

	public List<User> listerUser() { 
		List <User> lst = em.createQuery("select p from Users p").getResultList(); 
		return lst; 
	} 
}