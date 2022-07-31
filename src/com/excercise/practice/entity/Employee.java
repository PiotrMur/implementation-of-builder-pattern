package com.excercise.practice.entity;

public class Employee {

    private final PersonalData personalData;
    private final Address address;
    private final Occupation occupation;

    public Employee(PersonalData personalData, Address address, Occupation occupation) {
        this.personalData = personalData;
        this.address = address;
        this.occupation = occupation;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public Address getAddress() {
        return address;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    @Override
    public String toString() {
        return personalData + " " + address + " " + occupation;

    }
}
