package com.cko.sampleSpringProject.controller.restcotrolle;

import com.cko.sampleSpringProject.dao.CarDAO;
import com.cko.sampleSpringProject.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarRestController {
    @Autowired
    CarDAO carDAO;

    @GetMapping("/get")
    public List getAllCar (){
        List<Car> cars = carDAO.findAll();
        return cars;
    }
    @GetMapping("/get/{id}")
    public Car getCarByID(@PathVariable long id){
        return carDAO.findCarById(id);
    }
}
