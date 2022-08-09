package com.excercise.practice.implementation;

import java.util.*;
import java.util.function.BiConsumer;

import static java.util.Optional.ofNullable;

public class MyMap<I, V> implements Repository<I, V> {

    private final Map<I, V> data = new HashMap<>();

    @Override
    public Optional<V> findBy(I id) {
        return ofNullable(data.get(id));
    }

    @Override
    public void executeOnEach(BiConsumer<? super I, ? super V> action) {
        data.forEach(action);
    }

    @Override
    public List<V> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public void save(I id, V value) {
        data.put(id, value);
    }

    @Override
    public boolean exists(I id) {
        return data.containsKey(id);
    }


    @Override
    public void removeAll() {
        data.clear();
    }

    @Override
    public long remove(I id) {
        return data.remove(id) == null ? 0 : 1;
    }
}
