package com.ddemyanov.javase02.t05;

public enum WholeMark implements Mark {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5");

    final String markString;

    WholeMark(String markString) {
        this.markString = markString;
    }

    @Override
    public String getMarkString() {
        return markString;
    }
}
