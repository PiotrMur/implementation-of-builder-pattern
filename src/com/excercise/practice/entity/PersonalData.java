package com.excercise.practice.entity;

public class PersonalData {

    private final String firstName;
    private final String lastName;
    private int age;

    public PersonalData(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + age;
    }
}
