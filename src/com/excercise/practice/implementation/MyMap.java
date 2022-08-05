package com.excercise.practice.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MyMap<I,V> implements Repository<I,V>{

    Map<I,V> data = new HashMap<>();

    @Override
    public V getValue(I id) {
        return data.get(id);
    }

    @Override
    public void forEach(BiConsumer<? super I, ? super V> action) {
        data.forEach(action);
    }

    @Override
    public void save(I id, V value) {
        data.put(id,value);
    }

    @Override
    public boolean isKey(I id) {
        return data.containsKey(id);
    }

    @Override
    public boolean isValue(V value) {
        return data.containsValue(value);
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public void remove(I id) {
        data.remove(id);
    }
}
