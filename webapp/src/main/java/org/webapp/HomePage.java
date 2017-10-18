package org.webapp;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.core.BenutzerService;
import org.core.ServiceUnitService;
import org.core.SimpleService;
import org.core.TicketService;
import org.jpa.domain.Benutzer;
import org.jpa.domain.ServiceUnit;
import org.jpa.domain.Ticket;
import org.apache.wicket.markup.html.basic.Label;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	@Inject SimpleService simpleservice;
	@Inject
	BenutzerService benutzerService;
	@Inject
	TicketService ticketService;
	@Inject
	ServiceUnitService serviceUnitService;
	
	
	public HomePage(final PageParameters parameters) {
		super(parameters);

		//add(new Label("version", simpleservice.getFurz()));


		Benutzer benutzer = benutzerService.findByEmail("system@persis.de");

		List<Ticket> list = ticketService.findAll();
		for (Ticket tick : list) {
			  if(tick.getAdmin().getEmail().equals(benutzer.getEmail())) {

				  add(new Label("subject", tick.getSubject()));
				  break;
				  //System.out.println(tick.getSubject());
			  }
		  }	
		
//		ServiceUnit su = new ServiceUnit();
//		su.setText("Es gibt hier eine ServiceUnit");
//		su.setTicket(ticketService.findById(2L));
//		serviceUnitService.insert(su);
		List<ServiceUnit> list2 = serviceUnitService.findAll();
		for(ServiceUnit su: list2) {
			System.out.println(su.getText());
		}	
		
		ServiceUnit su = serviceUnitService.findById(1L);
		su.setText("Es gibt heir eine ServiceUnit, wie?");
		serviceUnitService.update(su);

    }
}
