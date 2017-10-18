package org.core;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.jpa.Benutzer;

@ApplicationScoped
public interface BenutzerService extends Serializable {
	
	public void insert(Benutzer benutzer);
	
	public void delete(Benutzer benutzer);
	
	public void update(Benutzer benutzer);
	
	public Benutzer findById(Long id);
	
	public Benutzer findByEmail(String email);
}
