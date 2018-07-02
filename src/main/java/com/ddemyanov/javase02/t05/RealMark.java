package com.ddemyanov.javase02.t05;

public enum RealMark implements Mark {

    CREDITED("3"),
    NOT_CREDITED("1");

    String markString;

    RealMark(String markString) {
        this.markString = markString;
    }

    @Override
    public String getMarkString() {
        return markString;
    }
}
