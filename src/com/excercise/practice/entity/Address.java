package com.excercise.practice.entity;

public class Address {

    private final String street;
    private final String city;
    private final int streetNumber;
    private String district;

    public Address(String street, int streetNumber, String city, String district) {
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

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getDistrict() {
        return district;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", streetNumber=" + streetNumber +
                ", district='" + district + '\'' +
                '}';
    }
}
