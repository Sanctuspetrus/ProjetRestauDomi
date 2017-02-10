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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "user") 
public class User implements Serializable {

	/** 
	 *  
	 */ 
	private static final long serialVersionUID = 1L; 

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 

	private Integer id;

	private String nom;

	private String motDePasse; 

	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}
			)
	@JoinTable(
			name="favoris",
			joinColumns=@JoinColumn(name="idUser", insertable=false, updatable=false),
			inverseJoinColumns=@JoinColumn(name="idPizza", insertable=false, updatable=false)
			)
	private Collection<Pizza> favoris = new ArrayList<Pizza>();



	public User(){

	}

	public User(Integer id, String nom, String pwd) { 
		this.id = id;
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