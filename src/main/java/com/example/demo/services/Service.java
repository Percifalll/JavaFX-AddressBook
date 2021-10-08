package com.example.demo.services;

import com.example.demo.models.Person;

import java.util.List;

public interface Service {
    boolean save(Person person);

    boolean edit(Person oldPerson, Person newPerson);

    Person getByNumber(String number);

    Person getByName(String name);

    Person getById(int id);

    boolean remove(Person person);

    boolean removeById(int id);

    List<Person> getAll();
}
