package org.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ServiceUnit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "TIMESTAMP_FIELD", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private java.sql.Timestamp timestampField;
	
	@Column(length = 1024)
	private String text;
	
	@ManyToOne(fetch=FetchType.LAZY)
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
