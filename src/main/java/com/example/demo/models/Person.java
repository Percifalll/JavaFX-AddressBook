package com.example.demo.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private static int counter = 0;

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty nameAndSurname;
    private final SimpleStringProperty number;

    public Person() {
        id = new SimpleIntegerProperty();
        nameAndSurname = new SimpleStringProperty();
        number = new SimpleStringProperty();
        id.set(++counter);
    }

    public Person(String nameAndSurname, String number) {
        this();
        this.nameAndSurname.set(nameAndSurname);
        this.number.set(number);
    }

    public int getId() {
        return id.get();
    }

    public String getNameAndSurname() {
        return nameAndSurname.get();
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname.set(nameAndSurname);
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
        return Objects.equals(nameAndSurname, person.nameAndSurname) && Objects.equals(number, person.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameAndSurname, number);
    }
}
