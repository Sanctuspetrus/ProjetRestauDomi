package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bean.*;

import dao.DAO;


@RestController  
public class Controller {  

	@Autowired  
	DAO dao;  

	//***************************PIZZAS*************************************************************************
	
	@RequestMapping(value = "/pizzas", method = RequestMethod.GET, headers = "Accept=application/json")  
	public List<Pizza> getPizzas() {  
		List<Pizza> listOfPizzas = dao.getPizzas();  
		return listOfPizzas;  
	}

	@RequestMapping(value = "/pizzas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	public Pizza getPizzaById(@PathVariable Integer id) {  
		Pizza pizza = dao.getPizzaById(id); 
		return pizza;
	}
	
	@RequestMapping(value = "/pizzas/{id}/favoris", method = RequestMethod.GET, headers = "Accept=application/json")  
	public List<Users> getUserByIdPizza(@PathVariable Integer id) {  
		List<Users> listOfUsers = dao.getUserByIdPizza(id); 
		return listOfUsers;
	}
	
	@RequestMapping(value = "/pizzas", method = RequestMethod.POST, headers = "Accept=application/json")  
	public List<Pizza> getPizzasByIngredients(@RequestBody List<Ingredients> listeNoire, List<Ingredients> listeBlanche) {  
		List<Pizza> listOfPizzas = dao.getPizzasByIngredients(listeNoire, listeBlanche); 
		return listOfPizzas;
	}
	
	@RequestMapping(value = "/pizzas", method = RequestMethod.POST, headers = "Accept=application/json")  
	public void createPizza(@RequestBody Pizza pizzaToCreate) {  
		dao.createPizza(pizzaToCreate);
	}
	
	@RequestMapping(value = "/pizzas/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")  
	public void updatePizza(@RequestBody Pizza pizza) {  
		dao.createPizza(pizza);  
	}
	
	@RequestMapping(value = "/pizzas/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
	public void deletePizza(@PathVariable("id") int id) {  
		dao.deletePizza(id);    
	}  
	
	
	//******************************************INGREDIENTS**************************************************

	@RequestMapping(value = "/ingredients", method = RequestMethod.GET, headers = "Accept=application/json")  
	public List<Ingredients> getIngredients() {  
		List<Ingredients> listOfIngredients = dao.getIngredients();  
		return listOfIngredients;  
	}
	
	@RequestMapping(value = "/ingredients/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	public List<Ingredients> getIngredientsById(@PathVariable Integer id) {  
		List<Ingredients> listOfIngredients = dao.getIngredientsById(id); 
		return listOfIngredients;
	}
	
	//*********************************************MEMBRES*****************************************************
	
	@RequestMapping(value = "/connexion", method = RequestMethod.POST, headers = "Accept=application/json")  
	public void getPizzasByIngredients(@RequestBody String nom, String mdp) {  
		return dao.connexionUser(nom, mdp);
	}
	
	
	
	
	   
}  

