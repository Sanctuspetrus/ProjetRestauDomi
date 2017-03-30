package common.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.bean.Ingredients;
import common.bean.Pizza;
import common.bean.Users;
import common.dao.DAO;

@Service("pizzaService")
public class PizzaService {

	@Autowired
	DAO dao;
	
	@Transactional
	public List<Pizza> getPizzas() {
		List<Pizza> listOfPizzas = dao.getPizzas();  
		return listOfPizzas;
	}

	@Transactional
	public Pizza getPizzaById(Integer id) {
		Pizza pizza = dao.getPizzaById(id); 
		return pizza;
	}

	@Transactional
	public Collection<Users> getUserByIdPizza(Integer id) {
		Collection<Users> listOfUsers = dao.getUserByIdPizza(id); 
		return listOfUsers;
	}
/*
	@Transactional
	public List<Pizza> getPizzasByIngredients(List<Ingredients> listeNoire, List<Ingredients> listeBlanche) {
		List<Pizza> listOfPizzas = dao.getPizzasByIngredients(listeNoire, listeBlanche); 
		return listOfPizzas;
	}
*/
	@Transactional
	public void createPizza(Pizza pizza) {
		dao.createPizza(pizza);

	}

	@Transactional
	public void deletePizza(int id) {
		dao.deletePizza(id); 
	}

	@Transactional
	public List<Ingredients> getIngredients() {
		List<Ingredients> listOfIngredients = dao.getIngredients();  
		return listOfIngredients;  
	}

	@Transactional
	public Ingredients getIngredientsById(Integer id) {
		Ingredients ingredient = dao.getIngredientsById(id); 
		return ingredient;
	}

	@Transactional
	public String connexionUser(String nom, String mdp) {
		return dao.connexionUser(nom, mdp);
	}

	@Transactional
	public void createUser(String nom, String mdp) {
		dao.createUser(nom, mdp);

	}

	@Transactional
	public int updateUser(Users user) {
		return dao.updateUser(user);
	}

	@Transactional
	public Users getUser(Integer id) {
		Users user = dao.getUser(id); 
		return user;
	}

	@Transactional
	public Collection<Pizza> getUsersFavPizzas(Integer id) {
		Collection<Pizza> listOfPizzas = dao.getUsersFavPizzas(id); 
		return listOfPizzas;
	}

}
