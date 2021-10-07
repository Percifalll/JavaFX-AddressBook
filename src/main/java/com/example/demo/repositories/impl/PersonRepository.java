package com.example.demo.repositories.impl;

import com.example.demo.models.Person;
import com.example.demo.repositories.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PersonRepository implements Repository {
    private Set<Person> people;

    public PersonRepository() {
        people = new TreeSet<>();
    }

    @Override
    public boolean save(Person person) {
        return people.add(person);
    }

    @Override
    public Person getById(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public boolean remove(int id) {
        return people.remove(getById(id));
    }

    @Override
    public List<Person> getAll() {
        return new ArrayList<>(people);
    }
}
