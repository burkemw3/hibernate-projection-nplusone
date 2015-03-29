package com.devcrumb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.devcrumb.model.Person;
import com.devcrumb.model.PersonType;

/** DAO implementation for Person entity */
@Transactional
public class PersonDaoImpl {

    @Autowired
    protected SessionFactory _sessionFactory;

    public void save(PersonType personType) {
        _sessionFactory.getCurrentSession().save(personType);
    }

	public void save(Person person) {
        _sessionFactory.getCurrentSession().save(person);
    }

    public List<PersonType> getPersonTypes(String nameContains) {
        return _sessionFactory.getCurrentSession().createCriteria(Person.class)
                .add(Restrictions.like("name", "%" + nameContains + "%"))
                .setProjection(Projections.distinct(Projections.property("personType")))
                .list()
                ;
    }

}
