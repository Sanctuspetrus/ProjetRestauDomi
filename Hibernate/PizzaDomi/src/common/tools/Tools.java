package common.tools;

import java.util.List;

import common.bean.Ingredients;
import common.bean.Pizza;
import common.bean.Users;

public abstract class Tools {

	
	public static String lstPizzToJson(List<Pizza> lstPizz) {
		String json = "{\"pizzaDomi\":[\n";
		int i = 0;
		for (Pizza piz : lstPizz) {
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
			if(i < lstPizz.size()-1){

				json += ",\n";
			}
			else{
				json += "\n";
			}
			i++;
		}
		json += "]}";
		return json;
	}
	
	public static String listIngToJson(List<Ingredients> lstIng) {
		String json = "{\"pizzaDomi\":[\n";
		int i = 0;
		for (Ingredients ing : lstIng) {
			json += "\t{\n";
			json += "\t\"id\":"+ing.getId()+",\n";
			json += "\t\"nom\":\""+ing.getNom()+"\",\n";
			json += "\t\"prix\":\""+ing.getPrix()+"\",\n";
			json += "\t\"pizza\":[\n";
			int j = 0;
			for (Pizza piz : ing.getPizzas()) {
				json += "\t\t"+piz.getId();
				if(j < ing.getPizzas().size()-1){

					json += ",\n";
				}
				else{
					json += "\n";
				}
				j++;
			}
			json += "\t]\n";

			json += "}\n";
			if(i < lstIng.size()-1){

				json += ",\n";
			}
			else{
				json += "\n";
			}
			i++;
		}
		json += "]}";
		
		return json;
	}
}
