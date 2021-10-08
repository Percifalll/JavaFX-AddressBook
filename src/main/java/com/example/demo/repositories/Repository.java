package com.example.demo.repositories;

import com.example.demo.models.Person;

import java.util.List;

public interface Repository {
    boolean save(Person person);
    Person get(Person person);
    Person getByNumber(String number);
    Person getByName(String name);
    Person getById(int id);
    boolean remove(Person person);
    boolean removeById(int id);
    List<Person> getAll();
}
