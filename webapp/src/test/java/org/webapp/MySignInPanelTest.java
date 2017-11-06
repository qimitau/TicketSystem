package org.webapp;

import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.webapp.MySignInPanel.MySignInForm;

public class MySignInPanelTest extends WicketTester {
	private WicketTester tester;

	@Before
	public void setUpTest() {
		tester = new WicketTester();
		tester.startComponentInPage(new MySignInPanel("test", true));
	}

	@Test
	public void rendersSignInPanel() {
		tester.assertComponent("test", MySignInPanel.class);
	}

	@Test
	public void signInPanelHasFeedbackPanel() {
		tester.assertComponent("test:feedback", FeedbackPanel.class);
	}

	@Test
	public void signInPanelHasSignInForm() {
		tester.assertComponent("test:signInForm", MySignInForm.class);
	}

	@Test
	public void signInFormHasUsername() {
		tester.assertComponent("test:signInForm:username", TextField.class);
	}

	@Test
	public void signInFormHasPassword() {
		tester.assertComponent("test:signInForm:password", PasswordTextField.class);
	}
}
