package org.core;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

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
		ServiceUnit serviceUnit = em.find(ServiceUnit.class, id);
		return serviceUnit;
	}

	// @SuppressWarnings("unchecked")
	public List<ServiceUnit> findAll() {
		List<ServiceUnit> list;
		try {

			list = em.createQuery("SELECT a FROM ServiceUnit a", ServiceUnit.class).getResultList();

		} finally {
			// em.close();
		}

		return list;

	}

}