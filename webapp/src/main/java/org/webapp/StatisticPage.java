package org.webapp;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.core.TicketService;
import org.jpa.domain.Ticket;

public class StatisticPage extends BaseAdminPage {
	private static final long serialVersionUID = 1L;
	@Inject
	TicketService ticketService;
	private Ticket selected;

	public StatisticPage() {
		super();
		List<Ticket> tickets = new ArrayList<>();
		List<Ticket> ticketsTemp = ticketService.findAll();
		if (ticketsTemp != null) {
			try {
				for (Ticket ticket : ticketsTemp) {
					if (ticket.getStatus().equalsIgnoreCase("done")) {
						tickets.add(ticket);
					}
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}

		@SuppressWarnings("unchecked")
		DataView ticketsList = new DataView("ticketsList", new ListDataProvider(tickets)) {
			@Override
			protected void populateItem(Item item) {
				item.add(new Label("ticketId", ((Ticket) item.getModelObject()).getId()));
				item.add(new Label("ticketStatus", ((Ticket) item.getModelObject()).getStatus()));
				item.add(new Label("ticketSubject", ((Ticket) item.getModelObject()).getSubject()));
				item.add(new Label("ticketText", ((Ticket) item.getModelObject()).getText()));
				item.add(new Label("ticketTime", ((Ticket) item.getModelObject()).getTimestampField().toString().substring(0, 19)));
				item.add(new Label("ticketAdmin", ((Ticket) item.getModelObject()).getAdmin().getName()));
				item.add(new Label("ticketUser", ((Ticket) item.getModelObject()).getBenutzer().getName()));
			}
		};
		add(ticketsList);
	}
}
