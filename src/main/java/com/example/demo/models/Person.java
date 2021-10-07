package com.example.demo.models;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private static int counter = 0;

    private int id;
    private String nameAndSurname;
    private String number;

    public Person() {
        id = ++counter;
    }

    public Person(String nameAndSurname, String number) {
        id = ++counter;
        this.nameAndSurname = nameAndSurname;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int compareTo(Person o) {
        return id - o.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
