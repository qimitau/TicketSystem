package org.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ServiceUnit {
	
	@Id
	private Long id;
	
	@Column(name = "TIMESTAMP_FIELD")
	private java.sql.Timestamp timestampField;
	
	private String text;
	
	@ManyToOne
	private Ticket ticket;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.sql.Timestamp getTimestampField() {
		return timestampField;
	}

	public void setTimestampField(java.sql.Timestamp timestampField) {
		this.timestampField = timestampField;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
}
