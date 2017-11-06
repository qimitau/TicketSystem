package org.webapp;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.jpa.domain.Benutzer;

public class ErrorPage extends BaseAdminPage {
	private static final long serialVersionUID = 1L;

	public ErrorPage() {
		super();
		add(new Label("error", "Ikr!"));

		add(new Label("more", "Something going wrong here!"));

		Form<Void> errorForm = new Form<Void>("errorForm");
		add(errorForm);

		Button errorButton = new Button("errorButton") {

			@Override
			public void onSubmit() {
				addNewTicket();
			}
		};
		errorForm.add(errorButton);
	}

	private void addNewTicket() {
		setResponsePage(new NewTicketPage());
	}

}
