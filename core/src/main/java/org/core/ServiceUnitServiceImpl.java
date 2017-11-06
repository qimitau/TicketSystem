package org.core;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;

import org.jpa.domain.ServiceUnit;

@ApplicationScoped
public class ServiceUnitServiceImpl extends AbstractBaseService<ServiceUnit> implements ServiceUnitService {

	private static final long serialVersionUID = 1L;

	@Override
	public void insert(ServiceUnit serviceUnit) {
		super.insert(serviceUnit);

	}

	@Override
	public void delete(ServiceUnit serviceUnit) {
		super.delete(serviceUnit);
	}

	public void delete(Long id) {
		ServiceUnit serviceUnit = em.find(ServiceUnit.class, id);
		super.delete(serviceUnit);
	}

	@Override
	public void update(ServiceUnit serviceUnit) {
		super.update(serviceUnit);

	}

	public ServiceUnit findById(Long id) {
		try {
			return em.find(ServiceUnit.class, id);
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ServiceUnit> findAll() {
		List<ServiceUnit> list = null;
		try {
			list = em.createQuery("SELECT a FROM ServiceUnit a", ServiceUnit.class).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}