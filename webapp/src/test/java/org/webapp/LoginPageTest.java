package org.webapp;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

public class LoginPageTest extends WicketTester {
	private WicketTester tester;

	@Before
	public void setUpTest() {
		tester = new WicketTester();
		tester.startPage(LoginPage.class);
	}

	@Test
	public void rendersPage() {
		tester.assertRenderedPage(LoginPage.class);
	}

	@Test
	public void pageHasMySignInPanel() {
		tester.assertComponent("signInPanel", MySignInPanel.class);
	}
}
