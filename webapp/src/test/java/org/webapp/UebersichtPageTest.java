package org.webapp;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.util.tester.WicketTester;
import org.core.TicketService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UebersichtPageTest extends WicketTester {
	private WicketTester tester;
	// @InjectMocks
	UebersichtPage uebersichtPage = new UebersichtPage();

	@Mock
	private TicketService ticketService;

	@Before
	public void setUpTest() {
		Whitebox.setInternalState(uebersichtPage, "ticketService", ticketService);
		tester = new WicketTester();
		tester.startPage(uebersichtPage);
	}

	@Test
	public void rendersPage() {
		tester.assertRenderedPage(UebersichtPage.class);
	}

	@Test
	public void pageHasRefreshButton() {
		tester.assertComponent("refreshForm:refreshButton", Button.class);
	}

	@Test
	public void pageHasLogOutForm() {
		tester.assertComponent("logOutForm", Form.class);
	}

	@Test
	public void pageHasLogOutButton() {
		tester.assertComponent("logOutForm:logOutButton", Button.class);
	}

}
