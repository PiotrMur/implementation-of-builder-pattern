package com.excercise.practice.implementation;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public interface Repository<I,V> {

    Optional<V> findBy(I id);

    void executeOnEach(BiConsumer<? super I, ? super V> action);

    List<V> findAll();

    void save(I id, V value);

    boolean exists(I id);

    void removeAll();

    long remove(I id);


}
