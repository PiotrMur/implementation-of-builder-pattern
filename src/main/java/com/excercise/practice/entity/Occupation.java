package com.excercise.practice.entity;

public class Occupation {

    private String education;
    private String company;

    public Occupation(String education, String company) {
        this.education = education;
        this.company = company;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return education + " " + company;
    }
}
