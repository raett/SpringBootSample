package com.cko.sampleSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {

    @GetMapping("/cars/add")
    public String showLoginPage(){

        return "CarAdd";
    }
    @GetMapping("/cars/all")
    public ModelAndView showAllCars(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("CarTable");
        return modelAndView;
    }
}
