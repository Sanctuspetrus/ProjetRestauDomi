package common.dao; 

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import common.bean.Ingredients;
import common.bean.Pate;
import common.bean.Pizza;
import common.bean.Users; 

public class DAO { 
	
	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 
	 public void setSessionFactory(SessionFactory sf) {
		 this.sessionFactory = sf;
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

	
	public void enregistrerIngredient(Ingredients ing) { 

		  Session session = this.sessionFactory.getCurrentSession();
		  session.persist(ing);

	} 

	
	public List<Ingredients> getIngredients() { 
		List <Ingredients> lst = em.createQuery("select i from Ingredients i").getResultList(); 
		return lst; 
	} 

	
	public Ingredients getIngredientsById(Integer id){
		Session session = this.sessionFactory.getCurrentSession();
		Ingredients ing = (Ingredients) session.load(Ingredients.class, new Integer(id));

		return ing;
	}

	
	public void enregistrerPate(Pate pate) { 



		  Session session = this.sessionFactory.getCurrentSession();
		  session.persist(pate);

	} 

	
	public List<Pate> listerPates() { 
		Session session = this.sessionFactory.getCurrentSession();
		List<Pate> lst = session.createQuery("from Pate").getResultList();
		return lst; 
	} 

	
	public void createPizza(Pizza piz) {

		  Session session = this.sessionFactory.getCurrentSession();
		  session.persist(piz);

	} 

	
	public void deletePizza(Integer id){
		 Session session = this.sessionFactory.getCurrentSession();
		 Pizza p = (Pizza) session.load(Pizza.class, new Integer(id));
		 if (null != p) {
			 session.delete(p);
		}
		 
	}

	
	public List<Pizza> getPizzasByIngredients(List<Ingredients> blackList, List<Ingredients> whiteList) {
		
		String queryString = "select p from Pizza p where ";
		String query2 = "select p from Pizza p where :numberOfIngredients = (select count(distinct ing.id) from"
				+ " Pizza p2 inner join p2.ingredients ing where b2.id = p.id and ing IN (:whiteList))";
		int index = 1;
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
		}
		
		System.out.println(query2);
		List <Pizza> lst = em.createQuery(query2).getResultList(); 
		return lst; 
		//return null;
	} 

	
	public List<Pizza> getPizzas() { 
		Session session = this.sessionFactory.getCurrentSession();
		List<Pizza> lst = session.createQuery("from Pizza").getResultList();
		return lst; 
	} 
	
	
	public Pizza getPizzaById(Integer id){
		Session session = this.sessionFactory.getCurrentSession();
		Pizza piz = (Pizza) session.load(Pizza.class, new Integer(id));

		return piz;
	}
	
	
	public Collection<Users> getUserByIdPizza(Integer idPizza){
		Pizza piz = this.getPizzaById(idPizza);
		return piz.getUsers();
	}

	
	public void createUser(Users usr) { 

		  Session session = this.sessionFactory.getCurrentSession();
		  session.persist(usr);

	} 
	
	
	public void createUser(String nom, String mdp ) { 
		Users usr = new Users(nom, mdp);
		createUser(usr);

	}
	
	
	public int updateUser(Users usr ) { 
		createUser(usr);
		return 1;
	}

	
	public List<Users> listerUser() { 
		Session session = this.sessionFactory.getCurrentSession();
		List<Users> lst = session.createQuery("from Users").getResultList();
		return lst; 
	} 
	
	
	public Users getUser(Integer id){
		Session session = this.sessionFactory.getCurrentSession();
		Users usr = (Users) session.load(Users.class, new Integer(id));
		return usr;
	}
	
	
	public Collection<Pizza> getUsersFavPizzas(Integer id){
		Users usr = this.getUser(id);
		return usr.getFavoris();
	}
	
	
	public String connexionUser(String nom, String mdp ){
		Session session = this.sessionFactory.getCurrentSession();
		List<Users> lst = session.createQuery("select p from Users p where nom="+nom+" and motDePasse="+mdp).getResultList();
		if(lst.isEmpty())
			return null;
		return (Math.random()*1000)+"";
	}
}