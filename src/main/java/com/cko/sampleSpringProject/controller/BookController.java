package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.BookDAO;
import com.cko.sampleSpringProject.dao.ClientOrderDAO;
import com.cko.sampleSpringProject.dao.EmployeesDAO;
import com.cko.sampleSpringProject.model.Book;
import com.cko.sampleSpringProject.model.ClientOrder;
import com.cko.sampleSpringProject.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    BookDAO bookDAO;

    @Autowired
    ClientOrderDAO clientOrderDAO;

    @Autowired
    EmployeesDAO employeesDAO;

    @GetMapping("/allorders")
    public ModelAndView showAllOrders() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ListOrder");
        modelAndView.addObject("orders", clientOrderDAO.findAll());
        return modelAndView;
    }

    @GetMapping("/orderediting")
    public ModelAndView showEditPage(@RequestParam(name = "order_id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Book");
        List<String> times = new ArrayList<>();
        for (int i = 9; i < 21; i++) {
            String time = "";

            time = i + " : 00";
            times.add(time);
            time = i + " : 30";
            times.add(time);
        }

        ClientOrder book = clientOrderDAO.findClientOrderById(id);
        modelAndView.addObject("employee", employeesDAO.findAll());
        modelAndView.addObject("book", book);
        modelAndView.addObject("times", times);

        return modelAndView;
    }

    @GetMapping("/neworder")
    public String addNewBook() {
        return "";
    }

    @PostMapping("/addorder")
    public RedirectView addNewBook(Book book) {
        bookDAO.save(book);
        ClientOrder order = clientOrderDAO.findClientOrderById(book.getNumberOrder());
        clientOrderDAO.delete(order);
        return new RedirectView("/allorders");
    }

    @GetMapping("/deleteorder")
    public RedirectView showDeletePage(@RequestParam int id) {
        ClientOrder order = clientOrderDAO.findClientOrderById(id);
        clientOrderDAO.delete(order);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/allorders");
        return new RedirectView("/allorders");
    }

}
