package common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "users") 
public class Users implements Serializable {

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

	@Column(name = "motDePasse")
	private String motDePasse; 
	
	/**
	 * Table de jointure "favoris"
	 */

	@ManyToMany(targetEntity=Pizza.class,
			cascade={CascadeType.PERSIST, CascadeType.MERGE}
			)
	@JoinTable(
			name="favoris",
			joinColumns=@JoinColumn(name="idUser"),
			inverseJoinColumns=@JoinColumn(name="idPizza")
			)
	private Collection<Pizza> favoris = new ArrayList<Pizza>();



	public Users(){

	}

	public Users(String nom, String pwd) { 
		this.nom = nom;
		this.motDePasse = pwd; 
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

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Collection<Pizza> getFavoris() {
		return favoris;
	}

	public void setFavoris(Collection<Pizza> favoris) {
		this.favoris = favoris;
	}

	public void addFavoris(Pizza maPizza){
		this.favoris.add(maPizza);
	}




}