package com.excercise.practice.entity;

import java.util.Objects;
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

    /*@Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Employee)) return false;

        Employee that = (Employee) obj;

        return(personalData.equals(that.personalData)
                && address.equals(that.address)
                && occupation.equals(that.occupation)
                && !(id.equals(that.id)));
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(personalData, employee.personalData)
                && Objects.equals(address, employee.address)
                && Objects.equals(occupation, employee.occupation)
                && Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalData, address, occupation, id);
    }
}
