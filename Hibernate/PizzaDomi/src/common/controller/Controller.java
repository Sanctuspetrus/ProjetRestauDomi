package common.controller;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import common.bean.Ingredients;
import common.bean.Pizza;
import common.bean.Users;
import common.dao.DAO;


@Path ("/controller") 
public class Controller {  


	  
	DAO dao = new DAO();

	//***************************PIZZAS*************************************************************************
	
	@GET
	@Path("/pizzas")
	public Response getPizzas() {  
		System.out.println("bite");
		dao.ouvrir();
		List<Pizza> listOfPizzas = dao.getPizzas();
		String json = "{\"pizzaDomi\":[\n";
		int i = 0;
		for (Pizza piz : listOfPizzas) {
			json += "\t{\n";
			json += "\t\"id\":"+piz.getId()+",\n";
			json += "\t\"nom\":\""+piz.getNom()+"\",\n";
			json += "\t\"favUsers\":[\n";
			int j = 0;
			for (Users usr : piz.getUsers()) {
				json += "\t\t"+usr.getId();
				if(j < piz.getUsers().size()-1){

					json += ",\n";
				}
				else{
					json += "\n";
				}
				j++;
			}
			json += "\t],\n";
			json += "\t\"ings\":[\n";
			j = 0;
			for (Ingredients ing : piz.getIngredients()) {
				json += "\t\t"+ing.getId();
				if(j < piz.getIngredients().size()-1){

					json += ",\n";
				}else{
					json += "\n";
				}
				j++;
			}
			json += "\t]\n";

			json += "}\n";
			if(i < listOfPizzas.size()-1){

				json += ",\n";
			}
			else{
				json += "\n";
			}
			i++;
		}
		json += "]}";
		dao.fermer();
		return Response.ok(json).build();  
	}
	/*
	@RequestMapping(value = "/pizzas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	public Pizza getPizzaById(@PathVariable Integer id) {  
		Pizza pizza = dao.getPizzaById(id); 
		return pizza;
	}
	
	@RequestMapping(value = "/pizzas/{id}/favoris", method = RequestMethod.GET, headers = "Accept=application/json")  
	public Collection<Users> getUserByIdPizza(@PathVariable Integer id) {  
		Collection<Users> listOfUsers = dao.getUserByIdPizza(id); 
		return listOfUsers;
	}
	/*
	@RequestMapping(value = "/pizzas", method = RequestMethod.POST, headers = "Accept=application/json")  
	public List<Pizza> getPizzasByIngredients(@RequestBody List<Ingredients> listeNoire, List<Ingredients> listeBlanche) {  
		List<Pizza> listOfPizzas = dao.getPizzasByIngredients(listeNoire, listeBlanche); 
		return listOfPizzas;
	}
	*/
	@RequestMapping(value = "/pizzas", method = RequestMethod.PUT, headers = "Accept=application/json")  
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
	public Ingredients getIngredientsById(@PathVariable Integer id) {  
		Ingredients ingredient = dao.getIngredientsById(id); 
		return ingredient;
		
	}
	
	//*********************************************MEMBRES*****************************************************
	
	@RequestMapping(value = "/connexion", method = RequestMethod.POST, headers = "Accept=application/json")  
	public String connexionUser(@RequestBody String nom, String mdp) {  
		return dao.connexionUser(nom, mdp);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = "Accept=application/json")  
	public void createUser(@RequestBody String nom, String mdp) {  
		dao.createUser(nom, mdp);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT, headers = "Accept=application/json")  
	public int updateUser(@RequestBody Users user) {  
		return dao.updateUser(user);
	}
	
	@RequestMapping(value = "/compte", method = RequestMethod.GET, headers = "Accept=application/json")  
	public Users getUser(@PathVariable Integer id) {  
		Users user = dao.getUser(id); 
		return user;
	}
	
	@RequestMapping(value = "/user/{id}/favoris", method = RequestMethod.GET, headers = "Accept=application/json")  
	public Collection<Pizza> getUsersFavPizzas(@PathVariable Integer id) {  
		Collection<Pizza> listOfPizzas = dao.getUsersFavPizzas(id); 
		return listOfPizzas;
	}
	
	
	   */
}  

