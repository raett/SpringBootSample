package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.ClientOrderDAO;
import com.cko.sampleSpringProject.model.ClientOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientOrderController {
    @Autowired
    ClientOrderDAO orderDAO;

    @GetMapping("/order")
    public String showOrderFormPage() {
        return "ClientForm";
    }

    @PostMapping("/order")
    public String addNewOrder(ClientOrder clientOrder) {
        orderDAO.save(clientOrder);
        return "ThanksPage";
    }
}
