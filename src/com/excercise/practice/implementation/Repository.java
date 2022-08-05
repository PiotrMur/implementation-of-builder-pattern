package com.excercise.practice.implementation;

import java.util.function.BiConsumer;

public interface Repository<I,V> {

    V getValue(I key);

    void forEach(BiConsumer<? super I, ? super V> action);

    void save(I key, V value);

    boolean isKey(I key);

    boolean isValue(V value);

    void clear();

    void remove(I id);


}
