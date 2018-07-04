package com.ddemyanov.javase06.t04;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Заполните таблицу.
 * Interface | Основная функциональность | Примеры типичного использования
 * Set
 * List
 * Queue
 * Map
 */
public class CollectionsFunctions {
    /**
     * Представляет собой набор значений, без индекса, аналог математического множества, благодаря чему на позволяет
     * хранить в коллекции дубликаты.
     */
    public static void main(String[] args) {
        Method[] methods = Map.class.getMethods();
        for (Method m : methods) {
            System.out.println(m.getReturnType()
                                .getSimpleName() + " " + m.getName() + "(" + Arrays.toString(
                    m.getParameterTypes()).replaceAll("[\\[\\]]+", "") + " )");
        }
    }

}
