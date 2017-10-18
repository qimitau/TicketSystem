package org.core;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.jpa.domain.Ticket;

@ApplicationScoped
public interface TicketService extends Serializable {
	public void insert(Ticket ticket);

	public void delete(Long l);
	
	public void delete(Ticket ticket);

	public void update(Ticket ticket);

	public Ticket findById(Long id);

	public List<Ticket> findAll();
}

