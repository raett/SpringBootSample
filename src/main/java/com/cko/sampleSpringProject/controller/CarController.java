package com.cko.sampleSpringProject.controller;

        import com.cko.sampleSpringProject.dao.CarDAO;
        import com.cko.sampleSpringProject.model.Car;
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
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarDAO carDAO;

    @GetMapping("/add")
    public String showLoginPage(){

        return "CarAdd";
    }

    @GetMapping("/edit")
    public ModelAndView showEditPage(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView();modelAndView.setViewName("CarEdit");
        Car car = carDAO.findCarById(id);
        modelAndView.addObject("car", car);
        return modelAndView;
    }

    @GetMapping("/delete")
    public RedirectView showeletePage(@RequestParam int id){
        Car car = carDAO.findCarById(id);
        carDAO.delete(car);
        return new RedirectView("/cars/all");
    }

    @PostMapping("/edit")
    public RedirectView editCar (Car car){
        carDAO.save(car);
        return new RedirectView("/cars/all");
    }

    @PostMapping("/add")
    public RedirectView addCar (Car car){
        carDAO.save(car);
        return new RedirectView("/cars/all");
    }


    @GetMapping("/all")
    public ModelAndView showAllCars(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("CarTable");
        modelAndView.addObject("cars", carDAO.findAll());
        return modelAndView;
    }

}
