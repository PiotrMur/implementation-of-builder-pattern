package com.excercise.practice.entity;

public class OccupationBuilder {

    private final String education;
    private String company;

    public OccupationBuilder(String education) {
        this.education = education;
    }

    public OccupationBuilder company(String company){
        this.company = company;
        return this;
    }

    public Occupation build(){
        return new Occupation(education, company);
    }

}
