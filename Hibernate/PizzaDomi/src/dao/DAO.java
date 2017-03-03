package dao; 

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.Ingredients;
import bean.Pate;
import bean.Pizza;
import bean.Users; 

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
	

	public List<Pizza> listerPizzasWithIngredients(Map<String, String> whiteList) {
		
		String queryString = "select p from Pizza p where ";
		
		int index = 1;
		Set<String> paramKeys = whiteList.keySet();
		for (String paramKey : paramKeys) {
			if(Integer.getInteger(whiteList.get(paramKey)) != null){
				queryString += "`"+paramKey+"`="+whiteList.get(paramKey);
			}else{
				queryString += "`"+paramKey+"`='"+whiteList.get(paramKey)+"'";
			}
			if(index < paramKeys.size()){
				queryString += " and ";
			}
			index++;
		}
		
		System.out.println(queryString);
		List <Pizza> lst = em.createQuery(queryString).getResultList(); 
		return lst; 
	} 

	public List<Pizza> listerPizza() { 
		List <Pizza> lst = em.createQuery("select p from Pizza p").getResultList(); 
		return lst; 
	} 


	public void enregistrerUser(Users usr) { 
		em.persist(usr); 

	} 

	public List<Users> listerUser() { 
		List <Users> lst = em.createQuery("select p from Users p").getResultList(); 
		return lst; 
	} 
}