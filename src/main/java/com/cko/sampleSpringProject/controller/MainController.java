package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.CarDAO;
import com.cko.sampleSpringProject.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    CarDAO carDAO;

    @GetMapping("/loginPage")
    public String showLoginPage(){

        return "login";
    }

    @GetMapping("/")
    public String showMainPage(){
        Car car = carDAO.findCarById(5);


        return "mainPage";
    }


}
