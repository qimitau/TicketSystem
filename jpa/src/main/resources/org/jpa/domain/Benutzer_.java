package org.jpa.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-10-17T10:04:54.086+0200")
@StaticMetamodel(Benutzer.class)
public class Benutzer_ {
	public static volatile SingularAttribute<Benutzer, Long> id;
	public static volatile SingularAttribute<Benutzer, String> name;
	public static volatile SingularAttribute<Benutzer, String> department;
	public static volatile SingularAttribute<Benutzer, String> password;
	public static volatile SingularAttribute<Benutzer, String> email;
}
