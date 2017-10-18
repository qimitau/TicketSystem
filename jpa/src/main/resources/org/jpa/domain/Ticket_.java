package org.jpa.domain;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-10-17T10:06:29.231+0200")
@StaticMetamodel(Ticket.class)
public class Ticket_ {
	public static volatile SingularAttribute<Ticket, Long> id;
	public static volatile SingularAttribute<Ticket, Timestamp> timestampField;
	public static volatile SingularAttribute<Ticket, String> status;
	public static volatile SingularAttribute<Ticket, String> subject;
	public static volatile SingularAttribute<Ticket, String> text;
	public static volatile SingularAttribute<Ticket, Benutzer> benutzer;
	public static volatile SingularAttribute<Ticket, Benutzer> admin;
}
