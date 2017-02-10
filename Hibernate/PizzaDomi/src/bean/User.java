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
	//@Column(name = "id", nullable = false, insertable = false, updatable = false) 
	private String id; 

	private String motDePasse; 

	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}
			)
	@JoinTable(
			name="favoris",
			joinColumns=@JoinColumn(name="idUser", insertable=false, updatable=false),
			inverseJoinColumns=@JoinColumn(name="idPizza", insertable=false, updatable=false)
			)
	private Collection<Pizza> pizzas = new ArrayList<Pizza>();



	public User(){

	}

	public User(String id, String pwd) { 
		this.id = id; 
		this.motDePasse = pwd; 
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 


}