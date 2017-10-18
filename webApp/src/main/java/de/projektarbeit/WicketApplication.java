package de.projektarbeit;

import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.wicket.cdi.CdiConfiguration;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see de.projektarbeit.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
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
	}
}
