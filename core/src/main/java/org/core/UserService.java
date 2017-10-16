package org.core;

import java.io.Serializable;

import org.jpa.Benutzer;

public interface UserService extends Serializable {
	
	public void insert(Benutzer benutzer);
	
	public void delete(Benutzer benutzer);
	
	public void update(Benutzer benutzer);
	
	public Benutzer findById(Long id);
	
	public Benutzer findByEmail(String email);
}
