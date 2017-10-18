package org.jpa.domain;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-10-17T10:48:58.501+0200")
@StaticMetamodel(ServiceUnit.class)
public class ServiceUnit_ {
	public static volatile SingularAttribute<ServiceUnit, Long> id;
	public static volatile SingularAttribute<ServiceUnit, Timestamp> timestampField;
	public static volatile SingularAttribute<ServiceUnit, String> text;
	public static volatile SingularAttribute<ServiceUnit, Ticket> ticket;
}
