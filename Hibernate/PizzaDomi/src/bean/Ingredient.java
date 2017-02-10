package bean; 

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table; 

@Entity 
@Table(name = "ingredients") 
public class Ingredient implements Serializable { 

	/** 
	 *  
	 */ 
	private static final long serialVersionUID = 1L; 

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	//@Column(name = "id", nullable = false, insertable = false, updatable = false) 
	private Integer id; 

	private String nom; 

	private Double prix; 

	/**
	 * Table de jointure "recette"
	 */

	@ManyToMany(
			cascade = {CascadeType.PERSIST, CascadeType.MERGE},
			mappedBy = "ingredients",
			targetEntity = Pizza.class
			)
	private Collection <Pizza> pizzas = new ArrayList<Pizza>();

	public Ingredient(){ 

	} 

	public Ingredient(String n){ 
		this.nom = n; 
		this.prix = 0.0; 
	} 

	public Ingredient(String n, double d) { 
		this.nom = n; 
		this.prix = d; 
	} 

	public Integer getId() { 
		return id; 
	} 

	public void setId(Integer id) { 
		this.id = id; 
	} 

	public String getNom() { 
		return nom; 
	} 

	public void setNom(String nom) { 
		this.nom = nom; 
	} 

	public Double getPrix() { 
		return prix; 
	} 

	public void setPrix(Double prix) { 
		this.prix = prix; 
	}

	public Collection<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(Collection<Pizza> pizzas) {
		this.pizzas = pizzas;
	} 

	public void addPizza(Pizza p){
		this.pizzas.add(p);
	}



}