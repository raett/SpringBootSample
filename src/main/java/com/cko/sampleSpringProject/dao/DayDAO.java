package com.cko.sampleSpringProject.dao;

import com.cko.sampleSpringProject.model.Day;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DayDAO extends CrudRepository<Day, Long> {

    Day findDayById(long id);
    List<Day> findAll();

}
