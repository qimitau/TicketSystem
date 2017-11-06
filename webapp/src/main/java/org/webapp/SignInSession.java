package org.webapp;

import javax.inject.Inject;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;
import org.core.BenutzerService;
import org.jpa.domain.Benutzer;

public class SignInSession extends AuthenticatedWebSession {

	private static final long serialVersionUID = 1L;
	@Inject
	BenutzerService benutzerService;
	private Benutzer benutzer;

	protected SignInSession(Request request) {
		super(request);

	}

	@Override
	public final boolean authenticate(final String email, final String password) {
		if (benutzerService.findByEmail(email) != null) {
			Benutzer benutzer = benutzerService.findByEmail(email);
			if (benutzer.getEmail().equalsIgnoreCase(email) && benutzer.getPassword().equalsIgnoreCase(password)) {
				this.benutzer = benutzer;
				return true;
			}
		}
		return false;
	}
	

	@Override
	public Roles getRoles() {
		if (isSignedIn()) {
			// If the user is signed in, they have these roles
			return new Roles(Roles.ADMIN);
		}
		return null;
	}
	public Benutzer getBenutzer() {
		return benutzer;
	}
	
	public static SignInSession get() {
		return (SignInSession) AuthenticatedWebSession.get();
	}
}
