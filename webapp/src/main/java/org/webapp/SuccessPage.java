package org.webapp;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.jpa.domain.Benutzer;

public class SuccessPage extends BaseAdminPage {
	

	public SuccessPage() {
		super();
		add(new Label("success", "Success!"));
		
		add(new Label("more", "Want to create one more ticket?"));
		
		Form<Void> successForm = new Form<Void>("successForm");
		add(successForm);
		
		Button successButton = new Button("successButton") {

			@Override
			public void onSubmit() {
				setResponsePage(new NewTicketPage());
			}

		};
		successForm.add(successButton);

	}
}
