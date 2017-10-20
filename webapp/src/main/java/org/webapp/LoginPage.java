package org.webapp;

import javax.inject.Inject;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.core.BenutzerService;
import org.jpa.domain.Benutzer;

public class LoginPage extends BasePage {
	@Inject
	BenutzerService benutzerService;
	private String email;
	private String password;

	public LoginPage() {
		Form<Void> loginForm = new Form<Void>("loginForm");
		add(loginForm);

		TextField<String> emailField = new TextField<String>("email", new PropertyModel<String>(this, "email"));
		loginForm.add(emailField);

		PasswordTextField passwordField = new PasswordTextField("password",
				new PropertyModel<String>(this, "password"));
		loginForm.add(passwordField);

		Button okButton = new Button("okButton") {

			@Override
			public void onSubmit() {
				try {
					Benutzer benutzer = benutzerService.findByEmail(email);
					if (benutzer != null) {
						System.out.println(benutzer.getName());
						String pass = benutzer.getPassword();
						if (pass.equals(password)) {
							System.out.println(password);

							String department = benutzer.getDepartment();
							if (department.equals("IT")) {
								UebersichtPage uebersichtPage = new UebersichtPage();
								setResponsePage(uebersichtPage);
							} else {
								NewTicketPage newTicketPage = new NewTicketPage(benutzer);
								setResponsePage(newTicketPage);
							}
						} else {
							new LoginPage();
						}
					}
				} catch (Exception e) {
					new LoginPage();

				}
			}

		};
		loginForm.add(okButton);
	}
}
