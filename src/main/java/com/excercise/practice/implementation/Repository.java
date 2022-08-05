package com.excercise.practice.implementation;

import java.util.List;
import java.util.function.BiConsumer;

public interface Repository<I,V> {

    V findBy(I id);

    void executeOnEach(BiConsumer<? super I, ? super V> action);

    List<V> findAll();

    void save(I id, V value);

    boolean exists(I id);

    void removeAll();

    void remove(I id);


}
