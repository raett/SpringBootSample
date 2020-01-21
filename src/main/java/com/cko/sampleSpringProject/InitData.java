package com.cko.sampleSpringProject;

import com.cko.sampleSpringProject.dao.*;
import com.cko.sampleSpringProject.model.*;
import com.cko.sampleSpringProject.service.AuthorityService;
import com.cko.sampleSpringProject.service.SMSCService;
import com.cko.sampleSpringProject.service.UserService;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Order;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    ClientOrderDAO clientOrderDAO;

    @Autowired
    EmployeesDAO employeesDAO;

    @Autowired
    DayDAO dayDAO;

    @Autowired
    BookDAO bookDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    Faker faker = new Faker();

    public void initData() {

        initEmpl();
        initOrders();
        initBooks();
//        initTime();
//        initCars();
    }

    private void initCars() {
        for (int i = 0;i < 10; i++) {
            Car car = new Car(faker.color().name(), faker.name().firstName(), i*5000);
            carDAO.save(car);

        }
    }

    private void initBooks(){
        for (int i = 0;i < 5; i++) {
            String fio = faker.name().fullName();
            String phoneNum = "+" + faker.phoneNumber().phoneNumber();

            int k = i + 1;
            String date = "2020-01-"+k;
            String typeOrder = faker.rickAndMorty().character();
            String gender = "M";
            String timeOrder = "21:30";
            String master = faker.name().firstName();
            Book book = new Book(fio, phoneNum, date, typeOrder, master, timeOrder, gender, i);
            bookDAO.save(book);
        }

    }
    private void initOrders() {


        for (int i = 0;i < 5; i++){
            String fio = faker.name().fullName();
            String phoneNum = "+" + faker.phoneNumber().phoneNumber();
            String pattern = "yyyy-MM-dd";

            String date = "2020-01-"+i;
            String typeOrder = faker.rickAndMorty().character();
            String gender = "M";
            ClientOrder order = new ClientOrder(fio, phoneNum, date, typeOrder, gender);
            clientOrderDAO.save(order);

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
