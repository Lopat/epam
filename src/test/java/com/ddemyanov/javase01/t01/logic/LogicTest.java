package com.ddemyanov.javase01.t01.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogicTest {

    private Logic logic = new Logic();

    @Test
    public void method1() {
        assertEquals("I am string in logic", logic.method());
    }
}