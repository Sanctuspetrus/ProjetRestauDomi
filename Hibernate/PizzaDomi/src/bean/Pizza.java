package bean; 
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

 
@Entity 
@Table(name = "pizza") 
public class Pizza implements Serializable { 
 
  /** 
   *  
   */ 
  private static final long serialVersionUID = 1L; 
 
  @Id 
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  
  private String nom;
  
	@ManyToMany(targetEntity=Ingredients.class,
		    cascade={CascadeType.PERSIST, CascadeType.MERGE}
		)
	@JoinTable(
		    name="recettes",
		    joinColumns=@JoinColumn(name="idPizza"),
		    inverseJoinColumns=@JoinColumn(name="idIngredients")
		)
	private Collection<Ingredients> ingredients = new ArrayList<Ingredients>();
  
  public Pizza(){ 
	     
  } 
   
  public Pizza(String n){ 
    this.nom = n; 
 
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
}
  