package org.core;

import javax.persistence.Query;

import org.jpa.Benutzer;

public class UserServiceImpl extends AbstractBaseService<Benutzer> implements UserService {

	private static final long serialVersionUID = 1L;

	@Override
	public void insert(Benutzer benutzer) {
		try {
			em.getTransaction().begin();
			em.persist(benutzer);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	@Override
	public Benutzer findById(Long id) {
		Benutzer benutzer = em.find(Benutzer.class, id);
		return benutzer;
	}

	@Override
	public Benutzer findByEmail(String email) {
		Benutzer user = null;
		try {
			Query query = em.createQuery("SELECT u FROM Benutzer u WHERE u.email = :email");
			query.setParameter("email", email);
			user = (Benutzer) query.getSingleResult();
		} finally {
			em.close();
		}
		return user;
	}

	@Override
	public void delete(Benutzer entity) {
		super.delete(entity);
	}

	public void delete(Long id) {
		Benutzer benutzer = em.find(Benutzer.class, id);
		super.delete(benutzer);
	}

}
