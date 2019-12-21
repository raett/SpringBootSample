package com.cko.sampleSpringProject.dao;

import com.cko.sampleSpringProject.model.Day;
import org.springframework.data.repository.CrudRepository;

public interface DayDAO extends CrudRepository<Day, Long> {

}
