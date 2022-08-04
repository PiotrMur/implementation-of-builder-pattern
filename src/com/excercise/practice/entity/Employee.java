package com.excercise.practice.entity;

import java.util.UUID;

public class Employee {

    private PersonalData personalData;
    private Address address;
    private Occupation occupation;
    private final UUID id = UUID.randomUUID();


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

    public UUID getId() {
        return id;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return personalData + " " + address + " " + occupation;

    }
}
