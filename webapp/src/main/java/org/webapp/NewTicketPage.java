package org.webapp;

import javax.inject.Inject;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.core.BenutzerService;
import org.core.TicketService;
import org.jpa.domain.Benutzer;
import org.jpa.domain.Ticket;

public class NewTicketPage extends BaseAdminPage {

	private static final long serialVersionUID = 1L;
	@Inject
	TicketService ticketService;
	@Inject
	BenutzerService benutzerService;
	private String subject;
	private String details;

	public NewTicketPage() {

		Form<Void> newTicketForm = new Form<Void>("newTicketForm");
		add(newTicketForm);
		newTicketForm.add(new Label("newTicket", "Create new Ticket:"));

		TextField<String> subjectField = new TextField<String>("subject", new PropertyModel<String>(this, "subject"));
		newTicketForm.add(subjectField);
		TextArea<String> detailsField = new TextArea<String>("details", new PropertyModel<String>(this, "details"));
		newTicketForm.add(detailsField);

		Button sendButton = new Button("sendButton") {
			@Override
			public void onSubmit() {
				addNewTicket(subject, details);
			}
		};
		newTicketForm.add(sendButton);

		Button cancelButton = new Button("cancelButton") {
			@Override
			public void onSubmit() {
				cancelButtonRedirect(SignInSession.get().getBenutzer());
			}
		};
		newTicketForm.add(cancelButton);
		
		//debug
		//System.err.println(SignInSession.get().getBenutzer().getName());		
	}

	private void addNewTicket(String subject, String details) {
		if (subject != null && details != null) {
			try {
				Ticket ticket = new Ticket();
				ticket.setStatus("open");
				ticket.setSubject(subject);
				ticket.setText(details);
				ticket.setBenutzer(SignInSession.get().getBenutzer());
				ticket.setAdmin(benutzerService.findById(1L));
				ticketService.insert(ticket);
				setResponsePage(new SuccessPage());

			} catch (Exception e) {
				setResponsePage(new ErrorPage());
			}
		} else {
			setResponsePage(new ErrorPage());
		}
	}

	private void cancelButtonRedirect(Benutzer benutzer) {
		String dep = benutzer.getDepartment();
		if (dep.equals("IT")) {
			setResponsePage(new UebersichtPage());
		} else {
			setResponsePage(new NewTicketPage());
		}
	}
}
