package com.isa.restapidemo.dao;

import java.util.List;

public interface Dao<T> {

    void save(T t);

    void update(T t);

    void remove(T t);

    List<T> findAll();

}
