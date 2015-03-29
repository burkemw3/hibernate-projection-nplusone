package com.devcrumb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** Person Type entity */
@Entity
public class PersonType {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private PersonType() {}

    public PersonType(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonType [id=" + id + ", name=" + name + "]";
    }

}
