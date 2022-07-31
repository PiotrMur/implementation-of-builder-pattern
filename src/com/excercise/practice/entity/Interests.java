package com.excercise.practice.entity;

public class Interests {

    private final String workRelated;
    private final String hobbyRelated;
    private String unknown;

    public Interests(String workRelated, String hobbyRelated, String unknown) {
        this.workRelated = workRelated;
        this.hobbyRelated = hobbyRelated;
        this.unknown = unknown;
    }

    public String getWorkRelated() {
        return workRelated;
    }

    public String getHobbyRelated() {
        return hobbyRelated;
    }

    public String getUnknown() {
        return unknown;
    }

    @Override
    public String toString() {
        return workRelated + " " + hobbyRelated + " " + unknown;
    }
}
