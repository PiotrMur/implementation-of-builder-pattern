package com.excercise.practice.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MyMapTest {

    private Repository<Integer, String> repository;

    @BeforeEach
    void initializeMyMap() {
        repository = new MyMap<>();
    }

    @Test
    void initializedMapIsEmpty() {

        //when
        List<String> values = repository.findAll();


        //then
        assertThat(values).isEmpty();

    }

    @Test
    void findExistingElement() {

        //given

        repository.save(1, "Piotr");
        repository.save(2, "Tomasz");

        //when
        Optional<String> empName = repository.findBy(1);

        //then
        assertThat(empName).hasValue("Piotr");

        //when
        List<String> names = repository.findAll();

        //then
        assertThat(names).containsExactlyInAnyOrder("Piotr","Tomasz");


    }

    @Test
    void findingNotExistingElement() {
        //given
        repository.save(2, "Adam");

        //when
        Optional<String> employeeValue = repository.findBy(1);

        //then
        assertThat(employeeValue).isEmpty();

    }

    @Test
    void removingElement() {
        //given

        repository.save(1, "Piotr");
        repository.save(2, "Tomasz");

        //when
        Optional<String> exisitingName = repository.findBy(1);
        assertThat(exisitingName).hasValue("Piotr");


        //when
        long count = repository.remove(1);

        //then
        assertThat(count).isOne();
        
        Optional<String> notExisitingName = repository.findBy(1);
        assertThat(notExisitingName).isEmpty();

        List<String> names = repository.findAll();
        assertThat(names).containsExactlyInAnyOrder("Tomasz");


    }

    @Test
    void removingNonExistingElement(){
        //given
        repository.save(1, "Piotr");

        //when
        long count = repository.remove(3);
        
        //then
        assertThat(count).isZero();

    }

    @Test
    void removingAllElements(){
        //given
        repository.save(1, "Piotr");
        repository.save(2, "Tomasz");

        //when
        repository.removeAll();

        //then
        List<String> names = repository.findAll();
        assertThat(names).isEmpty();
    }

    //dopisać test remove all
    //sprawdzić usuwanie nieistniejącego elementu. Dodać optionala w findBy



    //zastanów się nad metodą execute on Each

}