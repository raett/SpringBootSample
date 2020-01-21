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
    private List fiveWorkDays(){
        List<String> day = new ArrayList<>();

        LocalDate today = LocalDate.now();
        while (day.size() < 5) {
            today = today.plusDays(1);
            int dayOfweek = today.getDayOfWeek().getValue();
            if (dayOfweek!= 6 && dayOfweek != 7) {
                String thisDay = today.toString();
                day.add(thisDay);
            }
        };
        return day;
    }

    @GetMapping("/order")
    public ModelAndView howOrderFormPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ClientForm");
        modelAndView.addObject("workingDays",fiveWorkDays());
        return modelAndView;
    }

    @PostMapping("/order")
    public String addNewOrder(ClientOrder clientOrder) {
        orderDAO.save(clientOrder);
        return "ThanksPage";
    }
}
