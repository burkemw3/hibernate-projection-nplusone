package com.devcrumb;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.devcrumb.dao.PersonDaoImpl;
import com.devcrumb.model.Person;
import com.devcrumb.model.PersonType;

/** App class with main method to test our DAO */
public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        PersonDaoImpl dao = (PersonDaoImpl) context.getBean("personDao");

        PersonType typeA = new PersonType("A");
        PersonType typeB = new PersonType("B");
        PersonType typeC = new PersonType("C");

        dao.save(typeA);
        dao.save(typeB);
        dao.save(typeC);

        Person peter = new Person("Peter Sagan", typeA);
        Person nasta = new Person("Nasta Kuzminova", typeA);
        Person bcharkley = new Person("Barles Charkley", typeB);
        Person mblackman = new Person("Mars Blackman", typeC);

        dao.save(peter);
        dao.save(nasta);
        dao.save(bcharkley);

        List<PersonType> personTypes = dao.getPersonTypes("e");
        for (PersonType type : personTypes) {
            System.out.println(type);
        }
        context.close();
    }
}
