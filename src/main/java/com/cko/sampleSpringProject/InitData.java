package com.cko.sampleSpringProject;

import com.cko.sampleSpringProject.dao.CarDAO;
import com.cko.sampleSpringProject.model.Authority;
import com.cko.sampleSpringProject.model.Car;
import com.cko.sampleSpringProject.model.User;
import com.cko.sampleSpringProject.service.AuthorityService;
import com.cko.sampleSpringProject.service.SMSCService;
import com.cko.sampleSpringProject.service.UserService;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitData {

    @Autowired
    UserService userService;

    @Autowired
    AuthorityService authorityService;

    @Autowired
    SMSCService smscSender;

    @Autowired
    CarDAO carDAO;



    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    Faker faker = new Faker();

    public void initData() {

//        initUserAndRoles();
//        initCars();
    }

    private void initCars() {
        for (int i = 0;i < 10; i++) {
            Car car = new Car(faker.color().name(), faker.name().firstName(), i*5000);
            carDAO.save(car);

        }
    }


    private void initUserAndRoles(){
        Authority adminAuthority = new Authority("ROLE_ADMIN");
        Authority userAuthority = new Authority("ROLE_USER");
        authorityService.insert(adminAuthority);
        authorityService.insert(userAuthority);

        List<Authority> authorities = new ArrayList<Authority>();
        authorities.add(adminAuthority);
        userService.insert(new User("1@mail.ru",bCryptPasswordEncoder.encode("1"), authorities));


    }
}
