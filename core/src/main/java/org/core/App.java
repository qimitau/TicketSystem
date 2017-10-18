package org.core;

import java.util.List;

import org.jpa.Benutzer;
import org.jpa.Ticket;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		 BenutzerServiceImpl userServiceImpl = new BenutzerServiceImpl();
		 TicketServiceImpl tsi = new TicketServiceImpl();
		// userServiceImpl.delete(4L);

		// Benutzer benutzer = new Benutzer();
		// benutzer.setName("Adams");
		// benutzer.setDepartment("IT");
		// benutzer.setEmail("helena.adam@persis.de");
		// benutzer.setPassword("eins");
		// userServiceImpl.insert(benutzer);
		// userServiceImpl = new UserServiceImpl();
		// benutzer = new Benutzer();
		// benutzer.setName("Frank");
		// benutzer.setDepartment("office");
		// benutzer.setEmail("frank@anne.de");
		// benutzer.setPassword("zwei");
		// userServiceImpl.insert(benutzer);

		// Benutzer b = userServiceImpl.findByEmail("frank@anne.de");
		// System.out.println(b.getName());

//		Ticket ticket = new Ticket();
//		ticket.setAdmin(userServiceImpl.findById(3L));
//		ticket.setBenutzer(userServiceImpl.findByEmail("frank@anne.de"));
//		ticket.setStatus("open");
//		ticket.setSubject("Test 1");
//		ticket.setText("Test ticket nummer eins");
//		tsi.insert(ticket);
//		userServiceImpl = new UserServiceImpl();
//		tsi = new TicketServiceImpl();
//		ticket = new Ticket();
//		ticket.setAdmin(userServiceImpl.findById(3L));
//		ticket.setBenutzer(userServiceImpl.findByEmail("frank@anne.de"));
//		ticket.setStatus("open");
//		ticket.setSubject("Test 1");
//		ticket.setText("Test ticket nummer zwei");
//		tsi.insert(ticket);
//		userServiceImpl = new UserServiceImpl();
//		tsi = new TicketServiceImpl();
//		ticket = new Ticket();
//		ticket.setAdmin(userServiceImpl.findById(3L));
//		ticket.setBenutzer(userServiceImpl.findById(1L));
//		ticket.setStatus("open");
//		ticket.setSubject("Test 1");
//		ticket.setText("Test ticket nummer drei");
//		tsi.insert(ticket);
		Benutzer benutzer = userServiceImpl.findByEmail("system@persis.de");
		
		System.out.println("test");
		
		List<Ticket> list = tsi.findAll();
		  for (Ticket tick : list) {
			  if(tick.getAdmin().equals(benutzer)) {
		      System.out.println(tick.getSubject());
			  }
		  }		

	}
}
