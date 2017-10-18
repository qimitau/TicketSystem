package org.core;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class AbstractBaseService<T> implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	EntityManager em = entityManagerFactory.createEntityManager();

	public void insert(T entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public void update(T entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public void delete(T entity) {
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
