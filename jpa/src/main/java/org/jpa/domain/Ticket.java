package org.jpa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ticket implements Serializable {
	
	private static final long serialVersionUID = 1L;

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
	private Benutzer benutzer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Benutzer admin;
	
	@OneToMany(mappedBy = "ticket")
	  private List<ServiceUnit> sevriceUnits  = new ArrayList<ServiceUnit>();

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

	public List<ServiceUnit> getSevriceUnits() {
		return sevriceUnits;
	}

	public void setSevriceUnits(List<ServiceUnit> sevriceUnits) {
		this.sevriceUnits = sevriceUnits;
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
