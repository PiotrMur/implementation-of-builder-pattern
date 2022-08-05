package com.excercise.practice.entity;

public class Address {

    private String street;
    private String city;
    private String streetNumber;
    private String district;

    public Address(String street, String streetNumber, String city, String district) {
        this.street = street;
        this.city = city;
        this.streetNumber = streetNumber;
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return street +" " + city +" "+ streetNumber +" "+ district;
    }
}
