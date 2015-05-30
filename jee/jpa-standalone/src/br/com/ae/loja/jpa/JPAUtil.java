package br.com.ae.loja.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
	
	public EntityManager createEntityManager() 
	{
		return factory.createEntityManager();
	} 
	
}
