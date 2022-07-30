package com.excercise.practice.entity;

public class Occupation {

    private final String education;
    private String company;

    public Occupation(String education, String company) {
        this.education = education;
        this.company = company;
    }

    public String getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Occupation{" +
                "education='" + education + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
