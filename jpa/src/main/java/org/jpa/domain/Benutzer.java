package org.jpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Benutzer {
	 
	@Id
	@GeneratedValue
	private Long id;
	
	private String name; 
	
	private String department;
	
	private String password;
	
	@Column(unique = true)
	private String email;
	
	
	@OneToMany(mappedBy = "benutzer")
	  private List<Ticket> tickets  = new ArrayList<Ticket>();
	
	@OneToMany(mappedBy = "admin")
	  private List<Ticket> ticketsAdmin  = new ArrayList<Ticket>();


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public List<Ticket> getTicketsAdmin() {
		return ticketsAdmin;
	}

	public void setTicketsAdmin(List<Ticket> ticketsAdmin) {
		this.ticketsAdmin = ticketsAdmin;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

} 
