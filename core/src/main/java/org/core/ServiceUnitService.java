package org.core;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.jpa.domain.ServiceUnit;


@ApplicationScoped
public interface ServiceUnitService extends Serializable {
	public void insert(ServiceUnit serviceUnit);

	public void delete(ServiceUnit serviceUnit);
	
	public void delete(Long id);

	public void update(ServiceUnit serviceUnit);

	public ServiceUnit findById(Long id);

	public List<ServiceUnit> findAll();
}