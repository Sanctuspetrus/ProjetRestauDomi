package bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "pointdeventes") 
public class PointDeVentes implements Serializable {

	/** 
	 *  
	 */ 
	private static final long serialVersionUID = 1L; 

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	//@Column(name = "id", nullable = false, insertable = false, updatable = false) 
	private Integer id; 

	private String adresse; 

	public PointDeVentes(){

	}  

	public PointDeVentes(String adresse) { 
		this.adresse = adresse; 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	} 



}
