package org.core;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public interface SimpleService extends Serializable  {

	
	
String getFurz();
}
