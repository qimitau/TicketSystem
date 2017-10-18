package org.core;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SimpleServiceImpl implements SimpleService{

	private static final long serialVersionUID = 1L;

	public String getFurz() {
		return "HALLLO PUPU";
	}

	public SimpleServiceImpl() {
		// TODO Auto-generated constructor stub
	}
}
