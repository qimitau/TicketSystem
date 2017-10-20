package org.webapp;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class SuccessPage extends BaseAdminPage {

	public SuccessPage() {
		super();
		add(new Label("success", "Success!"));
		
		add(new Label("more", "Want to create one more ticket?"));
		
		add(new BookmarkablePageLink<Object>("newTicketLink", NewTicketPage.class));

	}
}
