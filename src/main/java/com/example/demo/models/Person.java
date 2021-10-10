package com.example.demo.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private static int counter = 0;

    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty number;

    public Person() {
        id = new SimpleIntegerProperty();
        name = new SimpleStringProperty();
        number = new SimpleStringProperty();
        id.set(++counter);
    }

    public Person(String nameAndSurname, String number) {
        this();
        this.name.set(nameAndSurname);
        this.number.set(number);
    }

    public int getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getNumber() {
        return number.get();
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    @Override
    public int compareTo(Person o) {
        return id.get() - o.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(number, person.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty numberProperty() {
        return number;
    }
}
