
package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.CarDAO;
import com.cko.sampleSpringProject.dao.EmployeesDAO;
import com.cko.sampleSpringProject.model.Car;
import com.cko.sampleSpringProject.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/emlp")
public class EmployeesController {
    @Autowired
    EmployeesDAO employeesDAO;

    @GetMapping("/addempls")
    public String showLoginPage(){

        return "CarAdd";
    }

    @GetMapping("/editempl")
    public ModelAndView showEditPage(@RequestParam long id){
        ModelAndView modelAndView = new ModelAndView();modelAndView.setViewName("CarEdit");
        Employe employe = employeesDAO.findEmployeById(id);
        modelAndView.addObject("empls", employe);
        return modelAndView;
    }

    @GetMapping("/deleteempl")
    public RedirectView showDeletePage(@RequestParam int id){
        Employe employe = employeesDAO.findEmployeById(id);
        employeesDAO.delete(employe);
        return new RedirectView("/employelist");
    }

    @PostMapping("/editempl")
    public RedirectView editEmpl (Employe employe){
        employeesDAO.save(employe);
        return new RedirectView("//employelist");
    }

    @PostMapping("/addempls")
    public RedirectView addEmpl (Employe employe){
        employeesDAO.save(employe);
        return new RedirectView("/employelist");
    }


    @GetMapping("/employelist")
    public ModelAndView showAllEmpl(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ListOfEmployees");
        modelAndView.addObject("empls", employeesDAO.findAll());
        return modelAndView;
    }

}
