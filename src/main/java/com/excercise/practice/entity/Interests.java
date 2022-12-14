package com.excercise.practice.entity;

public class Interests {

    private String workRelated;
    private String hobbyRelated;
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

    public void setWorkRelated(String workRelated) {
        this.workRelated = workRelated;
    }

    public void setHobbyRelated(String hobbyRelated) {
        this.hobbyRelated = hobbyRelated;
    }

    public void setUnknown(String unknown) {
        this.unknown = unknown;
    }

    @Override
    public String toString() {
        return workRelated + " " + hobbyRelated + " " + unknown;
    }
}
