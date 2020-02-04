
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

    @GetMapping("/add")
    public String showLoginPage() {

        return "employers/Add";
    }

    @GetMapping("/edit")
    public ModelAndView showEditPage(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employers/Edit");
        Employe employe = employeesDAO.findEmployeById(id);
        modelAndView.addObject("empls", employe);
        return modelAndView;
    }

    @GetMapping("/delete")
    public RedirectView showDeletePage(@RequestParam int id) {
        Employe employe = employeesDAO.findEmployeById(id);
        employeesDAO.delete(employe);
        return new RedirectView("/empl/list");
    }

    @PostMapping("/edit")
    public RedirectView editEmpl(Employe employe) {
        Employe empl = employeesDAO .findEmployeById(employe.getId());
        employeesDAO.delete(empl);
        employeesDAO.save(employe);
        return new RedirectView("/empl/list");
    }

    @PostMapping("/add")
    public RedirectView addEmpl(Employe employe) {
        employeesDAO.save(employe);
        return new RedirectView("/empl/list");
    }


    @GetMapping("/list")
    public ModelAndView showAllEmpl() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employers/All");
        modelAndView.addObject("empls", employeesDAO.findAll());
        return modelAndView;
    }


}
