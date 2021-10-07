package com.example.demo.repositories;

import com.example.demo.models.Person;

import java.util.List;

public interface Repository {
    boolean save(Person person);
    Person getById(int id);
    boolean remove(int id);
    List<Person> getAll();
}
