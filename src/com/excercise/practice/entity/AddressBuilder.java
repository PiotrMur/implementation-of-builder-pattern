package com.excercise.practice.entity;

public class AddressBuilder {

    private final String street;
    private final String city;
    private final int streetNumber;
    private String district;

    public AddressBuilder(String street, int streetNumber, String city) {
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
