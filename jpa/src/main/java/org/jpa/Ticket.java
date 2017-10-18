package org.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;


@Entity
public class Ticket {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "TIMESTAMP_FIELD", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private java.sql.Timestamp timestampField;
	
	private String status;
	
	private String subject;
	
	@Column(length = 1024)
	private String text;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="benutzer_id")
	private Benutzer benutzer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="admin_id")
	private Benutzer admin;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	public Benutzer getAdmin() {
		return admin;
	}

	public void setAdmin(Benutzer admin) {
		this.admin = admin;
	}

}
