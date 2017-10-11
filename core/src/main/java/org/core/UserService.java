package org.core;

import java.io.Serializable;

import org.jpa.Benutzer;

public interface UserService extends Serializable {
	
	void insertUser(Benutzer benutzer);
}
