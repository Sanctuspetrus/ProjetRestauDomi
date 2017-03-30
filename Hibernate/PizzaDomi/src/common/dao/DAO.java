package common.dao; 

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import common.bean.Ingredients;
import common.bean.Pate;
import common.bean.Pizza;
import common.bean.Users; 

@Repository("dao")
public class DAO { 

	EntityManagerFactory emf = null; 
	EntityManager em = null; 
	
	public DAO(){
		
	}

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

	@Transactional
	public void enregistrerIngredient(Ingredients ing) { 


    	EntityTransaction tx = this.em.getTransaction(); 
    	tx.begin(); 
		em.persist(ing); 
		tx.commit();

	} 

	@Transactional
	public List<Ingredients> getIngredients() { 
		List <Ingredients> lst = em.createQuery("select i from Ingredients i").getResultList(); 
		return lst; 
	} 

	@Transactional
	public Ingredients getIngredientsById(Integer id){
		List<Ingredients> lst = em.createQuery("select i from Ingredients i where id="+id.intValue()).getResultList();
		if(lst.isEmpty())
			return null;

		return lst.get(0);
	}

	@Transactional
	public void enregistrerPate(Pate pate) { 


    	EntityTransaction tx = this.em.getTransaction(); 
    	tx.begin(); 
		em.persist(pate); 
		tx.commit();

	} 

	@Transactional
	public List<Pate> listerPates() { 
		List <Pate> lst = em.createQuery("select p from Pate p").getResultList(); 
		return lst; 
	} 

	@Transactional
	public void createPizza(Pizza piz) {

    	EntityTransaction tx = this.em.getTransaction(); 
    	tx.begin(); 
		em.persist(piz); 
		tx.commit();

	} 

	@Transactional
	public void deletePizza(Integer id){
		Pizza prod = getPizzaById(id);

    	EntityTransaction tx = this.em.getTransaction(); 
    	tx.begin(); 
		em.remove(prod);
		tx.commit();
	}

	@Transactional
	public List<Pizza> getPizzasByIngredients(List<Ingredients> blackList, List<Ingredients> whiteList) {
		
		String queryString = "select p from Pizza p where ";
		String query2 = "select p from Pizza p where :numberOfIngredients = (select count(distinct ing.id) from"
				+ " Pizza p2 inner join p2.ingredients ing where b2.id = p.id and ing IN (:whiteList))";
		/*int index = 1;
		for(Ingredients in : whiteList){
			queryString += "p.ingredients=:in ";
			if(index != whiteList.size()){
				queryString += "and ";
			}
			index++;
		}*/
		/*int index = 1;
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
		}*/
		
		System.out.println(query2);
		List <Pizza> lst = em.createQuery(query2).getResultList(); 
		return lst; 
		//return null;
	} 

	@Transactional
	public List<Pizza> getPizzas() { 
		List <Pizza> lst = em.createQuery("select p from Pizza p").getResultList(); 
		return lst; 
	} 
	
	@Transactional
	public Pizza getPizzaById(Integer id){
		List<Pizza> piz = em.createQuery("select p from produit p where id="+id.intValue()).getResultList();
		if(piz.isEmpty())
			return null;

		return piz.get(0);
	}
	
	@Transactional
	public Collection<Users> getUserByIdPizza(Integer idPizza){
		Pizza piz = this.getPizzaById(idPizza);
		return piz.getUsers();
	}

	@Transactional
	public void createUser(Users usr) { 

    	EntityTransaction tx = this.em.getTransaction(); 
    	tx.begin(); 
		em.persist(usr); 
		tx.commit();

	} 
	
	@Transactional
	public void createUser(String nom, String mdp ) { 
		Users usr = new Users(nom, mdp);
		createUser(usr);

	}
	
	@Transactional
	public int updateUser(Users usr ) { 
		createUser(usr);
		return 1;
	}

	@Transactional
	public List<Users> listerUser() { 
		List <Users> lst = em.createQuery("select p from Users p").getResultList(); 
		return lst; 
	} 
	
	@Transactional
	public Users getUser(Integer id){
		List<Users> usr = em.createQuery("select p from Users p where id="+id.intValue()).getResultList();
		if(usr.isEmpty())
			return null;

		return usr.get(0);
	}
	
	@Transactional
	public Collection<Pizza> getUsersFavPizzas(Integer id){
		Users usr = this.getUser(id);
		return usr.getFavoris();
	}
	
	@Transactional
	public String connexionUser(String nom, String mdp ){
		List<Users> usr = em.createQuery("select p from Users p where nom="+nom+" and motDePasse="+mdp).getResultList();
		if(usr.isEmpty())
			return null;
		return (Math.random()*1000)+"";
	}
}