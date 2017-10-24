package org.core;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

import org.jpa.jpa.PersistenceManager;

@ApplicationScoped
public abstract class AbstractBaseService<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

	public void insert(T entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} 
//		catch (Exception e) {
//			em.getTransaction().rollback();
//			em.refresh(entity);
//		} 
		finally {
			// em.close();

		}
	}

	public void update(T entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} finally {
			// em.close();
		}
	}

	public void delete(T entity) {
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} finally {
			// em.close();
		}
	}
}