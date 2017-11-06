package org.webapp;

import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.Session;
import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.cdi.CdiConfiguration;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.component.IRequestableComponent;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see org.webapp.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return LoginPage.class;
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new SignInSession(request);
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();

		BeanManager bm;
		try {
			bm = (BeanManager) new InitialContext().lookup("java:comp/BeanManager");
		} catch (NamingException e) {
			throw new IllegalStateException("Unable to obtain CDI BeanManager", e);
		}

		// configure wicket/cdi
		new CdiConfiguration(bm).configure(this);
		// add your configuration here

		// Register the authorization strategy
		getSecuritySettings().setAuthorizationStrategy(new IAuthorizationStrategy.AllowAllAuthorizationStrategy() {
			@Override
			public <T extends IRequestableComponent> boolean isInstantiationAuthorized(Class<T> componentClass) {
				// Check if the new Page requires authentication (implements the marker
				// interface)
				if (AuthenticatedWebPage.class.isAssignableFrom(componentClass)) {
					// Is user signed in?
					if (((SignInSession) Session.get()).isSignedIn()) {
						// okay to proceed
						return true;
					}

					// Intercept the request, but remember the target for later.
					// Invoke Component.continueToOriginalDestination() after successful logon to
					// continue with the target remembered.
					throw new RestartResponseAtInterceptPageException(LoginPage.class);
				}

				// okay to proceed
				return true;
			}
		});
	}
}
