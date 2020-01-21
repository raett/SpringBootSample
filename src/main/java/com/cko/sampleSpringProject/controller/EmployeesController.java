
package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.EmployeesDAO;
import com.cko.sampleSpringProject.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/empl")
public class EmployeesController {

    @Autowired
    EmployeesDAO employeesDAO;

    @GetMapping("/addempls")
    public String showLoginPage() {

        return "employers/Add";
    }

    @GetMapping("/editempl")
    public ModelAndView showEditPage(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employers/Edit");
        Employe employe = employeesDAO.findEmployeById(id);
        modelAndView.addObject("empls", employe);
        return modelAndView;
    }

    @GetMapping("/deleteempl")
    public RedirectView showDeletePage(@RequestParam int id) {
        Employe employe = employeesDAO.findEmployeById(id);
        employeesDAO.delete(employe);
        return new RedirectView("/empl/employelist");
    }

    @PostMapping("/editempl")
    public RedirectView editEmpl(Employe employe) {
        employeesDAO.save(employe);
        return new RedirectView("/empl/employelist");
    }

    @PostMapping("/addempls")
    public RedirectView addEmpl(Employe employe) {
        employeesDAO.save(employe);
        return new RedirectView("/empl/employelist");
    }


    @GetMapping("/employelist")
    public ModelAndView showAllEmpl() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employers/All");
        modelAndView.addObject("empls", employeesDAO.findAll());
        return modelAndView;
    }

    @GetMapping("/calendar")
    public ModelAndView showCalendar(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Calendar");
        List<Employe> empls = employeesDAO.findAll();

//        for(int i = 9; i < 21; i++){
//            String time ="";
//
//            time = i + " : 00";
//            times.add(time);
//            time = i + " : 30";
//            times.add(time);
//        }
        modelAndView.addObject("empls", empls);
        return modelAndView;
    }
}
