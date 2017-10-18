package org.core;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;

import org.jpa.Benutzer;

@ApplicationScoped
public class BenutzerServiceImpl extends AbstractBaseService<Benutzer> implements BenutzerService {

	private static final long serialVersionUID = 1L;

	@Override
	public void insert(Benutzer benutzer) {
		super.insert(benutzer);
	}

	@Override
	public Benutzer findById(Long id) {
		Benutzer benutzer = em.find(Benutzer.class, id);
		return benutzer;
	}

	@Override
	public Benutzer findByEmail(String email) {
		Benutzer benutzer = null;
		try {
			Query query = em.createQuery("SELECT u FROM Benutzer u WHERE u.email = :email");
			query.setParameter("email", email);
			benutzer = (Benutzer) query.getSingleResult();
		} finally {
			em.close();
		}
		return benutzer;
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
