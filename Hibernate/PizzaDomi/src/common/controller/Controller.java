package common.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import common.bean.Ingredients;
import common.bean.Pizza;
import common.bean.Users;
import common.service.PizzaService;


@RestController ("controller") 
public class Controller {  

	@Autowired  
	PizzaService service;

	//***************************PIZZAS*************************************************************************
	
	@RequestMapping(value = "/pizzas", method = RequestMethod.GET, headers = "Accept=application/json")  
	public List<Pizza> getPizzas() {  
		List<Pizza> listOfPizzas = service.getPizzas();  
		return listOfPizzas;  
	}

	@RequestMapping(value = "/pizzas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	public Pizza getPizzaById(@PathVariable Integer id) {  
		Pizza pizza = service.getPizzaById(id); 
		return pizza;
	}
	
	@RequestMapping(value = "/pizzas/{id}/favoris", method = RequestMethod.GET, headers = "Accept=application/json")  
	public Collection<Users> getUserByIdPizza(@PathVariable Integer id) {  
		Collection<Users> listOfUsers = service.getUserByIdPizza(id); 
		return listOfUsers;
	}
	
	@RequestMapping(value = "/pizzas", method = RequestMethod.POST, headers = "Accept=application/json")  
	public List<Pizza> getPizzasByIngredients(@RequestBody List<Ingredients> listeNoire, List<Ingredients> listeBlanche) {  
		List<Pizza> listOfPizzas = service.getPizzasByIngredients(listeNoire, listeBlanche); 
		return listOfPizzas;
	}
	
	@RequestMapping(value = "/pizzas", method = RequestMethod.PUT, headers = "Accept=application/json")  
	public void createPizza(@RequestBody Pizza pizzaToCreate) {  
		service.createPizza(pizzaToCreate);
	}
	
	@RequestMapping(value = "/pizzas/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")  
	public void updatePizza(@RequestBody Pizza pizza) {  
		service.createPizza(pizza);  
	}
	
	@RequestMapping(value = "/pizzas/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
	public void deletePizza(@PathVariable("id") int id) {  
		service.deletePizza(id);    
	}  
	
	
	//******************************************INGREDIENTS**************************************************

	@RequestMapping(value = "/ingredients", method = RequestMethod.GET, headers = "Accept=application/json")  
	public List<Ingredients> getIngredients() {  
		List<Ingredients> listOfIngredients = service.getIngredients();  
		return listOfIngredients;  
	}
	
	@RequestMapping(value = "/ingredients/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	public Ingredients getIngredientsById(@PathVariable Integer id) {  
		Ingredients ingredient = service.getIngredientsById(id); 
		return ingredient;
		
	}
	
	//*********************************************MEMBRES*****************************************************
	
	@RequestMapping(value = "/connexion", method = RequestMethod.POST, headers = "Accept=application/json")  
	public String connexionUser(@RequestBody String nom, String mdp) {  
		return service.connexionUser(nom, mdp);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = "Accept=application/json")  
	public void createUser(@RequestBody String nom, String mdp) {  
		service.createUser(nom, mdp);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT, headers = "Accept=application/json")  
	public int updateUser(@RequestBody Users user) {  
		return service.updateUser(user);
	}
	
	@RequestMapping(value = "/compte", method = RequestMethod.GET, headers = "Accept=application/json")  
	public Users getUser(@PathVariable Integer id) {  
		Users user = service.getUser(id); 
		return user;
	}
	
	@RequestMapping(value = "/user/{id}/favoris", method = RequestMethod.GET, headers = "Accept=application/json")  
	public Collection<Pizza> getUsersFavPizzas(@PathVariable Integer id) {  
		Collection<Pizza> listOfPizzas = service.getUsersFavPizzas(id); 
		return listOfPizzas;
	}
	
	
	   
}  

