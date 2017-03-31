package common.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import common.bean.Ingredients;
import common.bean.Pizza;
import common.bean.Users;
import common.dao.DAO;
import common.tools.Tools;


@Path ("/controller") 
public class Controller {  


	  
	DAO dao = new DAO();

	//***************************PIZZAS*************************************************************************
	
	@GET
	@Path("/pizzas")
	public Response getPizzas() {  
		dao.ouvrir();
		List<Pizza> listOfPizzas = dao.getPizzas();
		String res = Tools.lstPizzToJson(listOfPizzas);
		dao.fermer();
		return Response.ok(res).build();  
	}
	
	@GET
	@Path("/pizzas/{id}")
	public Response getPizzaById(@PathParam("id") Integer id) {  
		dao.ouvrir();
		Pizza pizza = dao.getPizzaById(id);
		String res = "l'id donné ne correspond à aucune pizza";
		if(pizza != null){
			res = Tools.pizToJSON(pizza);
		}else{
			dao.fermer();
			return Response.serverError().build();
		}
		dao.fermer();
		return Response.ok(res).build(); 
	}

	@GET
	@Path("/pizzas/{id}/favoris")
	public Response getUserByIdPizza(@PathParam("id") Integer id) {  
		dao.ouvrir();
		List<Users> listOfUsers = (List<Users>) dao.getUserByIdPizza(id); 

		String res = "l'id donné ne correspond à aucune pizza";
		if(listOfUsers != null){
			res = Tools.lstUserToJSON(listOfUsers);
		}else{
			dao.fermer();
			return Response.serverError().build();
		}
		dao.fermer();
		return Response.ok(res).build();
	}

	/*
	@RequestMapping(value = "/pizzas", method = RequestMethod.POST, headers = "Accept=application/json")  
	public List<Pizza> getPizzasByIngredients(@RequestBody List<Ingredients> listeNoire, List<Ingredients> listeBlanche) {  
		List<Pizza> listOfPizzas = dao.getPizzasByIngredients(listeNoire, listeBlanche); 
		return listOfPizzas;
	}
	
	@RequestMapping(value = "/pizzas", method = RequestMethod.PUT, headers = "Accept=application/json")  
	public void createPizza(@RequestBody Pizza pizzaToCreate) {  
		dao.createPizza(pizzaToCreate);
	}
	
	@RequestMapping(value = "/pizzas/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")  
	public void updatePizza(@RequestBody Pizza pizza) {  
		dao.createPizza(pizza);  
	}
	
	*/
	@DELETE
	@Path("/pizzas/{id}") 
	public Response deletePizza(@PathParam("id") int id) {  
		dao.ouvrir();
		dao.deletePizza(id);    
		dao.fermer();
		return Response.ok().build();
	}  

	//******************************************INGREDIENTS**************************************************

	@GET
	@Path("/ingredients")  
	public Response getIngredients() {  
		dao.ouvrir();
		List<Ingredients> listOfIngredients = dao.getIngredients();  
		String res = Tools.listIngToJson(listOfIngredients);
		dao.fermer();
		return Response.ok(res).build();  
	}
	
	@GET
	@Path("/ingredients/{id}")  
	public Response getIngredientsById(@PathParam("id") Integer id) {  
		dao.ouvrir();
		Ingredients ingredient = dao.getIngredientsById(id); 

		String res = "l'id donné ne correspond à aucune pizza";
		if(ingredient != null){
			res = Tools.IngToJson(ingredient);
		}else{
			dao.fermer();
			return Response.serverError().build();
		}
		dao.fermer();
		return Response.ok(res).build();
		
	}
	/*
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
	
	   */
	@GET
	@Path("/compte/{id}")  
	public Response getUser(@PathParam("id") Integer id) {  
		dao.ouvrir();
		Users user = dao.getUser(id); 

		String res = "l'id donné ne correspond à aucune pizza";
		if(user != null){ 
			res = Tools.UsrToJson(user);
		}else{
			dao.fermer();
			return Response.serverError().build();
		}
		dao.fermer();
		return Response.ok(res).build();
	}
	

	@GET
	@Path("/user/{id}/favoris")
	public Response getUsersFavPizzas(@PathParam("id") Integer id) {  
		dao.ouvrir();
		List<Pizza> listOfPizzas = (List<Pizza>) dao.getUsersFavPizzas(id); 

		String res = "l'id donné ne correspond à aucun utilisateur";
		if(listOfPizzas != null){
			res = Tools.lstPizzToJson(listOfPizzas);
		}else{
			dao.fermer();
			return Response.serverError().build();
		}
		dao.fermer();
		return Response.ok(res).build();
	}
}  

