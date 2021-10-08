package com.example.demo.services.impl;

import com.example.demo.models.Person;
import com.example.demo.repositories.impl.PersonRepository;
import com.example.demo.services.Service;

import java.util.List;

public class PersonService implements Service {
    private final PersonRepository repository;

    public PersonService() {
        repository = new PersonRepository();
    }

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean save(Person person) {
        if (person == null) throw new NullPointerException("Person cannot be null");

        return repository.save(person);
    }

    @Override
    public boolean edit(Person oldPerson, Person newPerson) {
        Person toEdit = repository.get(oldPerson);
        if (toEdit == null) return false;

        toEdit.setNumber(newPerson.getNumber());
        toEdit.setNameAndSurname(newPerson.getNameAndSurname());

        return true;
    }

    @Override
    public Person getByNumber(String number) {
        Person person = repository.getByNumber(number);

        if (person == null) throw new IllegalArgumentException();
        return person;
    }

    @Override
    public Person getByName(String name) {
        Person person = repository.getByName(name);

        if (person == null) throw new IllegalArgumentException();
        return person;
    }

    @Override
    public Person getById(int id) {
        Person person = repository.getById(id);

        if (person == null) throw new IllegalArgumentException();
        return person;
    }

    @Override
    public boolean remove(Person person) {
        return repository.remove(person);
    }

    @Override
    public boolean removeById(int id) {
        return repository.removeById(id);
    }

    @Override
    public List<Person> getAll() {
        return repository.getAll();
    }
}
