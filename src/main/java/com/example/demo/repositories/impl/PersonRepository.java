package com.example.demo.repositories.impl;

import com.example.demo.models.Person;
import com.example.demo.repositories.Repository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonRepository implements Repository {
    private final ObservableList<Person> people;

    public PersonRepository() {
        people = FXCollections.observableArrayList();
    }

    @Override
    public boolean save(Person person) {
        return people.add(person);
    }

    @Override
    public Person get(Person person){
        return people.stream()
                .filter(p -> p.equals(person))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Person getByNumber(String number) {
        return people.stream()
                .filter(p -> p.getNumber().equals(number))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Person getByName(String name) {
        return people.stream()
                .filter(p -> p.getNameAndSurname().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Person getById(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean remove(Person person) {
        return people.remove(person);
    }

    @Override
    public boolean removeById(int id) {
        return people.remove(getById(id));
    }

    @Override
    public ObservableList<Person> getAll() {
        return people;
    }
}
