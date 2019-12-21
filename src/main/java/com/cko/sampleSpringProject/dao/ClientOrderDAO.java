package com.cko.sampleSpringProject.dao;

import com.cko.sampleSpringProject.model.ClientOrder;
import org.springframework.data.repository.CrudRepository;

public interface ClientOrderDAO extends CrudRepository<ClientOrder, Long> {
}
