package com.cko.sampleSpringProject;

import com.cko.sampleSpringProject.dao.CarDAO;
import com.cko.sampleSpringProject.dao.DayDAO;
import com.cko.sampleSpringProject.dao.EmployeesDAO;
import com.cko.sampleSpringProject.model.*;
import com.cko.sampleSpringProject.service.AuthorityService;
import com.cko.sampleSpringProject.service.SMSCService;
import com.cko.sampleSpringProject.service.UserService;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.random;

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
    EmployeesDAO employeesDAO;

    @Autowired
    DayDAO dayDAO;



    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    Faker faker = new Faker();

    public void initData() {

        initEmpl();

        initTime();
//        initCars();
    }

    private void initCars() {
        for (int i = 0;i < 10; i++) {
            Car car = new Car(faker.color().name(), faker.name().firstName(), i*5000);
            carDAO.save(car);

        }
    }
    private void initEmpl() {
        for (int i = 0;i < 10; i++) {
            String fio = faker.name().fullName();
            String phoneNum = "+" + faker.phoneNumber().phoneNumber();
            Employe empl= new Employe(fio, phoneNum, i );
            employeesDAO.save(empl);
        }
    }
    private void initTime() {
        LocalDate today = LocalDate.now();
        int dayOfweek = today.getDayOfWeek().getValue();

        switch (dayOfweek) {
            case 1:

                for(int i = 0; i < 5; i++){
                    String thisDay = today.plusDays(i).getDayOfMonth() + "." + today.getMonth().getValue();
                    Day newDay = new Day(thisDay);
                    dayDAO.save(newDay);
                }
                break;
            case 2:
                for(int i = 0; i < 4; i++) {
                    String thisDay = today.plusDays(i).getDayOfMonth() + "." + today.getMonth().getValue();
                    Day newDay = new Day(thisDay);
                    dayDAO.save(newDay); }
                for(int i = 6; i < 7; i++) {
                    String thisDay = today.plusDays(6).getDayOfMonth() + "." + today.getMonth().getValue();
                    Day newDay = new Day(thisDay);
                    dayDAO.save(newDay);
                }

                break;
            case 3:
                for(int i = 0; i < 3; i++){
                    String thisDay = today.plusDays(i).getDayOfMonth() + "." + today.getMonth().getValue();
                    Day newDay = new Day(thisDay);
                    dayDAO.save(newDay);
                }
                for(int i = 5; i < 7; i++) {
                    String thisDay = today.plusDays(i).getDayOfMonth() + "." + today.getMonth().getValue();
                    Day newDay = new Day(thisDay);
                    dayDAO.save(newDay);
                }
                break;
            case 4:
                for(int i = 0; i < 2; i++){
                    String thisDay = today.plusDays(i).getDayOfMonth() + "." + today.getMonth().getValue();
                    Day newDay = new Day(thisDay);
                    dayDAO.save(newDay);
                }
                for(int i = 4; i < 7; i++) {
                    String thisDay = today.plusDays(i).getDayOfMonth() + "." + today.getMonth().getValue();
                    Day newDay = new Day(thisDay);
                    dayDAO.save(newDay);
                }
                break;
            case 5:
                for(int i = 0; i < 1; i++){
                    String thisDay = today.plusDays(i).getDayOfMonth() + "." + today.getMonth().getValue();
                    Day newDay = new Day(thisDay);
                    dayDAO.save(newDay);
                }
                for(int i = 3; i < 7; i++) {
                    String thisDay = today.plusDays(i).getDayOfMonth() + "." + today.getMonth().getValue();
                    Day newDay = new Day(thisDay);
                    dayDAO.save(newDay);
                }
                break;
            case 6:

                for(int i = 2; i < 7; i++) {
                    String thisDay = today.plusDays(i).getDayOfMonth() + "." + today.getMonth().getValue();
                    Day newDay = new Day(thisDay);
                    dayDAO.save(newDay);
                }
                break;
            case 7:

                for(int i = 1; i < 6; i++) {
                    String thisDay = today.plusDays(i).getDayOfMonth() + "." + today.getMonth().getValue();
                    Day newDay = new Day(thisDay);
                    dayDAO.save(newDay);
                }
                break;
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
