package com.ddemyanov.javase07.t03;

import java.util.ArrayList;
import java.util.List;

class SharedResource {

    private List <Integer> list;

    SharedResource() {
        list = new ArrayList <>();
    }

    void setElement(Integer element) {
        list.add(element);
    }

    Integer getElement() {
        return (!list.isEmpty()) ? list.remove(0) : null;
    }
}