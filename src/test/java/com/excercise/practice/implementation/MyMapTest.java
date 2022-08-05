package com.excercise.practice.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyMapTest {

    private Repository<Integer, String> repository;

    @BeforeEach
    void initializeMyMap(){
        repository = new MyMap<>();
    }

    @Test
    void checkEmptyMap(){

        //when
        List<String> values = repository.findAll();


        //then
        assertThat(values).isEmpty();

    }

    @Test
    void findingElement(){ //stworz mape, dodaj element, znajdz element, sprawdz czy jest taki jaki dodalismy
        //zaczynaj od pisania sciezek happy path a potem sobie to komplikuj
        //najpeirw sprawdzamy czy wszytko dziala, a potem sprawdzamy co moze nie zadzialac

        //given

        repository.save(1,"Piotr");
        repository.save(2,"Tomasz");

        //when
        String empName = repository.findBy(1);

        //then
        assertAll(
                () -> assertThat(empName).isNotEmpty(),
                () -> assertThat(empName).isEqualTo("Piotr")
        );


    }

    @RepeatedTest(2)
    void savingElementToMyMap(){
        //given
        repository.save(2,"Adam");

        //when
        String employeeValue = repository.findBy(2);

        //then
        assertAll(
                () -> assertThat(employeeValue).isNotEmpty(),
                () -> assertThat(employeeValue).isNotEqualTo("Piotr"),
                () -> assertThat(employeeValue).isEqualTo("Adam")
        );


    }



}