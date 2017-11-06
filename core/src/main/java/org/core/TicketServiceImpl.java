package org.core;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

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
		try {
			return em.find(Ticket.class, id);

		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Ticket> findAll() {
		List<Ticket> list = null;
		try {

			list = em.createQuery("SELECT a FROM Ticket a", Ticket.class).getResultList();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}
	}
}
