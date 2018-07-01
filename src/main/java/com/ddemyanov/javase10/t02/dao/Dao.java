package com.ddemyanov.javase10.t02.dao;

import java.util.List;
import java.util.Optional;

public interface Dao <E, I extends Number> {

    E create(E entity);

    Optional <E> getById(I id);

    List <E> getAll();

    E update(E entity);

    Dao <E, I> deleteById(I id);

    Dao <E, I> delete(E entity);

    Dao <E, I> clear();

    I count();
}
