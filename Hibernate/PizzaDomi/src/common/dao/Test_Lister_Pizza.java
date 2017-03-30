package common.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.StatelessSessionBuilder;
import org.hibernate.TypeHelper;
import org.hibernate.boot.spi.SessionFactoryBuilderFactory;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;

import common.bean.Ingredients;
import common.bean.Pizza;

public class Test_Lister_Pizza {
 
	   
	  public static void main(String [] args) { 
	     
	    DAO dao = new DAO(); 
	    
	    List<Pizza> pizs = dao.getPizzas(); 
	     
	    System.out.println(); 
	    System.out.println("nb Pizzas = "+pizs.size()); 
	     
	    for (Pizza piz : pizs) { 
	      System.out.println("Pizza "+piz.getId()+" nom = "+piz.getNom());
	      for(Ingredients in : piz.getIngredients()){
	    	  System.out.println("- ingredient : "+in.getNom());
	      }
	    } 
	     
	  } 
	   
	
}
