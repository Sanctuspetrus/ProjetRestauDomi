package bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "pate") 
public class Pate implements Serializable {
	
	/** 
	   *  
	   */ 
	  private static final long serialVersionUID = 1L; 
	 
	  @Id
	  @Column(name = "id", nullable = false, insertable = false, updatable = false) 
	  @GeneratedValue(strategy=GenerationType.IDENTITY) 
	  private Integer id; 
	  
	  @Column(name = "nom")
	  private String nom; 
	  
	  @Column(name = "prix")
	  private Double prix; 
	  
	  public Pate(){
		  
	  }
	  
	  public Pate(String n){ 
	    this.nom = n; 
	    this.prix = 0.0; 
	  } 
	   
	  public Pate(String n, double d) { 
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
}





