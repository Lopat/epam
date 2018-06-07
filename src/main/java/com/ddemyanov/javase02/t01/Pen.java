package com.ddemyanov.javase02.t01;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Pen {

    private String producerName;
    private InkColor inkColor;

    enum InkColor{
        BLUE,
        BLACK,
        GREEN,
        RED
    }
}
