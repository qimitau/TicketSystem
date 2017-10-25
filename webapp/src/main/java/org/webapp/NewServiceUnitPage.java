package org.webapp;

import org.jpa.domain.Ticket;

public class NewServiceUnitPage extends BaseAdminPage {

	private static final long serialVersionUID = 1L;
	private Ticket ticket;
	
	public NewServiceUnitPage(Ticket ticket) {
		super();
		this.ticket = ticket;
	}

}
