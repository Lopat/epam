package com.ddemyanov.javase02.t02.stationery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = false)
@AllArgsConstructor
public abstract class Stationery {

    private int price;
    private String producerName;
}
