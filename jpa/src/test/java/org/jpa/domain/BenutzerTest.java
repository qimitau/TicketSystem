package org.jpa.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BenutzerTest {
	private Benutzer benutzer;

	@Before
	public void setUp() {
		benutzer = new Benutzer();
		benutzer.setName("Testuser");
		benutzer.setDepartment("TestDepartment");
	}

	@Test
	public void testBenutzerName() {
		assertEquals("Testuser", benutzer.getName());
	}

	@Test
	public void testBenutzerDepartment() {
		assertEquals("TestDepartment", benutzer.getDepartment());
	}

}
