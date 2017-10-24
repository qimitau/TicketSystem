package org.webapp;

public class LoginPage extends BasePage {

	private static final long serialVersionUID = 1L;

	public LoginPage() {
		add(new MySignInPanel("signInPanel", false));
		
	}
}
