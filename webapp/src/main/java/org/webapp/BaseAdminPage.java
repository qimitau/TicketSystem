package org.webapp;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;

public abstract class BaseAdminPage extends WebPage {

	public BaseAdminPage() {
		super();
		
		Form<Void> logOutForm = new Form<Void>("logOutForm");
		add(logOutForm);
		Button logOutButton = new Button("logOutButton") {

			@Override
			public void onSubmit() {
				setResponsePage(new LoginPage());
			}

		};
		logOutForm.add(logOutButton);
	}

}
