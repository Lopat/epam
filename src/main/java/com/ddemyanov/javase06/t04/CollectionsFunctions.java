package com.ddemyanov.javase06.t04;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.DelayQueue;

/**
 * Заполните таблицу.
 * Interface | Основная функциональность | Примеры типичного использования
 * Set
 * List
 * Queue
 * Map
 */
public class CollectionsFunctions {

    public static void main(String[] args) {
        Method[] methods = Map.class.getMethods();
        for (Method m : methods) {
            System.out.println(m.getReturnType()
                                .getSimpleName() + " " + m.getName() + "(" + Arrays.toString(
                    m.getParameterTypes()).replaceAll("[\\[\\]]+", "") + " )");
        }
    }

}
