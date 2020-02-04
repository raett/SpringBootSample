package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.BookDAO;
import com.cko.sampleSpringProject.dao.ClientOrderDAO;
import com.cko.sampleSpringProject.dao.DayDAO;
import com.cko.sampleSpringProject.model.ClientOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ClientOrderController {
    @Autowired
    ClientOrderDAO orderDAO;

    @Autowired
    DayDAO dayDAO;

    @Autowired
    BookDAO bookDAO;


    @GetMapping("/order")
    public ModelAndView howOrderFormPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ClientsPages/ClientForm");
        modelAndView.addObject("workingDays",Time.giveFiveWorkingDays());
        return modelAndView;
    }

    @PostMapping("/order")
    public String addNewOrder(ClientOrder clientOrder) {
        orderDAO.save(clientOrder);
        return "ClientsPages/ThanksPage";
    }
}
