package org.webapp;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

public class UebersichtPageTest extends WicketTester {
	private WicketTester tester;

	@Before
	public void setUpTest() {
		tester = new WicketTester();
		tester.startPage(UebersichtPage.class);
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
