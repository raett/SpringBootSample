package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.BookDAO;
import com.cko.sampleSpringProject.dao.ClientOrderDAO;
import com.cko.sampleSpringProject.dao.EmployeesDAO;
import com.cko.sampleSpringProject.model.Book;
import com.cko.sampleSpringProject.model.ClientOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookDAO bookDAO;

    @Autowired
    ClientOrderDAO clientOrderDAO;

    @Autowired
    EmployeesDAO employeesDAO;

    @GetMapping("/allb")
    public ModelAndView showAllBooks(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("books/All");
        modelAndView.addObject("books", bookDAO.findAll());
        return modelAndView;
    }
    @GetMapping("/editstatus")
    public RedirectView showBooks(@RequestParam long id, @RequestParam String statusOrder){
        Book book = bookDAO.findBooksById(id);
        book.setStatusOrder(statusOrder);
        bookDAO.save(book);
        return new RedirectView("/book/allb");
    }
    @GetMapping("/allo")
    public ModelAndView showAllOrders() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders/List");
        modelAndView.addObject("orders", clientOrderDAO.findAll());
        return modelAndView;
    }

    @GetMapping("/orderediting")
    public ModelAndView showEditPage(@RequestParam(name = "order_id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("books/Book");

        List<String> time = Time.giveTimeOrders();
        ClientOrder book = clientOrderDAO.findClientOrderById(id);
        modelAndView.addObject("employee", employeesDAO.findAll());
        modelAndView.addObject("book", book);
        modelAndView.addObject("times", time);

        return modelAndView;
    }

    @GetMapping("/neworder")
    public ModelAndView showAddBookPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("books/BookA");

        List<String> time =  Time.giveTimeOrders();
        modelAndView.addObject("employee", employeesDAO.findAll());
        modelAndView.addObject("times", time);

        return modelAndView;
    }

    @PostMapping("/neworder")
    public RedirectView createBook(Book book){
        bookDAO.save(book);
        return new RedirectView("/book/allo");
    }

    @PostMapping("/add")
    public RedirectView addNewBook(Book book) {
        bookDAO.save(book);
        ClientOrder order = clientOrderDAO.findClientOrderById(book.getNumberOrder());
        clientOrderDAO.delete(order);
        return new RedirectView("/book/allo");
    }

    @GetMapping("/deleteorder")
    public RedirectView showDeletePage(@RequestParam int id) {
        ClientOrder order = clientOrderDAO.findClientOrderById(id);
        clientOrderDAO.delete(order);
        return new RedirectView("/book/allo");
    }



}
