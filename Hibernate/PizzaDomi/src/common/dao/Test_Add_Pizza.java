package common.dao;

import javax.persistence.EntityTransaction;

import common.bean.Pizza;

public class Test_Add_Pizza {


	public static void main(String [] args) { 
	     
		DAO dao = new DAO(); 
		dao.ouvrir(); 
		     
		EntityTransaction tx = dao.em.getTransaction(); 
		tx.begin(); 
		     
		Pizza piz = new Pizza("ladalaise"); 
		
		piz.setIngredients(dao.getIngredients()); 
		
		
		dao.createPizza(piz); 
		
		
		 
		tx.commit(); 
		 
		dao.em.refresh(piz); 
		 
		System.out.println("id = "+piz.getId()); 
		     
		     
		dao.fermer(); 
	} 
}