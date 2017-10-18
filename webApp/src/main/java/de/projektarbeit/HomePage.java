package de.projektarbeit;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.core.BenutzerService;
import org.core.TicketService;
import org.jpa.Benutzer;
import org.jpa.Ticket;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TicketService ticketService;
	
	@Inject
	private BenutzerService benutzerService;
	
	

	public HomePage(final PageParameters parameters) {
		super(parameters);

		//add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		// TODO Add your page's components here
		Benutzer benutzer = benutzerService.findByEmail("system@persis.de");
		
		List<Ticket> list = ticketService.findAll();
		  for (Ticket tick : list) {
			  if(tick.getAdmin().equals(benutzer)) {
				  add(new Label("subject", tick.getSubject()));
			  }
		  }	

    }
}
