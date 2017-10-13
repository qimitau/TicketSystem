package org.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.Benutzer;

public class UserServiceImpl extends AbstractBaseService<Benutzer> implements UserService  {

	private static final long serialVersionUID = 1L;
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "jpa" );
	EntityManager em = entityManagerFactory.createEntityManager();

	@Override
	public void insertUser(Benutzer benutzer) {
		try {
		em.getTransaction().begin();
		em.persist(benutzer);
		em.getTransaction().commit();
		}
		finally {
		em.close();
//		System.out.println("blup");
		}

	}

}
