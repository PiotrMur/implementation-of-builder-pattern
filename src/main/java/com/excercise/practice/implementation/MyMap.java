package com.excercise.practice.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class MyMap<I,V> implements Repository<I,V>{


    Map<I,V> data = new HashMap<>();

    @Override
    public V findBy(I id) {
        return data.get(id);
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
        data.put(id,value);
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
    public void remove(I id) {
        data.remove(id);
    }
}
