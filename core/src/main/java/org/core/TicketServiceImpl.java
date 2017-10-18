package org.core;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.jpa.domain.Ticket;

@ApplicationScoped
public class TicketServiceImpl extends AbstractBaseService<Ticket> implements TicketService {

	private static final long serialVersionUID = 1L;

	@Override
	public void insert(Ticket ticket) {
		super.insert(ticket);

	}

	@Override
	public void delete(Ticket ticket) {
		super.delete(ticket);
	}

	public void delete(Long id) {
		Ticket ticket = em.find(Ticket.class, id);
		super.delete(ticket);
	}

	@Override
	public void update(Ticket ticket) {
		super.update(ticket);

	}

	public Ticket findById(Long id) {
		Ticket ticket = em.find(Ticket.class, id);
		return ticket;
	}

	// @SuppressWarnings("unchecked")
	public List<Ticket> findAll() {
		List<Ticket> list;
		try {

			list = em.createQuery("SELECT a FROM Ticket a", Ticket.class).getResultList();
	
		} finally {
		//	em.close();
		}

		return list;

	}

}
