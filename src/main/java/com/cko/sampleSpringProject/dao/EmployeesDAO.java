package com.cko.sampleSpringProject.dao;

import com.cko.sampleSpringProject.model.Employe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeesDAO extends CrudRepository<Employe, Long> {
    Employe findEmployeById(long id);
    List<Employe> findAll();
}