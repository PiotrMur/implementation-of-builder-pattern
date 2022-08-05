package com.excercise.practice.builder;

import com.excercise.practice.entity.Interests;

public class InterestsBuilder {

    private final String workRelated;
    private final String hobbyRelated;
    private String unknown;

    public InterestsBuilder(String workRelated, String hobbyRelated) {
        this.workRelated = workRelated;
        this.hobbyRelated = hobbyRelated;
    }

    public InterestsBuilder unknown(String unknown){
        this.unknown = unknown;
        return this;
    }

    public Interests build(){
        return new Interests(workRelated, hobbyRelated, unknown);
    }
}
