package com.excercise.practice.entity;

public class PersonalDataBuilder {

    private final String firstName;
    private final String lastName;
    private int age;

    public PersonalDataBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonalDataBuilder age(int age){
        this.age = age;
        return this;
    }

    public PersonalData build(){
        return new PersonalData(firstName, lastName, age);
    }
}
