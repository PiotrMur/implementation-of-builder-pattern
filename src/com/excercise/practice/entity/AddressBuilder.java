package com.excercise.practice.entity;

public class AddressBuilder {

    private final String street;
    private final String city;
    private final String streetNumber;
    private String district;

    public AddressBuilder(String street, String streetNumber, String city) {
        this.street = street;
        this.city = city;
        this.streetNumber = streetNumber;
    }

    public AddressBuilder district(String district){
        this.district = district;
        return this;
    }

    public Address build(){
        return new Address(street, streetNumber, city, district);
    }
}
