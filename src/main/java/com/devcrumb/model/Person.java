package com.devcrumb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/** Person entity */
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne(targetEntity=PersonType.class, optional=false)
    private PersonType personType;

    private Person() {}

    public Person(String name, PersonType personType) {
        this.name = name;
        this.personType = personType;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PersonType getPersonType() {
        return personType;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }

}
