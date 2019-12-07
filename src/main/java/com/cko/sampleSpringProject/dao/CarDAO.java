package com.cko.sampleSpringProject.dao;

import com.cko.sampleSpringProject.model.Authority;
import com.cko.sampleSpringProject.model.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarDAO extends CrudRepository<Car, Long> {
    Car findCarById(long id);
    List<Car> findCarsByPriceIsLessThan(int price);
}
