package com.excercise.practice;

import com.excercise.practice.entity.Occupation;
import com.excercise.practice.entity.OccupationBuilder;
import com.excercise.practice.entity.PersonalData;

public class Main {



    public static void main(String[] args) {

        var personalData1 = new PersonalData("Piotr", "Michalski", "23");
        var personalData2 = new PersonalData("Piotr", "Michalski", "23");
        var ocupation1 = new Occupation("CS", "Intive");
        var ocupation2 = new Occupation("CS", "Intive");



        System.out.println(personalData1.equals(personalData2));
        System.out.println(ocupation1.equals(ocupation2));
        System.out.println();
    }
}
