package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.EmployeesDAO;
import com.cko.sampleSpringProject.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CalendarController {


    @Autowired
    EmployeesDAO employeesDAO;

//    public List times(){
//        List<String> times = new ArrayList<>();
//        for(int i = 9; i < 22; i++){
//            String time = i + " : 00";
//            times.add(time);
//            time = i + " : 30";
//            times.add(time);
//        }
//        return times;
//    }

    @GetMapping("/calendar")
    public ModelAndView showCalendar(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders/Calendar");
        List<Employe> empls = employeesDAO.findAll();
        List<String> time = Time.giveTimeOrders();
        modelAndView.addObject("times", time);
        modelAndView.addObject("empls", empls);
        return modelAndView;
    }
}
